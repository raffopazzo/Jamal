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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import io.jamal.i18n.Dictionary;

public class WebPage extends Widget<WebPage> {

  static public final String ENCODING_UTF8 = "utf-8";

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

  static public final String XHTML_DOCTYPE_PUBLIC = "-//W3C//DTD XHTML 1.0 Transitional//EN";
  static public final String XHTML_DOCTYPE_SYSTEM = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd";
  static public final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";

  private String _title;
  private HashMap<String, String> _metas;
  private LinkedList<String> _scripts;
  private LinkedList<String> _css;

  public WebPage(Dictionary dictionary) {
    super(dictionary, HTML_BODY);
    _metas = new HashMap<String, String>();
    _scripts = new LinkedList<String>();
    _css = new LinkedList<String>();
  }

  public WebPage() {
    this(null);
  }

  @Override
  protected Node prepareDocument(Document document) {
    Element root = (Element)document.appendChild(document.createElementNS(XHTML_NAMESPACE,
                                                                          HTML));
    root.appendChild(renderDocumentHead(document));
    return root;
  }

  private Element renderDocumentHead(Document document) {
    Element head = document.createElement(HTML_HEAD);
    if (_title != null) {
      head.appendChild(renderTitle(document));
    }
    renderMetas(document, head);
    renderScripts(document, head);
    renderCss(document, head);
    return head;
  }

  private Element renderTitle(Document document) {
    Element title = document.createElement(HTML_TITLE);
    title.setTextContent(_title);
    return title;
  }

  private void renderMetas(Document doc, Element head) {
    for (Map.Entry<String,String> m: _metas.entrySet()) {
      Element meta = (Element)head.appendChild(doc.createElement(HTML_META));
      meta.setAttribute(HTML_META_NAME, m.getKey());
      meta.setAttribute(HTML_META_CONTENT, m.getValue());
    }
  }

  private void renderScripts(Document doc, Element head) {
    for (String s: _scripts) {
      Element script= (Element)head.appendChild(doc.createElement(HTML_SCRIPT));
      script.setAttribute(HTML_SCRIPT_SRC, s);
    }
  }

  private void renderCss(Document doc, Element head) {
    for (String s: _css) {
      Element link = (Element)head.appendChild(doc.createElement(HTML_LINK));
      link.setAttribute(HTML_LINK_REL, HTML_LINK_REL_STYLESHEET);
      link.setAttribute(HTML_LINK_TYPE, MIME_CSS);
      link.setAttribute(HTML_LINK_HREF, s);
    }
  }

  @Override
  public WebPage setTitle(String title) {
    _title = title;
    return this;
  }

  public WebPage addMeta(String name, String content) {
    _metas.put(name, content);
    return this;
  }

  public WebPage addViewportMeta(String content) {
    return addMeta(HTML_META_VIEWPORT, content);
  }

  public WebPage addScript(String url) {
    _scripts.add(url);
    return this;
  }

  public WebPage addCss(String url) {
    _css.add(url);
    return this;
  }

  @Override
  protected Transformer prepareTransformer(Transformer transformer) {
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, XHTML_DOCTYPE_PUBLIC);
    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, XHTML_DOCTYPE_SYSTEM);
    transformer.setOutputProperty(OutputKeys.ENCODING, ENCODING_UTF8);
    return transformer;
  }

}
