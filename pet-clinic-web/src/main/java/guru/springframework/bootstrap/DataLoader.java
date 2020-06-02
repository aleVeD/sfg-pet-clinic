package guru.springframework.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetTypeService;
import guru.springframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }


  /* public DataLoader() {
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();
  }

  */

  @Override
  public void run(String... args) throws Exception {
    PetType dog = new PetType();
    dog.setName("dog");
    PetType dogPetSaved = petTypeService.save(dog);
    PetType cat = new PetType();
    dog.setName("cat");
    PetType catPetSaved = petTypeService.save(cat);
    Owner owner1 = new Owner();
    //owner1.setId(1L);
    owner1.setFirstName("Mike");
    owner1.setLastName("Perez");
    owner1.setAddress("los vilos 213");
    owner1.setCity("Concepcion");
    owner1.setTelephone("21312");

    Pet mikePet = new Pet();
    mikePet.setPetType(dog);
    mikePet.setOwner(owner1);
    mikePet.setBirthday(LocalDate.now());
    mikePet.setName("Puppy");
    owner1.getPets().add(mikePet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Juana");
    owner2.setLastName("Zurita");
    owner2.setAddress("las hortencias 786");
    owner2.setCity("La Serena");
    owner2.setTelephone("912374");

    Pet juanaCat = new Pet();
    juanaCat.setName("cola de plumero");
    juanaCat.setOwner(owner2);
    juanaCat.setPetType(cat);
    juanaCat.setBirthday(LocalDate.of(2017, 03, 12));
    owner2.getPets().add(juanaCat);
    ownerService.save(owner2);

    System.out.println("Load owners");




    Vet vet1 = new Vet();
   // vet1.setId(1L);
    vet1.setFirstName("Claudio");
    vet1.setLastName("Fernandez");
    vetService.save(vet1);
    Vet vet2 = new Vet();vetService.save(vet2);
    vet2.setFirstName("Cristian");
    vet2.setLastName("Villanueva");

    System.out.println("loaded vets ..."+ vet1.getFirstName());


  }
}
