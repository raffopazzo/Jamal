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

import org.w3c.dom.Element;

import it.hysteresis.jamal.i18n.Dictionary;

public class WebPage extends Widget {

  static public final String HTML5_DECLARATION = "<!DOCTYPE html>";
  static public final String HTML = "html";
  static public final String HTML_BODY = "body";
  static public final String HTML_HEAD = "head";
  static public final String HTML_LINK = "link";
  static public final String HTML_LINK_REL = "rel";
  static public final String HTML_LINK_REL_STYLESHEET = "stylesheet";
  static public final String HTML_LINK_TYPE = "type";
  static public final String HTML_LINK_HREF = "href";
  static public final String HTML_META = "meta";
  static public final String HTML_META_NAME = "name";
  static public final String HTML_META_CONTENT = "content";
  static public final String HTML_META_VIEWPORT = "viewport";
  static public final String HTML_SCRIPT = "script";
  static public final String HTML_SCRIPT_SRC = "src";
  static public final String HTML_TITLE = "title";

  static public final String MIME_CSS = "text/css";

  private Element _root;
  private Element _head;
  private Element _title;

  public WebPage(Dictionary dictionary) {
    super(dictionary);
  }

  public WebPage() {
  }

  @Override
  protected void init() {
    _root = createRoot(HTML);
    _head = (Element)_root.appendChild(createElement(HTML_HEAD));
    _body = (Element)_root.appendChild(createElement(HTML_BODY));
  }

  private Element appendHeadElement(String tag) {
    return (Element)_head.appendChild(createElement(tag));
  }

  public WebPage setTitle(String title) {
    if (_title == null) {
      _title = appendHeadElement(HTML_TITLE);
    }
    _title.setTextContent(title);
    return this;
  }

  public WebPage setTitle(Enum label) {
    return setTitle(_i18n.getLabel(label));
  }

  public WebPage addMeta(String name, String content) {
    Element meta = appendHeadElement(HTML_META);
    meta.setAttribute(HTML_META_NAME, name);
    meta.setAttribute(HTML_META_CONTENT, content);
    return this;
  }

  public WebPage addViewportMeta(String content) {
    return addMeta(HTML_META_VIEWPORT, content);
  }

  public WebPage addScript(String url) {
    Element script = appendHeadElement(HTML_SCRIPT);
    script.setAttribute(HTML_SCRIPT_SRC, url);
    return this;
  }

  public WebPage addCss(String url) {
    Element link = appendHeadElement(HTML_LINK);
    link.setAttribute(HTML_LINK_REL, HTML_LINK_REL_STYLESHEET);
    link.setAttribute(HTML_LINK_TYPE, MIME_CSS);
    link.setAttribute(HTML_LINK_HREF, url);
    return this;
  }

  @Override
  public String toString() {
    return HTML5_DECLARATION + super.toString();
  }

}
