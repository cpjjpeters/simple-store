package store.persistence.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import store.dtos.UserSummary;
import store.persistence.entities.UserJpaEntity;

import java.util.List;
import java.util.Optional;
public interface UserJpaRepository extends CrudRepository<UserJpaEntity, Long> {
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<UserJpaEntity> findByEmail(String email);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from UserJpaEntity u")
    List<UserJpaEntity> findAllWithTags();

    @Query("select u.id as id, u.email as email from UserJpaEntity u where u.profile.loyaltyPoints > :loyaltyPoints order by u.email")
    List<UserSummary> findLoyalUsers(@Param("loyaltyPoints") int loyaltyPoints);
}