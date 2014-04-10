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

public class MarkDownTest extends JamalTestCase {

  public void testCreateEmptyMarkDown() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-markdown\"/>"); 
    // exercise
    _widget.markdown("");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testAddCustomClassName() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-markdown dummy\"/>"); 
    // exercise
    _widget.markdown("").addClassName("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSupportStrongText() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-markdown\">"+
                                           "<p><strong>DUMMY</strong></p>"+
                                           "</div>"); 
    // exercise
    _widget.markdown("**DUMMY**");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testSupportItalicText() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-markdown\">"+
                                           "<p><em>DUMMY</em></p>"+
                                           "</div>"); 
    // exercise
    _widget.markdown("*DUMMY*");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testWrapUpSiblings() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<div class=\"jamal-markdown\">"+
                                           "<h1>TITLE</h1><p>text</p>"+
                                           "</div>"); 
    // exercise
    _widget.markdown("TITLE\n"+
                     "===\n"+
                     "text");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

