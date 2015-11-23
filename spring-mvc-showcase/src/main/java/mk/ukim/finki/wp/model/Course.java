package mk.ukim.finki.wp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ristes on 11/16/15.
 */
@Entity
@Table(name = "wp_courses")
public class Course extends BaseEntity {

  public String name;

  @ManyToMany(fetch = FetchType.LAZY,
    mappedBy = "courses")
  public List<Student> students;

  @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
  public List<CourseResource> resources;
}
