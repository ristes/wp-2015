package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.CourseRepository;
import mk.ukim.finki.wp.persistence.StudentRepository;
import mk.ukim.finki.wp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ristes on 11/30/15.
 */
@Service
public class FacultyServiceImpl implements FacultyService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

  public Student getStudentById(Long id) {
    return studentRepository.getById(id);
  }

  public List<Student> getCourseStudents(Long id) {
    Course course = courseRepository.getById(id);
    return studentRepository.getByCourse(course);
  }

  public Student saveCreateStudent(String index, String name, String lastName, String courseName) {

    if (!uniqueIndex(index)) {
      throw new IllegalArgumentException("duplicate student index");
    }
    Student student = new Student();
    student.firstName = name;
    student.lastName = lastName;
    student.index = index;
    Course c = courseRepository.getByName(courseName);
    if (c == null) {
      c = new Course();
      c.name = courseName;
      courseRepository.save(c);
    }
    student.courses = new ArrayList<Course>();
    student.courses.add(c);

    return studentRepository.save(student);
  }

  public boolean uniqueIndex(String index) {
    // TODO: implement this
    return true;
  }

  public Student updateStudent(Student student) {
    Student old = studentRepository.getById(student.id);
    if (!old.index.equals(student.index)) {
      throw new IllegalArgumentException("student index can not be changed");
    }
    studentRepository.save(student);
    return student;
  }

  public void deleteStudent(Long id) {
    studentRepository.delete(studentRepository.getById(id));
  }

  @Transactional
  public void deleteCourse(Long id) {
    List<Student> students = getCourseStudents(id);
    for (Student s : students) {
      deleteStudent(s.id);
    }
    courseRepository.delete(courseRepository.getById(id));
  }
}

