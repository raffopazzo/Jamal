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

public class DetailsTest extends JamalTestCase {

  public void testCreateEmptyDetailsElement() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<details/>"); 
    // exercise
    _widget.details();
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testCreateDetailsWithSummary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<details>"+
                                           "<summary>dummy</summary>"+
                                           "</details>"); 
    // exercise
    _widget.details("dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

  public void testRetrieveSummaryLabelFromDictionary() throws Exception {
    // setup
    final String equivalentHtml = wrapHtml("<details>"+
                                           "<summary>LABEL_0</summary>"+
                                           "</details>"); 
    // exercise
    _widget.details(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml);
  }

}

