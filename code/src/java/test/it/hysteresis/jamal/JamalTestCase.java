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
package test.it.hysteresis.jamal;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import it.hysteresis.jamal.Widget;
import test.it.hysteresis.jamal.i18n.StubDictionary;

import junit.framework.TestCase; 

public class JamalTestCase  extends TestCase {

  enum FakeEnums {
    LABEL_0,
    LABEL_1;
  };

  protected DocumentBuilder _docBuilder;
  protected Widget _widget;

  @Override
  protected void setUp() throws Exception { 
    setUpDocumentBuilder();
    _widget = new Widget(new StubDictionary());
    
  }

  public void setUpDocumentBuilder() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    /* Turn validation off, otherwise DocumentBuilder.parse() will download
       the DTDs and validate the document. This may take a couple of minutes,
       which isn't acceptable in these unit tests. */
    factory.setValidating(false);
    factory.setFeature("http://xml.org/sax/features/namespaces", false);
    factory.setFeature("http://xml.org/sax/features/validation", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    _docBuilder = factory.newDocumentBuilder();
  }

  static protected String wrapHtml(String html) {
    return "<div class=\"jamal-widget\">"+html+"</div>";
  }

  protected void assertEquvalentToHtml(String equivalentHtml, Widget widget)
  throws Exception {
    String actualHtml = widget.toString();
    Document expected = parseHtml(equivalentHtml);
    Document actual = parseHtml(actualHtml);
    if (! expected.isEqualNode(actual)) {
      fail("HTML are not equivalent:\n"+
           "--- Expected ---\n"+
           equivalentHtml+"\n"+
           "--- but  was ---\n"+
           actualHtml+"\n"+
           "----------------\n");
    }
  }

  protected void assertEquvalentToHtml(String equivalentHtml) throws Exception {
    assertEquvalentToHtml(equivalentHtml, _widget);
  }

  private Document parseHtml(String html) throws Exception {
    return _docBuilder.parse(new InputSource(new StringReader(html)));
  }
}
