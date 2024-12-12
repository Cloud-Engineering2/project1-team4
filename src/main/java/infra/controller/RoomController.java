package infra.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import infra.dto.UserDto;
import infra.dto.security.BoardDetails;
import infra.entity.constant.UserRoleType;
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
	
	

}