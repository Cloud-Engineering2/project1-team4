package infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infra.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	

}