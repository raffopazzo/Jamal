package io.jamal;
import io.jamal.i18n.Dictionary;

public class UnorderedList extends Widget<UnorderedList> {
  
  public UnorderedList(final Dictionary dictionary) {
    super(dictionary, HTML_UL);
  }

  @Override
  public <W extends Widget<? extends Widget>> W append(W widget) {
    // if widget is already an LI then stick it as it is,
    // otherwise wrap it inside an LI
    if (widget instanceof ListItem) {
      super.append(widget);
    } else {
      super.append(new ListItem(_i18n)).append(widget);
    }
    return widget;
  }
}

