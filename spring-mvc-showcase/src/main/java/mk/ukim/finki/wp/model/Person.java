package mk.ukim.finki.wp.model;

/**
 * Created by ristes on 10/14/15.
 */
public class Person {

  public String name;

  public String lastName;

  public String imageUrl;

  public int visits;

  @Override
  public String toString() {
    return name + " " + lastName;
  }
}
