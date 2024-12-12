package infra.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import infra.dto.RoomDto;
import infra.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * API
 * - 룸 전체조회
 * - 룸 상세조회
 */
@RequiredArgsConstructor
@RequestMapping("/room")
@Controller
@Slf4j 
public class RoomController {
	
	private final RoomService roomService;
	
  
	@GetMapping
    public String getAllRooms(ModelMap model) {
		List<RoomDto> rooms = roomService.getAllRooms();
		model.addAttribute("rooms", rooms);  // Assuming `getAllRooms()` retrieves room data
        log.info("데이터 들어는지 확인 !" +rooms);
        // 로그로 rooms 내용 확인
        for (RoomDto room : rooms) {
            System.out.println(room); // toString() 메서드가 출력됨
        }  
		return "room/index";  // JSP or Thymeleaf template to display rooms
    }
	
	
	

	

}