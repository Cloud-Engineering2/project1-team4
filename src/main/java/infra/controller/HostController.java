package infra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import infra.dto.RoomDto;
import infra.entity.Room;
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
    public ResponseEntity<RoomDto> registerRoom(@RequestBody RoomDto roomDto) {
       Room room = roomService.registerRoom(roomDto);
        return ResponseEntity.status(HttpStatus.OK).body(RoomDto.from(room));
    }
    
}
