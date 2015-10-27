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
    System.out.println("Logged User: " + httpRequest.getSession().getAttribute("user"));
    System.out.println("Total requests: " + getTotalRequestsNumber(httpRequest));
    //Setting attribute
    httpRequest.setAttribute("filterAttribute", "Attribute set in filter");
    chain.doFilter(req, resp);
    System.out.println("Response status code: " + httpResponse.getStatus());
    System.out.println("Location header: " + httpResponse.getHeader("Location"));
    System.out.println("Content Type: " + httpResponse.getContentType());
    // reading attribute
    System.out.println("Filter attribute value: " + req.getAttribute("filterAttribute"));
  }

  private synchronized String getTotalRequestsNumber(HttpServletRequest httpRequest) {
    Integer numOfRequests = (Integer) httpRequest.getServletContext().
      getAttribute("numOfRequests");
    if (numOfRequests == null) {
      numOfRequests = 0;
    }

    httpRequest.getServletContext().setAttribute("numOfRequests", numOfRequests + 1);
    return "" + (numOfRequests + 1);
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
