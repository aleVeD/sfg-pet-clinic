package guru.springframework.services.map;

import guru.springframework.model.Visit;
import guru.springframework.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
  
  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public Visit findById(Long ID) {
    return super.findById(ID);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public Visit save(Visit object) {
    if(object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null
     || object.getPet().getOwner().getId() == null){
      throw  new RuntimeException("not visit");
    }
    return super.save(object);
  }
}
