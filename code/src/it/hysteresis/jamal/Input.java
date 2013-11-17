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

public class Input extends Widget<Input> {

  static public enum Type {
    submit;
  }

  protected Input(Dictionary i18n) {
    super(i18n, HTML_INPUT);
  }

  public Input setName(String name) {
    return setAttribute(Widget.HTML_INPUT_NAME, name);
  }

  public Input setType(Type type) {
    return setAttribute(Widget.HTML_INPUT_TYPE, type.toString());
  }

  public Input setValue(String value) {
    return setAttribute(Widget.HTML_INPUT_VALUE, value);
  }

  public Input setValue(Enum value) {
    return setAttribute(Widget.HTML_INPUT_VALUE, value);
  }

}
