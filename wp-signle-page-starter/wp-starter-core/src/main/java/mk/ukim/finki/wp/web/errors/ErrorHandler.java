package mk.ukim.finki.wp.web.errors;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
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

  Logger logger = (Logger) LoggerFactory.getLogger(ErrorHandler.class);

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorDto handleException(Exception e) {
    logger.error(e.getMessage(), e);
    return new ErrorDto(e);
  }
}


