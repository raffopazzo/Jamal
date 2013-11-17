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
import it.hysteresis.jamal.Form;

public class FormTest extends JamalTestCase {

  public void testCreateEmptyForm() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\"/>");
    // exercise
    _widget.form();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testChangeMethodToGet() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"get\"/>");
    // exercise
    _widget.form().setMethod(Form.Method.get);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testResetMethodToPost() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\"/>");
    // exercise
    _widget.form().setMethod(Form.Method.get)
                  .setMethod(Form.Method.post);
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

  public void testOverwriteSubmitButton() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input type=\"submit\""+
                                          "       value=\"dummy-2\"/>"+
                                          "</form>");
    // exercise
    _widget.form().submit("dummy-1").setValue("dummy-2");
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

  public void testCreateStandardInput() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateStandardInputWithDefaultValue() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy-1\""+
                                          "       value=\"dummy-2\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input("dummy-1", "dummy-2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testOverwriteInputValue() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy-1\""+
                                          "       value=\"dummy-3\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input("dummy-1", "dummy-2").setValue("dummy-3");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testOverwriteInputFromDictionary() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy-1\""+
                                          "       value=\"LABEL_0\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input("dummy-1", "dummy-2").setValue(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

