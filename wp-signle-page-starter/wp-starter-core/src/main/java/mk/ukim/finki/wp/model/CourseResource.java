package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ristes on 11/16/15.
 */
@Entity
@Table(name = "wp_course_resources")
public class CourseResource extends BaseEntity {

  public String url;

  @ManyToOne
  @JoinColumn(name = "course_id")
  public Course course;

}
