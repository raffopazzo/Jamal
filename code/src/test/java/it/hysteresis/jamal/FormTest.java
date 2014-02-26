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
import it.hysteresis.jamal.Input;

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

  public void testSetAction() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\""+
                                          "      action=\"dummy\"/>");
    // exercise
    _widget.form().setAction("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateInputLabel() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<label for=\"dummy-1\">"+
                                          "dummy-2"+
                                          "</label>"+
                                          "</form>");
    // exercise
    _widget.form().label("dummy-1", "dummy-2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateInputLabelFromDictionary() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<label for=\"dummy\">"+
                                          "LABEL_0"+
                                          "</label>"+
                                          "</form>");
    // exercise
    _widget.form().label("dummy", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateEmptySelect() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy\"/>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateSelectWithOption() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy-1\">"+
                                          "<option value=\"dummy-2\">"+
                                          "dummy-3"+
                                          "</option>"+
                                          "</select>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy-1").option("dummy-2", "dummy-3");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateSelectWithOptionFromDictionary() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy-1\">"+
                                          "<option value=\"dummy-2\">"+
                                          "LABEL_0"+
                                          "</option>"+
                                          "</select>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy-1").option("dummy-2", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateSelectWithOptionGroup() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy-1\">"+
                                          "<optgroup label=\"dummy-2\">"+
                                          "<option value=\"dummy-3\">"+
                                          "dummy-4"+
                                          "</option>"+
                                          "</optgroup>"+
                                          "</select>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy-1").optgroup("dummy-2").option("dummy-3",
                                                                "dummy-4");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateSelectWithOptionGroupFromDictionary() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy-1\">"+
                                          "<optgroup label=\"LABEL_0\">"+
                                          "<option value=\"dummy-2\">"+
                                          "dummy-3"+
                                          "</option>"+
                                          "</optgroup>"+
                                          "</select>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy-1")
                  .optgroup(FakeEnums.LABEL_0)
                  .option("dummy-2", "dummy-3");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateSelectWithOptionSelected() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy-1\">"+
                                          "<option selected=\"selected\""+
                                          "        value=\"dummy-2\">"+
                                          "dummy-3"+
                                          "</option>"+
                                          "</select>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy-1")
                  .option("dummy-2", "dummy-3").select();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testDeselectOptoin() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<select name=\"dummy-1\">"+
                                          "<option value=\"dummy-2\">"+
                                          "dummy-3"+
                                          "</option>"+
                                          "</select>"+
                                          "</form>");
    // exercise
    _widget.form().select("dummy-1")
                  .option("dummy-2", "dummy-3").select().setSelected(false);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateTextArea() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<textarea name=\"dummy\"/>"+
                                          "</form>");
    // exercise
    _widget.form().textarea("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateCheckbox() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"checkbox\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.checkbox, "dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCheckChekbox() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"checkbox\""+
                                          "       checked=\"checked\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.checkbox, "dummy").setChecked(true);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testTurnCheckboxOff() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"checkbox\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.checkbox, "dummy")
                  .setChecked(true)
                  .setChecked(false);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetInputMaxValue() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"number\""+
                                          "       max=\"10\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.number, "dummy").setMax(10);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetInputMinValue() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"number\""+
                                          "       min=\"10\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.number, "dummy").setMin(10);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetInputSetpValue() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"number\""+
                                          "       step=\"10\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.number, "dummy").setStep(10);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetInputSetpValueAsDouble() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"number\""+
                                          "       step=\"0.1\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.number, "dummy").setStep(0.1);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetInputPlaceholder() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"text\""+
                                          "       placeholder=\"dummy-2\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.text, "dummy").setPlaceHolder("dummy-2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetInputPlaceholderFromDictionary() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<form method=\"post\">"+
                                          "<input name=\"dummy\""+
                                          "       type=\"text\""+
                                          "       placeholder=\"LABEL_0\"/>"+
                                          "</form>");
    // exercise
    _widget.form().input(Input.Type.text, "dummy")
                  .setPlaceHolder(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }
}

