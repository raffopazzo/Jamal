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
package io.jamal.i18n;

public class StubDictionary implements Dictionary {
  @Override
  public Text getText(Enum phrase) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Text getText(String phrase) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getLabel(String key) {
    throw new UnsupportedOperationException(); 
  }

  @Override
  public String getLabel(Boolean value) {
    throw new UnsupportedOperationException(); 
  }

  @Override
  public String getLabel(Enum enumValue) {
    return enumValue.toString();
  }
}
