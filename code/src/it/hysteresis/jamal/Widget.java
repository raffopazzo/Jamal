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

import it.hysteresis.jamal.Form.Method;
import it.hysteresis.jamal.i18n.Dictionary;

public class Widget<T extends Widget> {

  static public final String HTML_CLASS = "class";
  static public final String HTML_ID = "id";
  static public final String HTML_A = "a";
  static public final String HTML_A_HREF = "href";
  static public final String HTML_A_TARGET = "target";
  static public final String HTML_A_TARGET_BLANK = "_blank";
  static public final String HTML_A_TARGET_SELF = "_self";
  static public final String HTML_DIV = "div";
  static public final String HTML_DETAILS = "details";
  static public final String HTML_DETAILS_OPEN = "open";
  static public final String HTML_FORM = "form";
  static public final String HTML_FORM_ACTION = "action";
  static public final String HTML_FORM_METHOD = "method";
  static public final String HTML_INPUT = "input";
  static public final String HTML_INPUT_NAME = "name";
  static public final String HTML_INPUT_TYPE = "type";
  static public final String HTML_INPUT_TYPE_SUBMIT = "submit";
  static public final String HTML_INPUT_VALUE = "value";
  static public final String HTML_LABEL = "label";
  static public final String HTML_LABEL_FOR = "for";
  static public final String HTML_SUMMARY = "summary";

  static public final String JAMAL_CLASS_BUTTON = "jamal-button";
  static public final String JAMAL_CLASS_BUTTON_ICON = "jamal-button-icon";
  static public final String JAMAL_CLASS_BUTTON_TEXT = "jamal-button-text";
  static public final String JAMAL_CLASS_LAYOUT_FLOW = "jamal-layout-flow";
  static public final String JAMAL_CLASS_LAYOUT_ITEM = "jamal-layout-item";
  static public final String JAMAL_CLASS_WIDGET = "jamal-widget";

  protected Dictionary _i18n;
  protected String _tag;

  protected LinkedList<String> _classNames;
  protected LinkedList<Widget> _children;
  protected HashMap<String, String> _attributes;
  protected String _textContent;

  protected T _this;

  protected Widget(Dictionary dictionary, String tag) {
    _i18n = dictionary;
    _classNames = new LinkedList<String>();
    _children = new LinkedList<Widget>();
    _attributes = new HashMap<String, String>();
    _tag = tag;
    _this = (T)this;
  }

  public Widget(Dictionary dictionary) {
    this(dictionary, HTML_DIV);
    addClassName(JAMAL_CLASS_WIDGET);
  }

  public Widget() {
    this(null);
  }

  protected Widget append(String tag) {
    return append(new Widget(_i18n, tag));
  }

  protected <W extends Widget> W append(W widget) {
    _children.add(widget);
    return widget;
  }

  public T addClassName(String clazz) {
    _classNames.add(clazz);
    return _this;
  }

  public T setAttribute(String name, String value) {
    _attributes.put(name, value);
    return _this;
  }

  public T setAttribute(String name, Enum value) {
    _attributes.put(name, _i18n.getLabel(value));
    return _this;
  }

  public T setTextContent(String text) {
    _textContent = text;
    return _this;
  }

  public T setId(String id) {
    return setAttribute(HTML_ID, id);
  }

  public Anchor a() {
    return append(new Anchor(_i18n));
  }

  public Anchor a(String href) {
    return a().setAttribute(HTML_A_HREF, href);
  }

  public Anchor a(String href, String textContent) {
    return a().setAttribute(HTML_A_HREF, href)
              .setTextContent(textContent);
  }

  public Anchor a(String href, Enum label) {
    return a(href, _i18n.getLabel(label));
  }

  public Anchor a(String href, Widget content) {
    Anchor a = a(href);
    a.append(content);
    return a;
  }

  public Anchor button(String href) {
    Anchor button = a(href).addClassName(JAMAL_CLASS_BUTTON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT);
    return button;
  }

  public Anchor button(String href, String text) {
    Anchor button = a(href).addClassName(JAMAL_CLASS_BUTTON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT)
                .setTextContent(text);
    return button;
  }

  public Anchor button(String href, String icon, String text) {
    Anchor button = a(href).addClassName(JAMAL_CLASS_BUTTON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON)
                .setTextContent(icon);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT)
                .setTextContent(text);
    return button;
  }

  public Anchor button(String href, Enum text) {
    return button(href, _i18n.getLabel(text));
  }

  public Anchor button(String href, Enum icon, Enum text) {
    return button(href, _i18n.getLabel(icon), _i18n.getLabel(text));
  }

  public Anchor button(String href, Enum icon, String text) {
    return button(href, _i18n.getLabel(icon), text);
  }

  public Details details() {
    return append(new Details(_i18n));
  }

  public Details details(String summary) {
    Details details = details();
    details.append(HTML_SUMMARY).setTextContent(summary);
    return details;
  }

  public Details details(Enum summary) {
    return details(_i18n.getLabel(summary));
  }

  public Widget div() {
    return append(HTML_DIV);
  }

  public FlowLayout flowLayout() {
    return append(new FlowLayout(_i18n));
  }

  public Form form() {
    return append(new Form(_i18n)).setMethod(Form.Method.post);
  }

  public Input input(String name) {
    return append(new Input(_i18n)).setName(name);
  }

  public Input input(String name, String value) {
    return input(name).setValue(value);
  }

  public Widget label(String inputId, String text) {
    return append(HTML_LABEL).setAttribute(HTML_LABEL_FOR, inputId)
                             .setTextContent(text);
  }

  public Widget label(String inputId, Enum text) {
    return label(inputId, _i18n.getLabel(text));
  }

  public Input submit() {
    return append(new Input(_i18n)).setType(Input.Type.submit);
  }

  public Input submit(String text) {
    return submit().setValue(text);
  }

  public Input submit(Enum text) {
    return submit(_i18n.getLabel(text));
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
