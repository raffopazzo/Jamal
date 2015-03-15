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

import io.jamal.i18n.Dictionary;

public class GridWidget extends Widget<GridWidget> {

  public GridWidget(Widget<? extends Widget> parent) {
    super(parent);
    addClassName(JAMAL_CLASS_GRID);
  }

  public GridWidget(Dictionary dictionary) {
    super(dictionary);
    addClassName(JAMAL_CLASS_GRID);
  }

  public GridWidget() {
  }

  public GridRowWidget appendHeader(Object...headers) {
    return appendRow(headers).addClassName(JAMAL_CLASS_HEADER);
  }

  public GridRowWidget appendRow(Object...items) {
    if (items.length == 1 && items[0] instanceof GridRowWidget) {
      append((GridRowWidget)items[0]);
      return (GridRowWidget)items[0];
    } else {
      GridRowWidget row = new GridRowWidget(this);
      for (Object obj: items) {
        if (obj == null) {
          row.div();
        } else if (obj instanceof String) {
          row.p((String)obj); 
        } else if (obj instanceof Enum) {
          row.p((Enum)obj);
        } else if (obj instanceof Widget) {
          row.append((Widget<? extends Widget>)obj);
        } else {
          throw new RuntimeException("Unexpected object: " + obj.getClass().getName());
        }
      }
      return row;
    }
  }

  static public class GridRowWidget extends Widget<GridRowWidget> {
    public GridRowWidget() {
      super(null, HTML_DIV);
      addClassName(JAMAL_CLASS_ROW);
    }

    public GridRowWidget(Widget<? extends Widget> parent) {
      super(parent._i18n, HTML_DIV);
      parent.append(this);
      addClassName(JAMAL_CLASS_ROW);
    }

    @Override
    public <W extends Widget<? extends Widget>> W append(W widget) {
      super.append(new Div(_i18n).addClassName(JAMAL_CLASS_CELL))
           .append(widget);
      return widget;
    }
  }

};
