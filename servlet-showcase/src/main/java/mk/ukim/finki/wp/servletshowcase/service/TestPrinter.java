package mk.ukim.finki.wp.servletshowcase.service;

import org.springframework.stereotype.Component;

/**
 * Created by ristes on 10/29/15.
 */
@Component
public class TestPrinter implements Printer {

  public void print(String content) {
    System.out.println(content);
  }
}