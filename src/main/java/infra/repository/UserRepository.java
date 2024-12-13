package infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infra.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUid(String uid);

    Optional<User> findByUid(String uid);
}
