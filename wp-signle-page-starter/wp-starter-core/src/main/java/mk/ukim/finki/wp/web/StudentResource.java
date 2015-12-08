package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.CourseRepository;
import mk.ukim.finki.wp.persistence.StudentRepository;
import mk.ukim.finki.wp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ristes on 11/23/15.
 */
@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentResource {


  @Autowired
  private FacultyService service;

  @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
  public Student byId(@PathVariable Long id) {
    return service.getStudentById(id);
  }

  @RequestMapping(value = "/student/by_course/{id}", method = RequestMethod.GET)
  public List<Student> byCourse(@PathVariable Long id) {
    return service.getCourseStudents(id);
  }



  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public Student save(@RequestParam String index, @RequestParam String name, @RequestParam String courseName) {

    return service.saveCreateStudent(index, name, name, courseName);

  }

  @RequestMapping(value = "/student/update/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Student udpate(@PathVariable Long id, @RequestParam String lastName) {
    Student student = service.getStudentById(id);
    student.lastName=lastName;
    return service.updateStudent(student);
  }

  @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
  public void delete(@PathVariable Long id) {
    service.deleteStudent(id);
  }


  @RequestMapping(value = "/course/delete/{id}", method = RequestMethod.GET)
  public void deleteCourse(@PathVariable Long id) {
    service.deleteCourse(id);
  }
}
