package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;
  private final VisitService visitService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialityService = specialityService;
    this.visitService = visitService;
  }


  /* public DataLoader() {
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();
  }

  */

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();
    if(count == 0){
      loadData();
    }



  }

  private void loadData() {
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

    Speciality radiology = new Speciality();
    radiology.setDescription("Radiologia");
    Speciality radilogySaved = specialityService.save(radiology);
    Speciality surgery = new Speciality();
    radiology.setDescription("cirugia");
    Speciality surgerySaved = specialityService.save(surgery);
    Speciality dentistry = new Speciality();
    radiology.setDescription("Odontologia");
    Speciality dentistrySaved = specialityService.save(dentistry);


    Vet vet1 = new Vet();
    // vet1.setId(1L);
    vet1.setFirstName("Claudio");
    vet1.setLastName("Fernandez");
    vet1.getSpecialities().add(radilogySaved);
    vetService.save(vet1);
    Vet vet2 = new Vet();
    vet2.setFirstName("Cristian");
    vet2.setLastName("Villanueva");
    vet2.getSpecialities().add(surgerySaved);
    vetService.save(vet2);
    System.out.println("loaded vets ..."+ vet1.getFirstName());

    Visit visit = new Visit();
    visit.setPet(mikePet);
    visit.setDate(LocalDate.now());
    visit.setDescription("sneezy dog");
    visitService.save(visit);
  }
}
