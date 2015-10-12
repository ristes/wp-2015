package mk.ukim.finki.wp.servletshowcase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ristes on 10/1/15.
 */
public class HelloWorldServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setHeader("Content-Type", "text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("  <title>Hello from WP</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>");
    out.println("    Здраво ");
    out.print(req.getParameter("name"));
    out.print(" from ");
    out.print(req.getParameter("works"));
    out.println("  </h1>");
    out.println("  <div>");
    out.print("Вие пристапувате од: ");
    out.print("<br/>");
    out.println(req.getHeader("User-Agent"));
    out.println("  </div>");
    out.println("</body>");
    out.println("</html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
