package infra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import infra.dto.RoomDto;
import infra.service.RoomService;
import lombok.RequiredArgsConstructor;

/**
 * API
 * - host 룸 등록
 * - host 룸 삭제
 * - host 룸 수정
 */
@RequiredArgsConstructor
@RequestMapping("/host")
@Controller
public class HostController {

	private final RoomService roomService;
	

    @PostMapping("/room")
    public ResponseEntity<String> registerRoom(@RequestBody RoomDto roomDto) {
        roomService.registerRoom(roomDto);
        return ResponseEntity.ok("방이 성공적으로 등록되었습니다!");
    }
    
}
