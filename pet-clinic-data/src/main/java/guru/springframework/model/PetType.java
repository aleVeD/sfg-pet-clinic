package guru.springframework.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pet_types")
public class PetType extends BaseEntity{
  @Column(name = "name")
  private String name;

}
