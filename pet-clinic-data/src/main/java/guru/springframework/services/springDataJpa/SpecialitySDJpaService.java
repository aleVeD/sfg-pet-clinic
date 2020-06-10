package guru.springframework.services.springDataJpa;
import guru.springframework.model.Speciality;
import guru.springframework.repositories.SpecialityRepository;
import guru.springframework.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {
  private final SpecialityRepository specialityRepository;

  public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
    this.specialityRepository = specialityRepository;
  }

  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> listSpecialities = new HashSet<>();
    specialityRepository.findAll().forEach(listSpecialities::add);
    return listSpecialities;
  }

  @Override
  public Speciality findById(Long ID) {
    return specialityRepository.findById(ID).orElse(null);
  }

  @Override
  public Speciality save(Speciality object) {
    return specialityRepository.save(object);
  }

  @Override
  public void delete(Speciality object) {
    specialityRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    specialityRepository.deleteById(aLong);
  }
}
