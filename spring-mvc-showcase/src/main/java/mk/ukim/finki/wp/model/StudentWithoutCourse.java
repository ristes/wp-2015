package mk.ukim.finki.wp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ristes on 11/16/15.
 */
@Entity
@Table(name = "wp_student")
public class StudentWithoutCourse extends BaseEntity {

  @Column(name = "student_index")
  public String index;

  public String firstName;

  public String lastName;

  @Transient
  public int numberOfCourses;

}
