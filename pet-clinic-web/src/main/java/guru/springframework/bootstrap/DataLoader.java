package guru.springframework.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  /* public DataLoader() {
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();
  }

  */

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("Pedro");
    owner1.setLastName("Perez");
    ownerService.save(owner1);
    System.out.println("Load owners");
    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Claudio");
    vet1.setLastName("Fernandez");
    vetService.save(vet1);
    System.out.println("loaded vets ..."+ vet1.getFirstName());

  }
}
