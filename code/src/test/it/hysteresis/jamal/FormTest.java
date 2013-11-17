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
import it.hysteresis.jamal.Widget;

public class FormTest extends JamalTestCase {

  public void testCreateEmptyForm() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\"/>");
    // exercise
    _widget.form();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateGetForm() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"get\"/>");
    // exercise
    _widget.form().setAttribute(Widget.HTML_FORM_METHOD,
                                Widget.HTML_FORM_METHOD_GET);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendSubmitButton() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input type=\"submit\"/>"+
                                          "</form>");
    // exercise
    _widget.form().submit();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendSubmitButtonWithCustomText() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input type=\"submit\""+
                                          "       value=\"dummy\"/>"+
                                          "</form>");
    // exercise
    _widget.form().submit("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testRetrieveSubmitButtonTextFromDictionary() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input type=\"submit\""+
                                          "       value=\"LABEL_0\"/>"+
                                          "</form>");
    // exercise
    _widget.form().submit(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

