package guru.springframework.services.springdatajpa;

import guru.springframework.model.Vet;
import guru.springframework.repositories.VetRepository;
import guru.springframework.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
  private final VetRepository vetRepository;

  public VetSDJpaService(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> listVets = new HashSet<>();
    vetRepository.findAll().forEach(listVets::add);
    return listVets;
  }

  @Override
  public Vet findById(Long ID) {
    return vetRepository.findById(ID).orElse(null);
  }

  @Override
  public Vet save(Vet object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
      vetRepository.deleteById(aLong);
  }
}
