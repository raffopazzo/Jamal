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

public class Option extends Widget<Option> {

  protected Option(Dictionary i18n) {
    super(i18n, HTML_OPTION);
  }

  public Option select() {
    return setSelected(true);
  }

  public Option setSelected(boolean selected) {
    return setAttribute(Widget.HTML_OPTION_SELECTED, selected);
  }

}
