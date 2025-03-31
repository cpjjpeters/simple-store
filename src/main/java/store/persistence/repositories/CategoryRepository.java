package store.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import store.persistence.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
