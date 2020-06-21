package guru.springframework.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

  OwnerMapService ownerMapService;


  @BeforeEach
  void setUp() {
   // ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetServiceMap());
    //ownerMapService.save(guru.springframework.model.Owner.builder().build());

  }

  @Test
  void findAll() {
    Set<guru.springframework.model.Owner> setOwners = ownerMapService.findAll();
    assertEquals(1, setOwners.size());
  }

  @Test
  void findById() {
  }

  @Test
  void deleteById() {
  }

  @Test
  void delete() {
  }

  @Test
  void save() {
  }

  @Test
  void findByLastName() {
  }
}