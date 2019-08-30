package mk.pets.petclinic.services;

import mk.pets.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    /* not needed after extending interface
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
    */

}
