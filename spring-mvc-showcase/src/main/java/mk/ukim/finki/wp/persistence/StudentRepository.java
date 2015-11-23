package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;

import java.util.List;

/**
 * Created by ristes on 11/23/15.
 */
public interface StudentRepository {

  Student getById(Long id);

  List<Student> getByCourse(Course course);

  Student save(Student student);

  void delete(Student student);
}
