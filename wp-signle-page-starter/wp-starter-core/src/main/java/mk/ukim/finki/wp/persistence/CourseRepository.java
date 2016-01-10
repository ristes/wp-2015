package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;

import java.util.List;

/**
 * Created by ristes on 11/23/15.
 */
public interface CourseRepository {

  Course getById(Long id);

  Course getByName(String courseName);

  void save(Course c);

  void delete(Course byId);

  List<Course> findAll();

}
