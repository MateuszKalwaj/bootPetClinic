package mk.pets.petclinic.services;

import mk.pets.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner>findAllByLastNameLike(String lastName);

    /* not needed after extending interface
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
    */

}
