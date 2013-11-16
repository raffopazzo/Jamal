import it.hysteresis.jamal.WebPage;

public class ExampleWebPage extends WebPage {

  static private final String CLASS_GREETINGS = "greetings";
  static private final String CSS_DEFAULT = "/default.css";
  static private final String ID_GREETINGS = "p-greetings";
  static private final String JS_DEFAULT = "/default.js";

  public ExampleWebPage() {
    addCss(CSS_DEFAULT);
    addScript(JS_DEFAULT);

    div().setClassName(CLASS_GREETINGS)
      .p("Hello world").setId(ID_GREETINGS)
                       .setClassName(CLASS_GREETINGS);
  }

}
