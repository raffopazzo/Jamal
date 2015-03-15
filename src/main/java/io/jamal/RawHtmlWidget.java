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

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;

import org.markdown4j.Markdown4jProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import io.jamal.i18n.Dictionary;

public class RawHtmlWidget extends Div {

  protected String _text;

  public RawHtmlWidget(Dictionary dictionary, String text) {
    super(dictionary);
    _text = text;
    addClassName(JAMAL_CLASS_RAW);
  }

  @Override
  protected Element render(DocumentBuilder docBuilder, Document document) {
    try {
      String html = String.format("<div class=\"%s\">%s</div>",
                                  renderClassNames(),
                                  _text);
      Element content = docBuilder.parse(new InputSource(new StringReader(html)))
                                  .getDocumentElement(); 
      return (Element)document.importNode(content, true);
    } catch (Throwable e) {
      /* Do nothing, leaving the widget empty */
      return super.render(docBuilder, document);
    }
  }

}
