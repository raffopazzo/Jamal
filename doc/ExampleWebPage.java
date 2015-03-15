import io.jamal.WebPage;

public class ExampleWebPage extends WebPage {

  static private final String CLASS_GREETINGS = "greetings";
  static private final String CSS_DEFAULT = "/default.css";
  static private final String ID_GREETINGS = "p-greetings";
  static private final String JS_DEFAULT = "/default.js";

  public ExampleWebPage() {
    addCss(CSS_DEFAULT);
    addScript(JS_DEFAULT);

    div().addClassName("x")
      .a("www.google.com", "Hello, world").setId(ID_GREETINGS)
                                          .addClassName(CLASS_GREETINGS);
  }

}
