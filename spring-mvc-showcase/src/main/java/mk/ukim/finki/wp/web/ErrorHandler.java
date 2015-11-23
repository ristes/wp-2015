package mk.ukim.finki.wp.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ristes on 11/9/15.
 */
@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public String handleException(Exception e) {

    StringWriter stringWriter = new StringWriter();
    stringWriter.append("<pre>");
    PrintWriter writer = new PrintWriter(stringWriter);
    e.printStackTrace(writer);
    stringWriter.append("</pre>");
    return stringWriter.getBuffer().toString();

  }
}


