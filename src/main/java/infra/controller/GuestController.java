package infra.controller;

import java.util.List;

import org.springframework.boot.system.ApplicationPid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import infra.common.constant.SearchType;
import infra.dto.UserDto;
import infra.dto.request.RoomRequest;
import infra.dto.security.BoardDetails;
import infra.entity.constant.UserRoleType;
import infra.service.PagingService;
import infra.service.ReservationService;
import lombok.RequiredArgsConstructor;

/**
 * API
 * guest
 * - 예약 전체 조회
 * - 예약 상세 조회
 * - 예약 등록
 * - 예약 수정
 * - 예약 삭제
 */
@RequiredArgsConstructor
@RequestMapping("/guest")
@Controller
public class GuestController {
	
	private final ReservationService reservationService;
	private final PagingService pagingService;
	
	@GetMapping
	public String getReservations(
			
	) 
	{

		
		
		return "";
	}
	
	@GetMapping("")
	public String getReservationDetail(
			
	) {

		
		return "";
	}
	
	@GetMapping("")
	public String reservationFormPage() {
		
		return "";
	}
	
	@PostMapping("")
	public String createReservation(
		
	) {


		
		return "";
	}
	

	
	@GetMapping("")
	public String updateReservationform(
			
	) {
		
		
		return "";
	}
	
	
	@PostMapping("")
	public String updateReservation(
			
			
	) {
		
		
		return "";
	}
	
	
	@PostMapping("")
    public String deleteReservation(
    		
    ) {
		
        return "";
    }
	
	
	
}