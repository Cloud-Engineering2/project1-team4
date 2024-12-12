package infra.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import infra.common.constant.SearchType;
import infra.dto.RoomDto;
import infra.entity.Room;
import infra.repository.RoomRepository;
import infra.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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
	
	@Transactional
	public void updatRoom(Long mid, String name, Integer maxPeople, Integer price) {
	    // Room 엔티티 조회
	    Room room = roomRepository.findByMid(mid)
	        .orElseThrow(() -> new EntityNotFoundException("Room not found with mid: " + mid));
	    
	    // 수정 가능한 필드 업데이트
	    room.setName(name);
	    room.setMaxPeople(maxPeople);
	    room.setPrice(price);
	    room.setModifiedAt(LocalDateTime.now()); // 수정 시간 업데이트
	}
	
    public void deletePost() {

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
				throw new IllegalArgumentException( " " + searchType);
		}
		
		return null;
		
		
	}
	
	
	
	public List<RoomDto> getAllRooms() {
	    return roomRepository.findAll().stream()
	                         .map(room -> new RoomDto(room))  // RoomDto로 변환
	                         .collect(Collectors.toList());
	}
	
	
}
