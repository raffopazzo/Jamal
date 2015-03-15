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

import io.jamal.i18n.StubDictionary;

public class WebPageTest extends JamalTestCase {

  private String html(String content) {
    return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>"+
           "<!DOCTYPE html PUBLIC"+
           " \"-//W3C//DTD XHTML 1.0 Transitional//EN\""+
           " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+
           "<html xmlns=\"http://www.w3.org/1999/xhtml\">"+
           content+
           "</html>";
  }

  public void testCreateEmptyPage() throws Exception {
    // setup
    final String equivalentHtml = html("<head/><body/>");
    // exercise
    WebPage emptyPage = new WebPage();
    // verify
    assertEquvalentToHtml(equivalentHtml, emptyPage);
  }

  public void testSetPageTitle() throws Exception {
    // setup
    final String equivalentHtml = html("<head><title>Dummy</title></head>"+
                                       "<body/>");
    // exercise
    WebPage actual = new WebPage().setTitle("Dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }

  public void testOverrideExistingTitle() throws Exception {
    // setup
    final String equivalentHtml = html("<head><title>Dummy 2</title></head>"+
                                       "<body/>");
    // exercise
    WebPage page = new WebPage();
    page.setTitle("Dummy 1");
    page.setTitle("Dummy 2");
    // verify
    assertEquvalentToHtml(equivalentHtml, page);
  }

  public void testAddMetaAttribute() throws Exception {
    // setup
    final String equivalentHtml = html("<head>"+
                                       "<meta name=\"keywords\""+
                                       "      content=\"Dummy\"/>"+
                                       "</head>"+
                                       "<body/>");
    // exercise
    WebPage actual = new WebPage().addMeta("keywords", "Dummy");
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }

  public void testAddViewportMeta() throws Exception {
    // setup
    final String equivalentHtml = html("<head>"+
                                       "<meta name=\"viewport\""+
                                       "      content=\"width=device-width\"/>"+
                                       "</head>"+
                                       "<body/>");
    // exercise
    WebPage actual = new WebPage().addViewportMeta("width=device-width");
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);

  }
  public void testAddScriptLink() throws Exception {
    // setup
    final String equivalentHtml = html("<head>"+
                                       "<script src=\"/dummy.js\"/>"+
                                       "</head>"+
                                       "<body/>");
    // exercise
    WebPage actual = new WebPage().addScript("/dummy.js");
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }

  public void testAddCssLink() throws Exception {
    // setup
    final String equivalentHtml = html("<head>"+
                                       "<link rel=\"stylesheet\""+
                                       "      type=\"text/css\""+
                                       "      href=\"/dummy.css\"/>"+
                                       "</head>"+
                                       "<body/>");
    // exercise
    WebPage actual = new WebPage().addCss("/dummy.css");
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }

  public void testCreateDivElement() throws Exception {
    // setup
    final String equivalentHtml = html("<head/>"+
                                       "<body><div/></body>");
    // exercise
    WebPage actual = new WebPage();
    actual.div();
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }

  public void testNestDivElements() throws Exception {
    // setup
    final String equivalentHtml = html("<head/>"+
                                       "<body>"+
                                       "<div><div/></div>"+
                                       "</body>");
    // exercise
    WebPage actual = new WebPage();
    actual.div().div();
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }

  public void testSetTitleFromDictionary() throws Exception { 
    // setup
    final String equivalentHtml = html("<head><title>LABEL_0</title></head>"+
                                       "<body/>");
    // exercise
    WebPage actual = new WebPage(new StubDictionary());
    actual.setTitle(FakeEnums.LABEL_0);
    // verify
    assertEquvalentToHtml(equivalentHtml, actual);
  }
}

