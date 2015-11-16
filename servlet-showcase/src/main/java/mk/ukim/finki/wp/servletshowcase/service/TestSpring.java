package mk.ukim.finki.wp.servletshowcase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by ristes on 10/29/15.
 */
public class TestSpring {

  @Autowired
  @Qualifier(value = "actualPrinter")
  private Printer printer;

  @Autowired

  TestSpring(Printer printer) {
    this.printer = printer;
  }

  @Autowired
  public void setPrinter(Printer printer) {
    this.printer = printer;
  }

  public static void main(String[] args) {
    TestSpring instance = new TestSpring(
      new TestPrinter()
    );
  }
}
