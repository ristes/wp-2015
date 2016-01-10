package mk.ukim.finki.wp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ristes on 11/16/15.
 */
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

  @Column(name = "student_index")
  public String index;

  public String firstName;

  public String lastName;

  @ManyToMany
  public List<Course> courses;
}
