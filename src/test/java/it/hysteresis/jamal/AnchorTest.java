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

public class AnchorTest extends JamalTestCase {

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

  public void testChangeAncorHref() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"dummy\"></a>");
    // exercise
    _widget.a("#").setAttribute(Widget.HTML_A_HREF, "dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateAnchorElementWithHrefAndTextContent() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">dummy</a>");
    // exercise
    _widget.a("#", "dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testChangeAncorTextContent() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">dummy 2</a>");
    // exercise
    _widget.a("#", "dummy 1").setTextContent("dummy 2");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateAnchorElementWithBlankTarget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\" target=\"_blank\"/>");
    // exercise
    _widget.a("#").setAttribute(Widget.HTML_A_TARGET,
                                Widget.HTML_A_TARGET_BLANK);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateAnchorElementWithSelftTarget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\" target=\"_self\"/>");
    // exercise
    _widget.a("#").setAttribute(Widget.HTML_A_TARGET,
                                Widget.HTML_A_TARGET_SELF);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testRetrieveLabelFromDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\">LABEL_0</a>");
    // exercise
    _widget.a("#", FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testChangeHref() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"dummy\"/>");
    // exercise
    _widget.a("#").setHref("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testChangeTargetToSelf() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\""+
                                           "   target=\"_self\"/>");
    // exercise
    _widget.a("#").setTarget(Anchor.Target._self);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testChangeTargetToBlank() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<a href=\"#\""+
                                           "   target=\"_blank\"/>");
    // exercise
    _widget.a("#").setTarget(Anchor.Target._blank);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAppendChildWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div>"+
                                           "<a href=\"#\">"+
                                           "<div class=\"jamal-widget\"/>"+
                                           "</a>"+
                                           "</div>");
    // exercise
    _widget.div().a("#", new Widget<Widget>());
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testOverwriteHrefEvenWithChildWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div>"+
                                           "<a href=\"dummy\">"+
                                           "<div class=\"jamal-widget\"/>"+
                                           "</a>"+
                                           "</div>");
    // exercise
    _widget.div().a("#", new Widget<Widget>()).setHref("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }
}

