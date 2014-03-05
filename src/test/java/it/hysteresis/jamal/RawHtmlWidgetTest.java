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
package it.hysteresis.jamal;

public class RawHtmlWidgetTest extends JamalTestCase {

  public void testCreateEmptyRawHtmlWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-raw\"/>"); 
    // exercise
    _widget.raw("");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateRawHtmlWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-raw\">"+
                                           "<div>custom</div>"+
                                           "</div>"); 
    // exercise
    _widget.raw("<div>custom</div>");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

