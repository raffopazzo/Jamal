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

import io.jamal.Form.Method;
import io.jamal.Input.Type;
import io.jamal.i18n.Dictionary;

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
  static public final String HTML_IFRAME = "iframe";
  static public final String HTML_IMG = "img";
  static public final String HTML_INPUT = "input";
  static public final String HTML_INPUT_CHECKED = "checked";
  static public final String HTML_INPUT_DISABLED = "disabled";
  static public final String HTML_INPUT_MAX = "max";
  static public final String HTML_INPUT_MIN = "min";
  static public final String HTML_INPUT_NAME = "name";
  static public final String HTML_INPUT_PLACEHOLDER = "placeholder";
  static public final String HTML_INPUT_STEP = "step";
  static public final String HTML_INPUT_TYPE = "type";
  static public final String HTML_INPUT_TYPE_SUBMIT = "submit";
  static public final String HTML_INPUT_VALUE = "value";
  static public final String HTML_LABEL = "label";
  static public final String HTML_LABEL_FOR = "for";
  static public final String HTML_LI = "li";
  static public final String HTML_OPTGROUP = "optgroup";
  static public final String HTML_OPTION = "option";
  static public final String HTML_OPTION_SELECTED = "selected";
  static public final String HTML_P = "p";
  static public final String HTML_PRE = "pre";
  static public final String HTML_PROGRESS = "progress";
  static public final String HTML_SELECT = "select";
  static public final String HTML_SRC = "src";
  static public final String HTML_SUMMARY = "summary";
  static public final String HTML_TEXTAREA = "textarea";
  static public final String HTML_TITLE = "title";
  static public final String HTML_UL = "ul";

  static public final String JAMAL_CLASS_BUTTON = "jamal-button";
  static public final String JAMAL_CLASS_BUTTON_ICON = "jamal-button-icon";
  static public final String JAMAL_CLASS_BUTTON_TEXT = "jamal-button-text";
  static public final String JAMAL_CLASS_CELL = "jamal-cell";
  static public final String JAMAL_CLASS_KEY_VALUE_WIDGET = "jamal-key-value-widget";
  static public final String JAMAL_CLASS_KEY_VALUE_PAIR = "jamal-key-value-pair";
  static public final String JAMAL_CLASS_KEY = "jamal-key";
  static public final String JAMAL_CLASS_GRID = "jamal-grid";
  static public final String JAMAL_CLASS_HEADER = "jamal-header";
  static public final String JAMAL_CLASS_LAYOUT_FLOW = "jamal-layout-flow";
  static public final String JAMAL_CLASS_LAYOUT_ITEM = "jamal-layout-item";
  static public final String JAMAL_CLASS_MARKDOWN = "jamal-markdown";
  static public final String JAMAL_CLASS_RAW = "jamal-raw";
  static public final String JAMAL_CLASS_ROW = "jamal-row";
  static public final String JAMAL_CLASS_SELECTED = "jamal-selected";
  static public final String JAMAL_CLASS_TAB_WIDGET = "jamal-tab-widget";
  static public final String JAMAL_CLASS_TAB_LIST = "jamal-tab-list";
  static public final String JAMAL_CLASS_TAB_CONTAINER = "jamal-tab-container";
  static public final String JAMAL_CLASS_TAB = "jamal-tab";
  static public final String JAMAL_CLASS_VALUE = "jamal-value";
  static public final String JAMAL_CLASS_WIDGET = "jamal-widget";

  protected Dictionary _i18n;
  protected String _tag;

  protected LinkedList<String> _classNames;
  protected LinkedList<Widget> _children;
  protected HashMap<String, String> _attributes;
  protected String _textContent;
  protected Widget _parent;

  protected T _this;

  protected Widget(Dictionary dictionary, String tag) {
    _i18n = dictionary;
    _classNames = new LinkedList<String>();
    _children = new LinkedList<Widget>();
    _attributes = new HashMap<String, String>();
    _tag = tag;
    _parent = null;
    // We need to use temporary variable in order to use have SuppressWarnings
    // really suppressing our warning.
    @SuppressWarnings("unchecked")
    T that = (T)this;
    _this = that;
  }

  public Widget(Widget<? extends Widget> parent) {
    this(parent._i18n);
    parent.append(this);
  }

  public Widget(Dictionary dictionary) {
    this(dictionary, HTML_DIV);
    addClassName(JAMAL_CLASS_WIDGET);
  }

  public Widget() {
    this((Dictionary)null);
  }

  protected Widget<Widget> append(String tag) {
    return append(new Widget<Widget>(_i18n, tag));
  }

  public <W extends Widget<? extends Widget>> W append(W widget) {
    if (widget._parent != null) {
      widget._parent._children.remove(widget);
    }
    widget._parent = this; 
    _children.add(widget);
    return widget;
  }

  public T addClassName(String clazz) {
    _classNames.add(clazz);
    return _this;
  }

  public T removeAttribute(String name) {
    _attributes.remove(name);
    return _this;
  }

  public T setAttribute(String name, boolean set) {
    if (set) {
      _attributes.put(name, name);
    } else {
      _attributes.remove(name);
    }
    return _this;
  }

  public T setAttribute(String name, int value) {
    return setAttribute(name, Integer.toString(value));
  }

  public T setAttribute(String name, double value) {
    return setAttribute(name, Double.toString(value));
  }

  public T setAttribute(String name, String value) {
    _attributes.put(name, value);
    return _this;
  }

  public T setAttribute(String name, Enum value) {
    _attributes.put(name, _i18n.getLabel(value));
    return _this;
  }

  public T setData(String name, String value) {
    return setAttribute("data-" + name, value);
  }

  public T setData(String name, Enum value) {
    return setAttribute("data-" + name, value);
  }

  public T setId(String id) {
    return setAttribute(HTML_ID, id);
  }

  public String getId() {
    return _attributes.get(HTML_ID);
  }

  public T setTextContent(String text) {
    _textContent = text;
    return _this;
  }

  public T setTextContent(Enum text) {
    return setTextContent(_i18n.getLabel(text));
  }

  public T setTitle(String title) {
    return setAttribute(HTML_TITLE, title);
  }

  public T setTitle(Enum title) {
    return setTitle(_i18n.getLabel(title));
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

  public Anchor a(String href, Widget<? extends Widget> content) {
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
    Anchor button = a(href).addClassName(JAMAL_CLASS_BUTTON)
                           .setTitle(text);
    button.div().addClassName(JAMAL_CLASS_BUTTON_ICON);
    button.div().addClassName(JAMAL_CLASS_BUTTON_TEXT)
                .setTextContent(text);
    return button;
  }

  public Anchor button(String href, String icon, String text) {
    Anchor button = a(href).addClassName(JAMAL_CLASS_BUTTON)
                           .setTitle(text);
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

  public Div div() {
    return append(new Div(_i18n));
  }

  public FlowLayout flowLayout() {
    return append(new FlowLayout(_i18n));
  }

  public Form form() {
    return append(new Form(_i18n)).setMethod(Form.Method.post);
  }

  public Widget iframe(String src) {
    return append(HTML_IFRAME).setAttribute(HTML_SRC, src);
  }

  public Widget img(String src) {
    return append(HTML_IMG).setAttribute(HTML_SRC, src);
  }

  public GridWidget grid() {
    return append(new GridWidget(_i18n));
  }

  public Input checkbox(String name) {
    return input(Input.Type.checkbox, name);
  }

  public Input input(Input.Type type, String name) {
    return append(new Input(_i18n)).setType(type).setName(name);
  }

  public Input input(String name) {
    return append(new Input(_i18n)).setName(name);
  }

  public Input input(String name, String value) {
    return input(name).setValue(value);
  }

  public KeyValueWidget keyValueWidget() {
    return append(new KeyValueWidget(_i18n));
  }

  public Widget label(String inputId, String text) {
    return append(HTML_LABEL).setAttribute(HTML_LABEL_FOR, inputId)
                             .setTextContent(text);
  }

  public Widget label(String inputId, Enum text) {
    return label(inputId, _i18n.getLabel(text));
  }

  public Widget li(String text) {
    return append(HTML_LI).setTextContent(text);
  }

  public Widget markdown(String text) {
    return append(new MarkDown(_i18n, text));
  }

  public Widget markdown(Enum text) {
    return append(new MarkDown(_i18n, _i18n.getLabel(text)));
  }

  public Widget optgroup(String label) {
    return append(HTML_OPTGROUP).setAttribute(HTML_LABEL, label);
  }

  public Widget optgroup(Enum label) {
    return optgroup(_i18n.getLabel(label));
  }

  public Option option(String value, String text) {
    return append(new Option(_i18n)).setAttribute(HTML_INPUT_VALUE, value)
                                    .setTextContent(text);
  }

  public Option option(String value, Enum text) {
    return option(value, _i18n.getLabel(text));
  }

  public Widget p(String text) {
    return append(HTML_P).setTextContent(text);
  }

  public Widget p(Enum text) {
    return p(_i18n.getLabel(text));
  }

  public Widget pre(String text) {
    return append(HTML_PRE).setTextContent(text);
  }

  public Widget progress(int value, int max) {
    return append(HTML_PROGRESS).setAttribute(HTML_INPUT_VALUE, value)
                                .setAttribute(HTML_INPUT_MAX,   max);
  }

  public <T extends Enum> Widget progress(T value, T max) {
    return append(HTML_PROGRESS).setAttribute(HTML_INPUT_VALUE, value.ordinal())
                                .setAttribute(HTML_INPUT_MAX,   max.ordinal());
  }

  public Widget raw(String text) {
    return append(new RawHtmlWidget(_i18n, text));
  }

  public Widget select(String name) {
    return append(HTML_SELECT).setAttribute(HTML_INPUT_NAME, name);
  }

  public Input submitImage(String href) {
    return append(new Input(_i18n)).setType(Input.Type.image)
                                   .setAttribute(HTML_SRC, href);
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

  public TabWidget tabWidget() {
    return append(new TabWidget(_i18n));
  }

  public Widget textarea(String name) {
    return append(HTML_TEXTAREA).setAttribute(HTML_INPUT_NAME, name);
  }

  public Widget ul() {
    return append(HTML_UL);
  }

  @Override
  public String toString() {
    try {
      Document document = renderDocument();
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer transformer = prepareTransformer(factory.newTransformer());
      DOMSource source = new DOMSource(document);
      StringWriter writer = new StringWriter();
      transformer.transform(source, new StreamResult(writer));
      String result = writer.toString();
      return result;
    } catch (Exception e) {
      throw new RuntimeException("Can't render HTML document", e);
    }
  }

  protected Transformer prepareTransformer(Transformer transformer) {
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    return transformer;
  }

  private Document renderDocument() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = factory.newDocumentBuilder();
    Document document = docBuilder.newDocument();
    Node root = prepareDocument(document);
    root.appendChild(render(docBuilder, document));
    return document;
  }

  protected Node prepareDocument(Document document) {
    // The root of Widgets is the document itself
    return document;
  }

  protected Element render(DocumentBuilder docBuilder, Document document) {
    Element element = document.createElement(_tag);
    element.setTextContent(_textContent);
    renderAttributes(element);
    String clazz = renderClassNames();
    if (clazz != null) {
      element.setAttribute(HTML_CLASS, renderClassNames()); 
    }
    renderChildWidgets(docBuilder, document, element);
    return element;
  }

  protected String renderClassNames() {
    Iterator<String> it = _classNames.iterator();
    if (it.hasNext()) {
      String clazz = it.next();
      while (it.hasNext()) {
        clazz += " " + it.next();
      }
      return clazz;
    }
    return null;
  }

  private void renderAttributes(Element element) {
    for (Map.Entry<String, String> a: _attributes.entrySet()) {
      element.setAttribute(a.getKey(), a.getValue());
    }
  }

  private void renderChildWidgets(DocumentBuilder docBuilder,
                                  Document document,
                                  Element parent) {
    for (Widget w: _children) {
      parent.appendChild(w.render(docBuilder, document)); 
    }
  }

};
