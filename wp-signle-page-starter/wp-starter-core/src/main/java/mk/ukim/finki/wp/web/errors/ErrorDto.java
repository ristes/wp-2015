package mk.ukim.finki.wp.web.errors;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ristes on 12/8/15.
 */
public class ErrorDto {
  public String type;
  public String message;
  public String stackTrace;

  public final boolean error = true;

  public ErrorDto(String type, String message, String stackTrace) {
    this.type = type;
    this.message = message;
    this.stackTrace = stackTrace;
  }

  public ErrorDto(Throwable error) {
    this.type = error.getClass().getSimpleName();
    this.message = error.getMessage();
    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    error.printStackTrace(writer);
    this.stackTrace = stringWriter.toString();
  }
}
