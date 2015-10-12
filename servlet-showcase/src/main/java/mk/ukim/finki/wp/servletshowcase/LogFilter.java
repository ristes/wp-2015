package mk.ukim.finki.wp.servletshowcase;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ristes on 10/5/15.
 */
public class LogFilter implements Filter {

  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    HttpServletRequest httpRequest = (HttpServletRequest) req;
    HttpServletResponse httpResponse = (HttpServletResponse) resp;
    System.out.println("URL: " + httpRequest.getRequestURL());
    System.out.println("Method: " + httpRequest.getMethod());
    System.out.println("Params: " + httpRequest.getParameterMap());
    chain.doFilter(req, resp);
    System.out.println("Response status code: " + httpResponse.getStatus());
    System.out.println("Location header: " + httpResponse.getHeader("Location"));
    System.out.println("Content Type: " + httpResponse.getContentType());
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
