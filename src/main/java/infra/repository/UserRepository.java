package infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infra.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}