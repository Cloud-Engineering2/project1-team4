package infra.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import infra.common.constant.SearchType;
import infra.dto.RoomDto;
import infra.entity.Room;
import infra.entity.User;
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
    public RoomDto registerRoom(RoomDto roomDto) {
		User user = userRepository.findById(roomDto.getUserDto().getUid())
									.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));
		Room room = roomDto.toEntity(user);
		room = roomRepository.save(room);
		return RoomDto.from(room);
	}
	
	@Transactional
	public Room getRoomByMid(Long mid) {
		return roomRepository.findById(mid)
								.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));
	}
	
//	@Transactional
//	public RoomDto getRoomByMid(Long mid) {
//		Room room = roomRepository.findById(mid)
//								.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));
//		return RoomDto.from(room);
//	}
		
	@Transactional
    public Room updateRoom(Room updateRoom, Long mid) {
		Room room = roomRepository.findById(mid)
									.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다"));
		
		room.setName(updateRoom.getName());
		room.setMaxPeople(updateRoom.getMaxPeople());
		room.setPrice(updateRoom.getPrice());
		room.setAddr1(updateRoom.getAddr1());
		room.setAddr2(updateRoom.getAddr2());
		room.setAddr3(updateRoom.getAddr3());
		room.setContent(updateRoom.getContent());
		room.setIsAccepted(updateRoom.getIsAccepted());
		
		return room;
    }
		
	@Transactional
    public Room deleteRoomByMid(Long mid) {
		Room room = roomRepository.findById(mid)
									.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다"));
		
		roomRepository.delete(room);
		return room;
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
	
	
	
//	public List<RoomDto> getAllRooms() {
//	    return roomRepository.findAll().stream()
//	                         .map(room -> new RoomDto(room))  // RoomDto로 변환
//	                         .collect(Collectors.toList());
//	}
	
	
}
