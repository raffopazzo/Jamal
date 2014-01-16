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

public class Anchor extends Widget<Anchor> {

  static public enum Target {
    _blank,
    _self;
  }

  protected Anchor(Dictionary i18n) {
    super(i18n, HTML_A);
  }

  public Anchor setHref(String href) {
    return setAttribute(Widget.HTML_A_HREF, href);
  }

  public Anchor setTarget(Target target) {
    return setAttribute(Widget.HTML_A_TARGET, target.toString());
  }

}
