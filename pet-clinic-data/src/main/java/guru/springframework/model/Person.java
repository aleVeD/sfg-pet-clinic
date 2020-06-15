package guru.springframework.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Person extends BaseEntity{


  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

}
