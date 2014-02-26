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

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;

import org.markdown4j.Markdown4jProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import it.hysteresis.jamal.i18n.Dictionary;

public class MarkDown extends Widget<MarkDown> {

  private String _text;

  public MarkDown(Dictionary dictionary, String text) {
    super(dictionary);
    addClassName(JAMAL_CLASS_MARKDOWN);
    _text = text;
  }

  @Override
  protected Element render(DocumentBuilder docBuilder, Document document) {
    Element element = super.render(docBuilder, document);
    try {
      String html = "<div>" + new Markdown4jProcessor().process(_text) + "</div>";
      Element content = docBuilder.parse(new InputSource(new StringReader(html)))
                                  .getDocumentElement(); 
      element.appendChild(document.importNode(content, true));
    } catch (Throwable e) {
      /* Do nothing, leaving the markdown widget empty */
      StringWriter s = new StringWriter();
      e.printStackTrace(new PrintWriter(s));
      element.setTextContent(s.toString());
    }
    return element;
  }

}
