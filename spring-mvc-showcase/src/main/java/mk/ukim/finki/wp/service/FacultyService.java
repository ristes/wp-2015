package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Student;

import java.util.List;

/**
 * Created by ristes on 11/30/15.
 */
public interface FacultyService {


  Student getStudentById(Long id);

  List<Student> getCourseStudents(Long id);

  Student saveCreateStudent(String index,
                            String name,
                            String lastName,
                            String courseName);

  boolean uniqueIndex(String index);

  Student updateStudent(Student student);

  void deleteStudent(Long id);

  void deleteCourse(Long id);
}
