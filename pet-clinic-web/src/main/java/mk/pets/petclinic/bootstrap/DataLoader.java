package mk.pets.petclinic.bootstrap;

import mk.pets.petclinic.model.Owner;
import mk.pets.petclinic.model.Pet;
import mk.pets.petclinic.model.PetType;
import mk.pets.petclinic.model.Vet;
import mk.pets.petclinic.services.OwnerService;
import mk.pets.petclinic.services.PetTypeService;
import mk.pets.petclinic.services.VetService;
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

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tom");
        vet2.setLastName("Riddle");
        vetService.save(vet2);

        System.out.println("Vets loaded Successfully!");
    }
}
