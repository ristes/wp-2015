package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.persistence.BaseRepository;
import mk.ukim.finki.wp.persistence.CourseRepository;
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
public class CourseRepositoryImpl implements CourseRepository {

  @Autowired
  BaseRepository baseRepository;

  public Course getById(Long id) {
    return baseRepository.getById(Course.class, id);
  }

  public Course getByName(final String courseName) {
    List<Course> courses = baseRepository.find(Course.class, new PredicateBuilder<Course>() {
      public Predicate toPredicate(CriteriaBuilder cb, CriteriaQuery<Course> cq, Root<Course> root) {
        return cb.equal(root.get("name"), courseName);
      }
    });
    if (!courses.isEmpty()) {
      return courses.get(0);
    }
    return null;
  }

  public void save(Course c) {
    baseRepository.saveOrUpdate(c);
  }
}
