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

public class FlowLayout extends Widget<FlowLayout> {

  protected FlowLayout(Dictionary i18n) {
    super(i18n, HTML_DIV);
    addClassName(JAMAL_CLASS_LAYOUT_FLOW);
  }

  @Override
  public <W extends Widget> W append(final W widget) {
    super.append(
      new Widget(_i18n, HTML_DIV) {{
        addClassName(JAMAL_CLASS_LAYOUT_ITEM);
        append(widget);
    }});
    return widget;
  }

  public FlowLayout addWidget(Widget widget) {
    append(widget);
    return this;
  }

}

