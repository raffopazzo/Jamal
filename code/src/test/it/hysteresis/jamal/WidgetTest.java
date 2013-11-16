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

public class WidgetTest extends JamalTestCase {

  public void testWidgetHasDivWithDefaultClassName() throws Exception {
    // setup
    final String equivalentHtml = "<div class=\"jamal-widget\"/>";
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetWidgetId() throws Exception { 
    // setup
    final String equivalentHtml = "<div id=\"dummy\" class=\"jamal-widget\"/>";
    // exercise
    _widget.setId("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testOverrideWidgetId() throws Exception { 
    // setup
    final String equivalentHtml= "<div id=\"dummy 2\" class=\"jamal-widget\"/>";
    // exercise
    _widget.setId("dummy 1");
    _widget.setId("dummy 2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddWidgetClassName() throws Exception { 
    // setup
    final String equivalentHtml = "<div class=\"jamal-widget dummy\"/>";
    // exercise
    _widget.addClassName("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateChildDivElement() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<div/>");
    // exercise
    _widget.div();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetChildId() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<div id=\"dummy\"/>");
    // exercise
    _widget.div().setId("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testOverrideChildId() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<div id=\"dummy-2\"/>");
    // exercise
    _widget.div().setId("dummy-1").setId("dummy-2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetChildClassName() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"dummy\"/>");
    // exercise
    _widget.div().addClassName("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddChildClassName() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"dummy-1 dummy-2\"/>");
    // exercise
    _widget.div().addClassName("dummy-1").addClassName("dummy-2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateChildAnchorElement() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a/>");
    // exercise
    _widget.a();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateAnchorElementWithHref() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\"/>");
    // exercise
    _widget.a("#");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testPropagateDictionaryToChildren() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<div>"+
                                           "<a href=\"#\">LABEL_0</a>"+
                                           "</div>");
    // exercise
    _widget.div().a("#", FakeEnums.LABEL_0);
    // verify
      assertEquvalentToHtml(equivalentHtml);
  }

}

