package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.CourseRepository;
import mk.ukim.finki.wp.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ristes on 11/23/15.
 */
@RestController
public class StudentResource {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

  @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
  public Student byId(@PathVariable Long id) {
    return studentRepository.getById(id);
  }

  @RequestMapping(value = "/student/by_course/{id}", method = RequestMethod.GET)
  public List<Student> byCourse(@PathVariable Long id) {
    Course course = courseRepository.getById(id);
    return studentRepository.getByCourse(course);
  }

  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public Student save(@RequestParam String index, @RequestParam String name, @RequestParam String courseName) {
    Student student = new Student();
    student.firstName = name;
    student.lastName = name;
    student.index = index;
    Course c = courseRepository.getByName(courseName);
    if(c==null) {
      c=new Course();
      c.name=courseName;
//      courseRepository.save(c);
    }
    student.courses = new ArrayList<Course>();
    student.courses.add(c);

    studentRepository.save(student);
    return student;
  }

  @RequestMapping(value = "/student/update/{id}", method = RequestMethod.GET)
  public void udpate(@PathVariable Long id) {

//    return studentRepository.getByCourse(course);
  }

  @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
  public void delete(@PathVariable Long id) {
    Course course = courseRepository.getById(id);
    studentRepository.getByCourse(course);
  }
}
