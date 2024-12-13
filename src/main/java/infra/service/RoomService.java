package infra.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import infra.common.constant.SearchType;
import infra.dto.RoomDto;
import infra.entity.Room;
import infra.repository.RoomRepository;
import infra.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomService {
	
	private final RoomRepository roomRepository;
	private final UserRepository userRepository;
	

	@Transactional
    public void registerRoom() {
		

	}
	
	public ResponseEntity<String> updateRoom(Long rid, RoomDto roomDto) {
       
		// ID로 방을 찾음
        Optional<Room> optionalRoom = roomRepository.findById(rid);

        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            // DTO의 데이터를 엔티티에 반영
            room.setName(roomDto.getName());
            room.setMaxPeople(roomDto.getMaxPeople());
            room.setPrice(roomDto.getPrice());
            room.setAddr1(roomDto.getAddr1());
            room.setAddr2(roomDto.getAddr2());
            room.setAddr3(roomDto.getAddr3());
            room.setContent(roomDto.getContent());

            // 엔티티 저장
            roomRepository.save(room);
            return ResponseEntity.ok("스터디룸 수정이 성공적으로 되었습니다");
        } else {
            return ResponseEntity.ok("스터디룸 수정이 실패했습니다");
        }
    }
	
    // 룸 삭제
    @Transactional
    public void deleteRoom(Long mid) {
        Room room = roomRepository.findById(mid).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        roomRepository.delete(room);
    }

    
   
	public Page<RoomDto> searchRooms(Pageable pageable) {
		
		
		return null;
	}

	public Page<RoomDto> searchRoomsWithTypeAndValue(SearchType searchType, String searchValue, Pageable pageable) {
		if(searchValue == null || searchValue.isBlank()) {
			
		}
		
	
		
		switch (searchType) {
	
			case REGION: {
				
				break;
			}
			case MAX_PEOPLE: {
				
				break;
			}
			case NAME: {

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + searchType);
		}
		
		return null;
		
		
	}
	
	

	
	
}