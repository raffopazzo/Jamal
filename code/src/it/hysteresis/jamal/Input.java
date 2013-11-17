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
    checkbox,
    date,
    email,
    hidden,
    number,
    password,
    submit,
    text,
    time;
  }

  protected Input(Dictionary i18n) {
    super(i18n, HTML_INPUT);
  }

  public Input setChecked(boolean checked) {
    return setAttribute(HTML_INPUT_CHECKED, checked);
  }

  public Input setMax(int max) {
    return setAttribute(HTML_INPUT_MAX, max);
  }

  public Input setMin(int min) {
    return setAttribute(HTML_INPUT_MIN, min);
  }

  public Input setName(String name) {
    return setAttribute(HTML_INPUT_NAME, name);
  }

  public Input setPlaceHolder(String placeholder) {
    return setAttribute(HTML_INPUT_PLACEHOLDER, placeholder);
  }

  public Input setPlaceHolder(Enum text) {
    return setAttribute(HTML_INPUT_PLACEHOLDER, text);
  }

  public Input setStep(int step) {
    return setAttribute(HTML_INPUT_STEP, step);
  }

  public Input setType(Type type) {
    return setAttribute(HTML_INPUT_TYPE, type.toString());
  }

  public Input setValue(String value) {
    return setAttribute(HTML_INPUT_VALUE, value);
  }

  public Input setValue(Enum value) {
    return setAttribute(HTML_INPUT_VALUE, value);
  }

}
