package store.persistence.repositories;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import store.persistence.entities.Profile;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}