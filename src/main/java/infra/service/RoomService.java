package infra.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import infra.common.constant.SearchType;
import infra.dto.RoomDto;
import infra.repository.UserRepository;
import infra.repository.RoomRepository;
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
    public void updatePost() {
		
    	
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
				throw new IllegalArgumentException("Unexpected value: " + searchType);
		}
		
		return null;
		
		
	}
	
}
