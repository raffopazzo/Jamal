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

import it.hysteresis.jamal.i18n.Dictionary;

public class GridWidget extends Widget<GridWidget> {

  public GridWidget(Dictionary dictionary) {
    super(dictionary);
    addClassName(JAMAL_CLASS_GRID);
  }

  public GridWidget() {
    this(null);
  }

  public Widget appendHeader(Object...headers) {
    return appendRow(headers).addClassName(JAMAL_CLASS_HEADER);
  }

  public Widget appendRow(Object...items) {
    Div row = div().addClassName(JAMAL_CLASS_ROW);
    for (Object obj: items) {
      if (obj == null) {
        row.div().addClassName(JAMAL_CLASS_CELL);
      } else if (obj instanceof String) {
        row.div().addClassName(JAMAL_CLASS_CELL).setTextContent(obj.toString()); 
      } else if (obj instanceof Enum) {
        row.div().addClassName(JAMAL_CLASS_CELL).setTextContent((Enum)obj);
      } else if (obj instanceof Widget) {
        row.div().addClassName(JAMAL_CLASS_CELL).append((Widget)obj);
      } else {
        throw new RuntimeException("Unexpected object: " + obj.getClass().getName());
      }
    }
    return row;
  }

};
