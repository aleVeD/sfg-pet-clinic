package guru.springframework.services.springdatajpa;

import guru.springframework.model.Visit;
import guru.springframework.repositories.VisitRepository;
import guru.springframework.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
  private final VisitRepository visitRepository;

  public VisitSDJpaService(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> listVisit = new HashSet<>();
    visitRepository.findAll().forEach(listVisit::add);
    return listVisit;
  }

  @Override
  public Visit findById(Long id) {
    return visitRepository.findById(id).orElse(null);
  }

  @Override
  public Visit save(Visit object) {
    return visitRepository.save(object);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    visitRepository.deleteById(aLong);
  }
}
