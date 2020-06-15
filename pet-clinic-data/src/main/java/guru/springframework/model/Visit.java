package guru.springframework.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "visits")
public class Visit extends BaseEntity{
  @Column(name = "date")
  private LocalDate date;
  @Column(name="description")
  private String description;
  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }
}
