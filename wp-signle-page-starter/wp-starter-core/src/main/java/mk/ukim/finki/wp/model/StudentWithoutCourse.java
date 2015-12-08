package mk.ukim.finki.wp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by ristes on 11/16/15.
 */
@Entity
@Table(name = "wp_student")
public class StudentWithoutCourse extends BaseEntity {

  @Column(name = "student_index", unique = true)
  public String index;

  public String firstName;

  public String lastName;

  @Transient
  public int numberOfCourses;

}
