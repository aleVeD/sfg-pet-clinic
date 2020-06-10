package guru.springframework.services.springDataJpa;

import guru.springframework.model.Pet;
import guru.springframework.repositories.PetRepository;
import guru.springframework.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {
  private final PetRepository petRepository;

  public PetSDJpaService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> listPets = new HashSet<>();
    petRepository.findAll().forEach(listPets::add);
    return listPets;
  }

  @Override
  public Pet findById(Long ID) {
    return petRepository.findById(ID).orElse(null);
  }

  @Override
  public Pet save(Pet object) {
    return petRepository.save(object);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    petRepository.deleteById(aLong);
  }
}
