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

public class TabWidget extends Widget<TabWidget> {

  static public enum Target {
    _blank,
    _self;
  }

  protected TabWidget(Dictionary i18n) {
    super(i18n);
    addClassName(JAMAL_CLASS_KEY_VALUE_WIDGET);
  }

  public TabWidget addKeyValue(String key, String value) {
    Widget pair = div().addClassName(JAMAL_CLASS_KEY_VALUE_PAIR);
    pair.p(key).addClassName(JAMAL_CLASS_KEY);
    pair.p(value).addClassName(JAMAL_CLASS_VALUE);
    return this;
  }

  public TabWidget addKeyValue(Enum key, String value) {
    return addKeyValue(_i18n.getLabel(key), value);
  }

  public TabWidget addKeyValue(String key, Enum value) {
    return addKeyValue(key, _i18n.getLabel(value));
  }

  public TabWidget addKeyValue(Enum key, Enum value) {
    return addKeyValue(_i18n.getLabel(key), _i18n.getLabel(value));
  }

  public TabWidget addKeyValue(String key, Widget value) {
    Widget pair = div().addClassName(JAMAL_CLASS_KEY_VALUE_PAIR);
    pair.p(key).addClassName(JAMAL_CLASS_KEY);
    pair.div().addClassName(JAMAL_CLASS_VALUE).append(value);
    return this;
  }

  public TabWidget addKeyValue(Enum key, Widget value) {
    return addKeyValue(_i18n.getLabel(key), value);
  }

}
