package mk.ukim.finki.wp.servletshowcase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ristes on 10/26/15.
 */
public class LogoutServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // invalidate all cookies
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
      c.setMaxAge(0);
      response.addCookie(c);
    }

    request.getSession().invalidate();
    request.getRequestDispatcher("index.jsp").forward(request, response);
  }
}
