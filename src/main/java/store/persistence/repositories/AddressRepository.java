package store.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import store.persistence.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
