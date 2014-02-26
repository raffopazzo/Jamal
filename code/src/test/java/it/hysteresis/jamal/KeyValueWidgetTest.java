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

public class KeyValueWidgetTest extends JamalTestCase {

  public void testCreateKeyValueWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\"/>"); 
    // exercise
    _widget.keyValueWidget();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddKeyValuePair() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">Dummy 1</p>"+
                                           "<p class=\"jamal-value\">Dummy 2</p>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue("Dummy 1", "Dummy 2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddMultipleKeyValuePair() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">Dummy 1</p>"+
                                           "<p class=\"jamal-value\">Dummy 2</p>"+
                                           "</div>"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">Dummy 3</p>"+
                                           "<p class=\"jamal-value\">Dummy 4</p>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue("Dummy 1", "Dummy 2")
                            .addKeyValue("Dummy 3", "Dummy 4");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testLookUpKeyInDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">LABEL_0</p>"+
                                           "<p class=\"jamal-value\">Dummy 2</p>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue(FakeEnums.LABEL_0, "Dummy 2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testLookUpValueInDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">Dummy 1</p>"+
                                           "<p class=\"jamal-value\">LABEL_0</p>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue("Dummy 1", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testLookUpBothKeyAndValueInDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">LABEL_0</p>"+
                                           "<p class=\"jamal-value\">LABEL_1</p>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue(FakeEnums.LABEL_0, FakeEnums.LABEL_1);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAcceptWidgetAsValue() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">Dummy</p>"+
                                           "<div class=\"jamal-value\">"+
                                           "<div class=\"jamal-widget\"/>"+
                                           "</div>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue("Dummy", new Widget<Widget>());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testEnumAsKeyAndWidgetAsValue() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">LABEL_0</p>"+
                                           "<div class=\"jamal-value\">"+
                                           "<div class=\"jamal-widget\"/>"+
                                           "</div>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue(FakeEnums.LABEL_0, new Widget<Widget>());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testTakeOwnershipOfChildWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-key-value-widget\">"+
                                           "<div class=\"jamal-key-value-pair\">"+
                                           "<p class=\"jamal-key\">LABEL_0</p>"+
                                           "<div class=\"jamal-value\"><div/></div>"+
                                           "</div>"+
                                           "</div>"); 
    // exercise
    _widget.keyValueWidget().addKeyValue(FakeEnums.LABEL_0, _widget.div());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

