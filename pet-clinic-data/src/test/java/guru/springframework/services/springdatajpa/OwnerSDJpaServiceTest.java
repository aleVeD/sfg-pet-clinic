package guru.springframework.services.springdatajpa;

import guru.springframework.model.Owner;
import guru.springframework.repositories.OwnerRepository;
import guru.springframework.repositories.PetRepository;
import guru.springframework.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  public static final String LAST_NAME = "Smith";

  @Mock
  OwnerRepository ownerRepository;
  @Mock
  PetRepository petRepository;
  @Mock
  PetTypeRepository petTypeRepository;

  @InjectMocks
  OwnerSDJpaService ownerSDJpaService;

  Owner returnedOwner;
  @BeforeEach
  void setUp() {
    returnedOwner = Owner.builder().id(3L).lastName(LAST_NAME).build();
  }

  @Test
  void findByLastName() {

    when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
    Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);
    assertEquals(LAST_NAME, owner.getLastName());
    verify(ownerRepository).findByLastName(any());
  }

  @Test
  void findAll() {
    Set<Owner> setOwners = new HashSet<>();
    setOwners.add(Owner.builder().id(2L).build());
    setOwners.add(Owner.builder().id(4L).build());
    when(ownerRepository.findAll()).thenReturn(setOwners);
    Set<Owner> owners = ownerSDJpaService.findAll();
    assertNotNull(owners);
    assertEquals(2, owners.size());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));
    Owner owner = ownerSDJpaService.findById(1L);
    assertNotNull(owner);
  }

  @Test
  void save() {
    Owner ownerToSave = Owner.builder().id(3L).build();
    when(ownerRepository.save(any())).thenReturn(ownerToSave);
    Owner owner = ownerSDJpaService.save(ownerToSave);
    assertNotNull(owner);
    verify(ownerRepository).save(any());
  }

  @Test
  void delete() {
    ownerSDJpaService.delete(returnedOwner);
    verify(ownerRepository, times(1)).delete(any());
  }

  @Test
  void deleteById() {
    ownerSDJpaService.deleteById(returnedOwner.getId());
    verify(ownerRepository).deleteById(any());
  }
}