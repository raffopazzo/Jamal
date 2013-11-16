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

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import it.hysteresis.jamal.i18n.Dictionary;

public class Widget {

  static public final String HTML_CLASS = "class";
  static public final String HTML_ID = "id";
  static public final String HTML_A = "a";
  static public final String HTML_A_HREF = "href";
  static public final String HTML_A_TARGET = "target";
  static public final String HTML_A_TARGET_BLANK = "_blank";
  static public final String HTML_A_TARGET_SELF = "_self";
  static public final String HTML_DIV = "div";
  static public final String HTML_DETAILS = "details";
  static public final String HTML_SUMMARY = "summary";

  static public final String JAMAL_CLASS_BUTTON = "jamal-button";
  static public final String JAMAL_CLASS_BUTTON_ICON = "jamal-button-icon";
  static public final String JAMAL_CLASS_BUTTON_TEXT = "jamal-button-text";
  static public final String JAMAL_CLASS_WIDGET = "jamal-widget";

  protected Dictionary _i18n;
  protected String _tag;

  protected LinkedList<String> _classNames;
  protected LinkedList<Widget> _children;
  protected HashMap<String, String> _attributes;
  protected String _textContent;

  protected Widget(Dictionary dictionary, String tag) {
    _i18n = dictionary;
    _classNames = new LinkedList<String>();
    _children = new LinkedList<Widget>();
    _attributes = new HashMap<String, String>();
    _tag = tag;
  }

  public Widget(Dictionary dictionary) {
    this(dictionary, HTML_DIV);
    addClassName(JAMAL_CLASS_WIDGET);
  }

  public Widget() {
    this(null);
  }

  private Widget createChildWidget(String tag) {
    Widget child = new Widget(_i18n, tag);
    _children.add(child);
    return child;
  }

  public Widget addClassName(String clazz) {
    _classNames.add(clazz);
    return this;
  }

  public Widget append(Widget widget) {
    _children.add(widget);
    return this;
  }

  public Widget append(Widget...widgets) {
    for (Widget w: widgets) {
      _children.add(w); 
    }
    return this;
  }

  public Widget setAttribute(String name, String value) {
    _attributes.put(name, value);
    return this;
  }

  public Widget setTextContent(String text) {
    _textContent = text;
    return this;
  }

  public Widget setId(String id) {
    return setAttribute(HTML_ID, id);
  }

  public Widget a() {
    return createChildWidget(HTML_A);
  }

  public Widget a(String href) {
    return a().setAttribute(HTML_A_HREF, href);
  }

  public Widget a(String href, String textContent) {
    return a().setAttribute(HTML_A_HREF, href)
              .setTextContent(textContent);
  }

  public Widget a(String href, Enum label) {
    return a(href, _i18n.getLabel(label));
  }

  public Widget button(String href) {
    Widget button = a(href).div().addClassName(JAMAL_CLASS_BUTTON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT);
    return button;
  }

  public Widget button(String href, String text) {
    Widget button = a(href).div().addClassName(JAMAL_CLASS_BUTTON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT)
                .setTextContent(text);
    return button;
  }

  public Widget button(String href, String icon, String text) {
    Widget button = a(href).div().addClassName(JAMAL_CLASS_BUTTON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON)
                .setTextContent(icon);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT)
                .setTextContent(text);
    return button;
  }

  public Widget button(String href, Enum text) {
    return button(href, _i18n.getLabel(text));
  }

  public Widget button(String href, Enum icon, Enum text) {
    return button(href, _i18n.getLabel(icon), _i18n.getLabel(text));
  }

  public Widget button(String href, Enum icon, String text) {
    return button(href, _i18n.getLabel(icon), text);
  }

  public Widget details() {
    return createChildWidget(HTML_DETAILS);
  }

  public Widget details(String summary) {
    Widget details = details();
    details.createChildWidget(HTML_SUMMARY).setTextContent(summary);
    return details;
  }

  public Widget details(Enum summary) {
    return details(_i18n.getLabel(summary));
  }

  public Widget div() {
    return createChildWidget(HTML_DIV);
  }

  @Override
  public String toString() {
    try {
      Document document = renderDocument();
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer transformer = factory.newTransformer();
      transformer.setOutputProperty(OutputKeys.METHOD, "xml");
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
      DOMSource source = new DOMSource(document);
      StringWriter writer = new StringWriter();
      transformer.transform(source, new StreamResult(writer));
      String result = writer.toString();
      return result;
    } catch (Exception e) {
      throw new RuntimeException("Can't render HTML document", e);
    }
  }

  private Document renderDocument() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = factory.newDocumentBuilder();
    Document document = docBuilder.newDocument();
    Node root = prepareDocument(document);
    root.appendChild(render(document));
    return document;
  }

  protected Node prepareDocument(Document document) {
    /* The root of Widgets is the documents itself */
    return document;
  }

  private Element render(Document document) {
    Element element = document.createElement(_tag);
    element.setTextContent(_textContent);
    renderAttributes(element);
    renderClassNames(element);
    renderChildWidgets(document, element);
    return element;
  }

  private void renderAttributes(Element element) {
    for (Map.Entry<String, String> a: _attributes.entrySet()) {
      element.setAttribute(a.getKey(), a.getValue());
    }
  }

  private void renderClassNames(Element element) {
    Iterator<String> it = _classNames.iterator();
    if (it.hasNext()) {
      String clazz = it.next();
      while (it.hasNext()) {
        clazz += " " + it.next();
      }
      element.setAttribute(HTML_CLASS, clazz);
    }
  }

  private void renderChildWidgets(Document document, Element parent) {
    for (Widget w: _children) {
      parent.appendChild(w.render(document)); 
    }
  }

};
