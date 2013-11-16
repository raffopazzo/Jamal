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

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
  protected Document _document;
  protected Element _body;

  public Widget() {
    this(null);
  }

  public Widget(Dictionary dictionary) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = factory.newDocumentBuilder();
      _document = docBuilder.newDocument();
      init();
    } catch (Exception e) {
      throw new RuntimeException("Can't build document",e);
    }
    _i18n = dictionary;
  }

  private Widget(Widget parent, Element element) {
    _document = parent._document;
    _i18n = parent._i18n;
    _body = element;
  }

  protected void init() {
    _body = createRoot(HTML_DIV);
    _body.setAttribute(HTML_CLASS, JAMAL_CLASS_WIDGET);
  }

  protected Element createElement(String tag) {
    return _document.createElement(tag);
  }

  protected Element createRoot(String tag) {
    return (Element)_document.appendChild(createElement(tag));
  }

  protected Element appendElement(String tag) {
    return (Element)_body.appendChild(createElement(tag));
  }

  private Widget createChildWidget(String tag) {
    return new Widget(this, appendElement(tag));
  }

  public Widget addClassName(String clazz) {
    String current = _body.getAttribute(HTML_CLASS);
    if (current.isEmpty()) {
      _body.setAttribute(HTML_CLASS, clazz);
    } else {
      _body.setAttribute(HTML_CLASS, current + " " + clazz); 
    }
    return this;
  }

  public Widget append(Widget content) {
    _body.appendChild(content._body);
    return this;
  }

  public Widget setAttribute(String name, String value) {
    _body.setAttribute(name, value);
    return this;
  }

  public Widget setTextContent(String text) {
    _body.setTextContent(text);
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
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer transformer = factory.newTransformer();
      transformer.setOutputProperty(OutputKeys.METHOD, "xml");
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
      DOMSource source = new DOMSource(_document);
      StringWriter writer = new StringWriter();
      transformer.transform(source, new StreamResult(writer));
      String result = writer.toString();
      return result;
    } catch (Exception e) {
      throw new RuntimeException("Can't render HTML document", e);
    }
  }

};
