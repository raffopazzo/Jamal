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
package io.jamal;

public class FlowLayoutTest extends JamalTestCase {

  public void testCreateEmptyFlowLayout() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-layout-flow\"/>"); 
    // exercise
    _widget.flowLayout();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddWidgetToFlowLayout() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-layout-flow\">"+
                                          "<div class=\"jamal-layout-item\">"+
                                          "<div class=\"jamal-widget\"/>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.flowLayout().addWidget(new Widget<Widget>());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddMultipleWidgetsToFlowLayout() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-layout-flow\">"+
                                          "<div class=\"jamal-layout-item\">"+
                                          "<div class=\"jamal-widget\"/>"+
                                          "</div>"+
                                          "<div class=\"jamal-layout-item\">"+
                                          "<div class=\"jamal-widget\"/>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.flowLayout().addWidget(new Widget<Widget>())
                        .addWidget(new Widget<Widget>());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendWidgetToFlowLayout() throws Exception { 
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-layout-flow\">"+
                                          "<div class=\"jamal-layout-item\">"+
                                          "<div class=\"jamal-widget\"/>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.flowLayout().append(new Widget<Widget>());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

