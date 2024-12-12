package infra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import infra.service.RoomService;
import lombok.RequiredArgsConstructor;

/**
 * API
 * - 룸 전체조회
 * - 룸 상세조회
 */
@RequiredArgsConstructor
@RequestMapping("/room")
@Controller
public class RoomController {
	
	private final RoomService roomService;
	
	
	
    @GetMapping
    public String getAllRooms(ModelMap model) {
        model.addAttribute("rooms", roomService.getAllRooms());  // Assuming `getAllRooms()` retrieves room data
        return "room/list";  // JSP or Thymeleaf template to display rooms
    }

	

}