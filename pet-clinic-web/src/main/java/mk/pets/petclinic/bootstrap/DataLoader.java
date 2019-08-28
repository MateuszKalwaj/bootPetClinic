package mk.pets.petclinic.bootstrap;

import mk.pets.petclinic.model.*;
import mk.pets.petclinic.services.OwnerService;
import mk.pets.petclinic.services.PetTypeService;
import mk.pets.petclinic.services.SpecialtyService;
import mk.pets.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Saruman");
        owner1.setLastName("White");
        owner1.setAddress("Debowa 3");
        owner1.setCity("Koszalin");
        owner1.setTelephone("568798456");
        Pet sarumansPet = new Pet();
        sarumansPet.setPetType(savedDogPetType);
        sarumansPet.setOwner(owner1);
        sarumansPet.setBirthDate(LocalDate.now());
        sarumansPet.setName("Balrog");
        owner1.getPets().add(sarumansPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sauron");
        owner2.setLastName("Black");
        owner2.setAddress("Polnej Drogi 19");
        owner2.setCity("Koszalin");
        owner2.setTelephone("342234981");

        Pet sauronsPet = new Pet();
        sauronsPet.setName("Koliber");
        sauronsPet.setBirthDate(LocalDate.now());
        sauronsPet.setOwner(owner2);
        sauronsPet.setPetType(savedCatPetType);
        owner2.getPets().add(sauronsPet);

        ownerService.save(owner2);

        System.out.println("Owners Loaded Successfully");

        Vet vet1 = new Vet();
        vet1.setFirstName("Harry");
        vet1.setLastName("Potter");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tom");
        vet2.setLastName("Riddle");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Vets loaded Successfully!");
    }
}
