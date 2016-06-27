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

public class UnorderedListTest extends JamalTestCase {

  public void testCreateEmptyList() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<ul/>");
    // exercise
    _widget.ul();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateSimpleListItem() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<ul><li>Hello World</li></ul>");
    // exercise
    _widget.ul().li("Hello World");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateListItemWithChildWidget() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<ul><li><a/></li></ul>");
    // exercise
    _widget.ul().a();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }
}
