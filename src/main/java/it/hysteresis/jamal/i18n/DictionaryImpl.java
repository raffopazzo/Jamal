/*
  Copyright 2013 Rossi Raffaele <rossi.raffaele@gmail.com>

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package io.jamal.i18n;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class DictionaryImpl implements Dictionary {

  private ResourceBundle _bundle;
  private DateFormat _dateFormat;
  public DictionaryImpl(DateFormat dateFormat, String fileName) {
    XMLResourceBundleControl xmlControl = new XMLResourceBundleControl();
    _bundle = ResourceBundle.getBundle(fileName, xmlControl);
    _dateFormat = dateFormat;
  }

  @Override
  public Text getText(Enum phrase) {
    return new Text( getLabel(phrase), _dateFormat );
  }

  @Override
  public String getLabel(String key) {
    return _bundle.getString(key);
  }

  @Override
  public String getLabel(Boolean value) {
    String key = Boolean.TRUE.equals(value) ?
      Boolean.class.getName()+".TRUE" :
      Boolean.class.getName()+".FALSE";
    return getLabel(key);
  }

  @Override
  public String getLabel(Enum enumValue) {
    if (enumValue != null) {
      return getLabel( enumValue.getClass().getName()+"."+enumValue.toString() );
    } else {
      return "";
    }
  }
}

class XMLResourceBundleControl extends ResourceBundle.Control {
  static private final String XML = "xml";

  public List<String> getFormats(String baseName) {
    return Collections.singletonList(XML);
  }

  public ResourceBundle newBundle(
      String baseName,
      Locale locale,
      String format,
      ClassLoader loader,
      boolean reload)
  throws IllegalAccessException, InstantiationException, IOException {

    if ((baseName == null) ||
        (locale == null) ||
        (format == null) ||
        (loader == null)) {
      throw new NullPointerException();
    }
    ResourceBundle bundle = null;
    if (!format.equals(XML)) {
      return null;
    }

    String bundleName = toBundleName(baseName, locale);
    String resourceName = toResourceName(bundleName, format);
    URL url = loader.getResource(resourceName);
    // NOTE: Early exit point
    if (url == null) return null;

    URLConnection connection = url.openConnection();
    // NOTE: Early exit point
    if (connection == null) return null;

    if (reload) {
      connection.setUseCaches(false);
    }
    InputStream stream = connection.getInputStream();
    // NOTE: Early exit point
    if (stream == null) return null;

    BufferedInputStream bis = new BufferedInputStream(stream);
    bundle = new XMLResourceBundle(bis);
    bis.close();

    return bundle;
  }
}

class XMLResourceBundle extends ResourceBundle {
  private Properties _props;

  XMLResourceBundle(InputStream stream) throws IOException {
    _props = new Properties();
    _props.loadFromXML(stream);
  }

  protected Object handleGetObject(String key) {
    return _props.getProperty(key);
  }

  public Enumeration<String> getKeys() {
    Set<String> handleKeys = _props.stringPropertyNames();
    return Collections.enumeration(handleKeys);
  }
}
