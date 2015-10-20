package mk.ukim.finki.wp.servletshowcase;

import mk.ukim.finki.wp.servletshowcase.model.Employee;

import javax.servlet.RequestDispatcher;
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

    String name = req.getParameter("name");
    req.setAttribute("name", name);
    String works = req.getParameter("works");
    req.setAttribute("works", works);
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

    System.out.println("Filter attribute value: " + req.getAttribute("filterAttribute"));

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    req.setAttribute("name", name);
    String works = req.getParameter("works");
    req.setAttribute("works", works);

    // create the model
    Employee employee = new Employee();
    employee.setName(name);
    employee.setCompany(works);

    //add the model entity into the session scope
    req.getSession().setAttribute("user", employee);

    RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
    dispatcher.forward(req, resp);
  }
}
