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

public class MarkDown extends RawHtmlWidget {

  public MarkDown(Dictionary dictionary, String text) {
    super(dictionary, "");
    try { 
      _text = new Markdown4jProcessor().process(text);
    } catch (Throwable e) {
      /* Do nothing leaving the markwodn widget empty */
    }
    _className = JAMAL_CLASS_MARKDOWN;
  }

}
