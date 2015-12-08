package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Person;
import mk.ukim.finki.wp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ristes on 11/9/15.
 */
@Controller
@RequestMapping()
public class TestResource {

  @Autowired
  RequestMappingHandlerMapping requestMappingHandlerMapping;

  @PostConstruct
  public void init() {
    // configure
  }


  @RequestMapping(value = "/info", method = RequestMethod.GET)
  @ResponseBody
  public Map<RequestMappingInfo, HandlerMethod> info() {
    return requestMappingHandlerMapping.getHandlerMethods();
  }

  @RequestMapping(value = "/base/{id}", method = RequestMethod.GET)
  @ResponseBody
  public User info(@PathVariable Long id, @RequestParam String param) {
    User user = new User();
    user.id = id;
    user.name = param;
    return user;
  }

  @RequestMapping(value = "/model/{id}", method = RequestMethod.GET)
  public ModelAndView modelAndView(@PathVariable Long id, @RequestParam String param) {
    User user = new User();
    user.id = id;
    user.name = param;
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("user", user);
    return modelAndView;
  }

  @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
  public String view(@PathVariable Long id, @RequestParam String param,
                     HttpServletRequest request,
                     HttpServletResponse response,
                     HttpSession session) {
    response.setStatus(HttpStatus.ACCEPTED.value());
    User user = new User();
    user.id = id;
    user.name = param;
    return "index";
  }

  @RequestMapping(value = "/session/{name}", method = RequestMethod.GET)
  @ResponseBody
  public Object view(@PathVariable String name,
                     HttpSession session) {
    return session.getAttribute(name);
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  @ResponseBody
  public Object view(@RequestBody User user, HttpSession session) {
    session.setAttribute("user", user);
    return user;
  }


  @RequestMapping(value = "/persons", method = RequestMethod.GET)
  @ResponseBody
  public List<Person> persons() {
    List<Person> persons = new ArrayList<Person>();

    for (int i = 0; i < 100; i++) {
      Person p = new Person();
      p.name = "Riste" + i;
      p.lastName = "Stojanov" + i;
      p.imageUrl = "http://finki.ukim.mk/content/dataImages/staff/small/Stojanov_Riste.jpg";
      p.visits = i;
      persons.add(p);
    }
    return persons;
  }

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  @ResponseBody
  public boolean ping() {
    return true;
  }



}
