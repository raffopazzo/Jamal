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

  public void testSetDataAttribute() throws Exception { 
    // setup
    final String equivalentHtml = "<div data-dummy=\"value\" class=\"jamal-widget\"/>";
    // exercise
    _widget.setData("dummy", "value");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetDataAttributeFromDictionary() throws Exception { 
    // setup
    final String equivalentHtml = "<div data-dummy=\"LABEL_0\" class=\"jamal-widget\"/>";
    // exercise
    _widget.setData("dummy", FakeEnums.LABEL_0);
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

  public void testCreateImgElement() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<img src=\"dummy\"/>");
    // exercise
    _widget.img("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateParagraphElement() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<p>dummy</p>");
    // exercise
    _widget.p("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateParagraphElementFromDictionary() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<p>LABEL_0</p>");
    // exercise
    _widget.p(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreatePreElement() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<pre>dummy</pre>");
    // exercise
    _widget.pre("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateEmptyList() throws Exception { 
    // setup
    final String equivalentHtml = wrapHtml("<ul/>");
    // exercise
    Widget list = _widget.ul();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateLists() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<ul>"+
                                           "<li>dummy-1</li>"+
                                           "<li>dummy-2</li>"+
                                           "</ul>");
    // exercise
    Widget list = _widget.ul();
    list.li("dummy-1");
    list.li("dummy-2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetElementTitle() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div title=\"dummy\"/>");
    // exercise
    Widget list = _widget.div().setTitle("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSetElementTitleFromDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div title=\"LABEL_0\"/>");
    // exercise
    Widget list = _widget.div().setTitle(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendChildWidgetToParent() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget\"/>");
    // exercise
    new Widget<Widget>(_widget);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testPropagateDictionaryToChildWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-widget\">"+
                                           "<p>LABEL_0</p>"+
                                           "</div>");
    // exercise
    new Widget<Widget>(_widget).p(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }
}

