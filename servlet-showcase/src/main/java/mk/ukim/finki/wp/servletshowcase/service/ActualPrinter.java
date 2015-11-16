package mk.ukim.finki.wp.servletshowcase.service;

/**
 * Created by ristes on 10/29/15.
 */
public class ActualPrinter implements Printer {
  public void print(String content) {
    // connetst to real printer and pritns the text

    System.err.println(content);
  }
}
