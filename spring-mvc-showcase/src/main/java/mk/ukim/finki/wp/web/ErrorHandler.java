package mk.ukim.finki.wp.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ristes on 11/9/15.
 */
@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public void handleException(Exception e) {
    e.printStackTrace();
  }
}


