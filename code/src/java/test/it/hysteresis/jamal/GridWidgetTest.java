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
import it.hysteresis.jamal.GridWidget;
import it.hysteresis.jamal.GridWidget.GridRowWidget;
import it.hysteresis.jamal.Widget;

public class GridWidgetTest extends JamalTestCase {

  public void testCreateEmptyGrid() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\"/>"); 
    // exercise
    _widget.grid();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendHeader() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row jamal-header\">"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy 0"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy 1"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendHeader("Dummy 0", "Dummy 1");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendHeaderFromDictionaryAndStrings() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row jamal-header\">"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "LABEL_0"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendHeader("Dummy", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendHeaderFromDictionaryStringsAndWidgets() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row jamal-header\">"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "LABEL_0"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "<div class=\"jamal-widget\"/>"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendHeader("Dummy", FakeEnums.LABEL_0, new Widget());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendHeaderSkippingNullElements() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row jamal-header\">"+
                                          "<div class=\"jamal-cell\"/>"+
                                          "<div class=\"jamal-cell\">"+
                                          "LABEL_0"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendHeader(null, FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

//////////////////////

  public void testAppendRow() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy 0"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy 1"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendRow("Dummy 0", "Dummy 1");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendRowFromDictionaryAndStrings() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "LABEL_0"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendRow("Dummy", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendRowFromDictionaryStringsAndWidgets() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\">"+
                                          "Dummy"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "LABEL_0"+
                                          "</div>"+
                                          "<div class=\"jamal-cell\">"+
                                          "<div class=\"jamal-widget\"/>"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendRow("Dummy", FakeEnums.LABEL_0, new Widget());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendRowSkippingNullElements() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\"/>"+
                                          "<div class=\"jamal-cell\">"+
                                          "LABEL_0"+
                                          "</div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendRow(null, FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendGridRowWidget() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\"><div><p>Dummy 0</p></div></div>"+
                                          "<div class=\"jamal-cell\"><div><p>Dummy 1</p></div></div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().appendRow(new GridRowWidget() {{
      div().p("Dummy 0");
      div().p("Dummy 1");
    }});
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendChildGridRowWidget() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\"><div><p>Dummy 0</p></div></div>"+
                                          "<div class=\"jamal-cell\"><div><p>Dummy 1</p></div></div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    _widget.grid().append(new GridRowWidget() {{
      div().p("Dummy 0");
      div().p("Dummy 1");
    }});
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateAndAppendChildGridRowWidget() throws Exception {
    // setup
    final String equivalentHtml= wrapHtml("<div class=\"jamal-widget jamal-grid\">"+
                                          "<div class=\"jamal-row\">"+
                                          "<div class=\"jamal-cell\"><div><p>LABEL_0</p></div></div>"+
                                          "<div class=\"jamal-cell\"><div><p>LABEL_1</p></div></div>"+
                                          "</div>"+
                                          "</div>"); 
    // exercise
    GridWidget widget = _widget.grid();
    new GridRowWidget(widget) {{
      div().p(FakeEnums.LABEL_0);
      div().p(FakeEnums.LABEL_1);
    }};
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

