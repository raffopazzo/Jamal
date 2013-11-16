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

public class ButtonTest extends JamalTestCase {

  public void testCreateEmptyButton() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\">"+
                                           "<div class=\"jamal-button-icon\"/>"+
                                           "<div class=\"jamal-button-text\"/>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetButtonId() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\""+
                                           "     id=\"dummy\">"+
                                           "<div class=\"jamal-button-icon\"/>"+
                                           "<div class=\"jamal-button-text\"/>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#").setId("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddButtonClass() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button dummy\">"+
                                           "<div class=\"jamal-button-icon\"/>"+
                                           "<div class=\"jamal-button-text\"/>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#").addClassName("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }


  public void testCreateButtonWithText() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\">"+
                                           "<div class=\"jamal-button-icon\"/>"+
                                           "<div class=\"jamal-button-text\">"+
                                           "dummy"+
                                           "</div>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#", "dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateButtonWithTextAndIcon() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\">"+
                                           "<div class=\"jamal-button-icon\">"+
                                           "+"+
                                           "</div>"+
                                           "<div class=\"jamal-button-text\">"+
                                           "dummy"+
                                           "</div>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#", "+", "dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testRetrieveButtonTextFromDictionary() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\">"+
                                           "<div class=\"jamal-button-icon\"/>"+
                                           "<div class=\"jamal-button-text\">"+
                                           "LABEL_0"+
                                           "</div>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testRetrieveButtonTextAndIconFromDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\">"+
                                           "<div class=\"jamal-button-icon\">"+
                                           "LABEL_0"+
                                           "</div>"+
                                           "<div class=\"jamal-button-text\">"+
                                           "LABEL_1"+
                                           "</div>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#", FakeEnums.LABEL_0, FakeEnums.LABEL_1);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testRetrieveButtonIconFromDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">"+
                                           "<div class=\"jamal-button\">"+
                                           "<div class=\"jamal-button-icon\">"+
                                           "LABEL_0"+
                                           "</div>"+
                                           "<div class=\"jamal-button-text\">"+
                                           "dummy"+
                                           "</div>"+
                                           "</div>"+
                                           "</a>"); 
    // exercise
    _widget.button("#", FakeEnums.LABEL_0, "dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }
}

