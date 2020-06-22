package guru.springframework.services.map;

import guru.springframework.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OwnerMapServiceTest {

  OwnerMapService ownerMapService;
  final Long ownerId = 1L;
  final String lastName = "Perez";

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetServiceMap());
    ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());

  }

  @Test
  void findAll() {
    Set<Owner> setOwners = ownerMapService.findAll();
    assertEquals(1, setOwners.size());

  }

  @Test
  void findById() {
    Owner owner = ownerMapService.findById(ownerId);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void deleteById() {
    ownerMapService.delete(ownerMapService.findById(ownerId));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void delete() {
    ownerMapService.deleteById(ownerId);
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void save() {
    Long idd = 3L;
    Owner  owner2 = Owner.builder().id(idd).build();
    Owner ownwerSaved = ownerMapService.save(owner2);
    assertEquals(idd, ownwerSaved.getId());
  }
@Test
void saveNotId(){
    Owner owner = ownerMapService.save(Owner.builder().build());
    assertNotNull(owner);
    assertNotNull(owner.getId());
}
  @Test
  void findByLastName() {

    Owner perez = ownerMapService.findByLastName(lastName);
    assertNotNull(perez);
    assertEquals(perez.getLastName(),lastName);
  }
}