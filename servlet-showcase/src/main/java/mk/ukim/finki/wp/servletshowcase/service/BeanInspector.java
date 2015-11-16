package mk.ukim.finki.wp.servletshowcase.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by ristes on 10/29/15.
 */
public class BeanInspector implements ApplicationContextAware {

  private ApplicationContext context;

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }

  public void listPrinterBeans() {
    String[] beanNames = context.getBeanNamesForType(Printer.class);
    for (String name : beanNames) {
      Printer p = context.getBean(name, Printer.class);
      System.out.print(name + ": ");
      System.out.println(p.getClass().getName());
    }
  }

}
