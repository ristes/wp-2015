package mk.ukim.finki.wp.servletshowcase; /**
 * Created by ristes on 10/26/15.
 */

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LogListener implements ServletContextListener,
  HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {

  // Public constructor is required by servlet spec
  public LogListener() {
  }

  // -------------------------------------------------------
  // ServletContextListener implementation
  // -------------------------------------------------------
  public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
  }

  public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
  }

  // -------------------------------------------------------
  // HttpSessionListener implementation
  // -------------------------------------------------------
  public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
  }

  public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
  }

  // -------------------------------------------------------
  // HttpSessionAttributeListener implementation
  // -------------------------------------------------------

  public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
  }

  public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
  }

  public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
  }

  public void attributeAdded(ServletRequestAttributeEvent srae) {

  }

  public void attributeRemoved(ServletRequestAttributeEvent srae) {

  }

  public void attributeReplaced(ServletRequestAttributeEvent srae) {

  }

  public void requestDestroyed(ServletRequestEvent sre) {

  }

  public void requestInitialized(ServletRequestEvent sre) {

  }
}
