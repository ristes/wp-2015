package mk.ukim.finki.wp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ristes on 12/13/15.
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

  @RequestMapping("question")
  public String question(HttpServletRequest request,HttpSession session, ServletContext context) {
    return "question";
  }
}
