package infra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import infra.dto.RoomDto;
import infra.entity.Room;
import infra.service.RoomService;
import lombok.RequiredArgsConstructor;

/**
 * API
 * - 룸 전체조회
 * - 룸 상세조회
 * - 룸 등록
 * - 룸 수정
 * - 룸 삭제
 */
@RequiredArgsConstructor
@RequestMapping("/host")
@Controller
public class RoomController {
	
	private final RoomService roomService;
	
    @PostMapping("/room")
    public RoomDto registerRoom(@RequestBody RoomDto roomDto) {
        return roomService.registerRoom(roomDto);
    }

	@GetMapping("/room/{mid}")
	public Room getRoomByMid(@PathVariable Long mid) {
		Room room = roomService.getRoomByMid(mid);
	  	return room;
	  }
    
//	@GetMapping("/room/{mid}")
//	public Room getRoomByMid(@PathVariable Long mid) {
//		Room room = roomService.getRoomByMid(mid);
//	  	return room;
//	  }
    
//    @GetMapping("/room/{mid}")
//    public String viewRoom(@PathVariable Long mid, Model model) {
//        RoomDto roomDto = roomService.getRoomByMid(mid);
//        model.addAttribute("room", roomDto);
//        return "room/form";
//    }
	
//    @GetMapping
//    public String getAllRooms(ModelMap model) {
//        model.addAttribute("rooms", roomService.getAllRooms());  // Assuming `getAllRooms()` retrieves room data
//        return "room/list";  // JSP or Thymeleaf template to display rooms
//    }

	

}