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

import it.hysteresis.jamal.WebPage;
import it.hysteresis.jamal.Widget;

import test.it.hysteresis.jamal.i18n.StubDictionary;

public class TabWidgetTest extends JamalTestCase {

  public void testCreateEmptyTabWidget() throws Exception {
    // setup
    String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-tab-widget\">"+
                                     "<div class=\"jamal-tab-list\"/>"+
                                     "<div class=\"jamal-tab-container\"/>"+
                                     "</div>");
    // exercise
    _widget.tabWidget();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddWidgetAsTab() throws Exception { 
    // setup
    String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-tab-widget\">"+
                                     "<div class=\"jamal-tab-list\">"+
                                     "<div class=\"jamal-tab\">"+
                                     "<div class=\"jamal-widget\"/>"+
                                     "</div>"+
                                     "</div>"+
                                     "<div class=\"jamal-tab-container\"/>"+
                                     "</div>");
    // exercise
    _widget.tabWidget().addTab(new Widget());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddMultipleTabs() throws Exception { 
    // setup
    String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-tab-widget\">"+
                                     "<div class=\"jamal-tab-list\">"+
                                     "<div class=\"jamal-tab\">"+
                                     "<div class=\"jamal-widget\"/>"+
                                     "</div>"+
                                     "<div class=\"jamal-tab\">"+
                                     "<div class=\"jamal-widget\"/>"+
                                     "</div>"+
                                     "</div>"+
                                     "<div class=\"jamal-tab-container\"/>"+
                                     "</div>");
    // exercise
    _widget.tabWidget().addTab(new Widget()).addTab(new Widget());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddWidgetContent() throws Exception { 
    // setup
    String equivalentHtml = wrapHtml("<div class=\"jamal-widget jamal-tab-widget\">"+
                                     "<div class=\"jamal-tab-list\"/>"+
                                     "<div class=\"jamal-tab-container\">"+
                                     "<div class=\"jamal-widget\"/>"+
                                     "</div>"+
                                     "</div>");
    // exercise
    _widget.tabWidget().addContent(new Widget());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

