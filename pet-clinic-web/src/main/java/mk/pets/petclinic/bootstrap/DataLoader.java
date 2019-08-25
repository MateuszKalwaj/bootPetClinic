package mk.pets.petclinic.bootstrap;

import mk.pets.petclinic.model.Owner;
import mk.pets.petclinic.model.Vet;
import mk.pets.petclinic.services.OwnerService;
import mk.pets.petclinic.services.VetService;
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

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Saruman");
        owner1.setLastName("White");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Sauron");
        owner2.setLastName("Black");
        ownerService.save(owner2);

        System.out.println("Owners Loaded Successfully");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Frodo");
        vet1.setLastName("Baggins");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Gandalf");
        vet2.setLastName("Grey");
        vetService.save(vet2);

        System.out.println("Vets loaded Successfully!");
    }
}
