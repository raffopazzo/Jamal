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
package it.hysteresis.jamal.i18n;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

  static private final Pattern PARAMETER_EXTRACTOR =
    Pattern.compile("\\[([\\w\\.-]+)\\]");

  private  DateFormat _dateFormat;
  private  DateFormat _timeFormat;
  private String _text;
  public Text(String phrase, DateFormat dateFormat) {
    _text = phrase;
    _dateFormat = dateFormat;
    _timeFormat = new SimpleDateFormat("HH:mm");
  }

  public void setDateFormat(DateFormat dateFormat) {
    _dateFormat = dateFormat;
  }

  public List<String> getParametersName() {
    Matcher matcher = PARAMETER_EXTRACTOR.matcher(_text);
    List<String> parameters = new LinkedList<String>();
    while (matcher.find()) {
      parameters.add( matcher.group(1) );
    }
    return parameters;
  }

  /**
   * Replace the string "[arg]" with the given Object string
   * representation (i.e. toString() method ).
   */
  public Text arg(String arg, Object value) {
    String s;
    if (value == null) {
      s = "N/A";
    } else {
      if (value instanceof Date) {
        synchronized(_timeFormat) {
          s = _timeFormat.format( (Date)value );
        }
      } else if (value instanceof Calendar) {
        s = _dateFormat.format( ((Calendar)value).getTime() );
      } else {
        s = value.toString();
      }
    }
    _text = _text.replace("["+arg+"]",s);
    return this;
  }

  @Override
  public String toString() {
    return _text;
  }

}
