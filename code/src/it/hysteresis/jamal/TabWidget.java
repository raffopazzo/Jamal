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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.hysteresis.jamal.i18n.Dictionary;

public class TabWidget extends Widget<TabWidget> {

  private Widget _tabsList;
  private Widget _container;

  static public class Label extends Widget<Label> {

    private boolean _selected;

    protected Label(Widget content) {
      super(null, HTML_DIV);
      addClassName(JAMAL_CLASS_TAB);
      append(content);
      _selected = false;
    }

    public Label setSelected(boolean selected) {
      _selected = selected;
      return this;
    }

    @Override
    protected Element render(Document document) {
      if (_selected) {
        addClassName(JAMAL_CLASS_SELECTED); 
      }
      return super.render(document);
    }
  }

  protected TabWidget(Dictionary i18n) {
    super(i18n);
    addClassName(JAMAL_CLASS_TAB_WIDGET);
    _tabsList = div().addClassName(JAMAL_CLASS_TAB_LIST);
    _container = div().addClassName(JAMAL_CLASS_TAB_CONTAINER);
  }

  public Label addTab(Widget tab) {
    return (Label)_tabsList.append(new Label(tab));
  }

  public TabWidget addContent(Widget tab) {
    _container.append(tab);
    return this;
  }

}
