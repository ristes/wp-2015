package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.BaseRepository;
import mk.ukim.finki.wp.persistence.StudentRepository;
import mk.ukim.finki.wp.persistence.helper.PredicateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by ristes on 11/23/15.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

  @Autowired
  BaseRepository baseRepository;

  public Student getById(Long id) {
    return baseRepository.getById(Student.class, id);
  }

  public List<Student> getByCourse(final Course course) {
    return baseRepository.find(Student.class,
      new PredicateBuilder<Student>() {
        public Predicate toPredicate(CriteriaBuilder cb,
                                     CriteriaQuery<Student> cq,
                                     Root<Student> root) {
          return cb.isMember(course, root.<List<Course>>get("courses"));
        }
      });
  }

  public Student save(Student student) {
    return baseRepository.saveOrUpdate(student);
  }

  public void delete(Student student) {
    baseRepository.delete(Student.class, student.id);
  }
}
