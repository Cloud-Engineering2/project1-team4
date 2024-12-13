//package infra.controller;
//
//import java.util.List;
//
//import org.springframework.boot.system.ApplicationPid;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import infra.common.constant.SearchType;
//import infra.dto.UserDto;
//import infra.dto.request.RoomRequest;
//import infra.dto.security.BoardDetails;
//import infra.entity.constant.UserRoleType;
//import infra.service.PagingService;
//import infra.service.ReservationService;
//import lombok.RequiredArgsConstructor;
//
///**
// * API
// * guest
// * - 예약 전체 조회
// * - 예약 상세 조회
// * - 예약 등록
// * - 예약 수정
// * - 예약 삭제
// */
//@RequiredArgsConstructor
//@RequestMapping("/guest")
//@Controller
//public class GuestController {
//	
//	private final ReservationService reservationService;
//	private final PagingService pagingService;
//	
//	@GetMapping("/reservations")
//	public String getReservations() {
//	    return "";
//	}
//
//	@GetMapping("/reservation/{id}")
//	public String getReservationDetail(@PathVariable Long id) {
//	    return "";
//	}
//
//	@GetMapping("/reservation/form")
//	public String reservationFormPage() {
//	    return "";
//	}
//
//	@PostMapping("/reservation")
//	public String createReservation() {
//	    return "";
//	}
//
//	@GetMapping("/reservation/update/{id}")
//	public String updateReservationForm(@PathVariable Long id) {
//	    return "";
//	}
//
//	@PostMapping("/reservation/update/{id}")
//	public String updateReservation(@PathVariable Long id) {
//	    return "";
//	}
//
//	@PostMapping("/reservation/delete/{id}")
//	public String deleteReservation(@PathVariable Long id) {
//	    return "";
//	}
//
//	
//	
//	
//}
package infra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import infra.dto.ReservationDto;
import infra.dto.response.ReservationResponse;
import infra.service.PagingService;
import infra.service.ReservationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/guest")
@RestController
public class GuestController {

    private final ReservationService reservationService;
    private final PagingService pagingService;

    // 예약 전체 조회
    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationResponse>> getAllReservations(
            @RequestHeader("Authorization") String token,
            @RequestParam(value = "user_id", required = false) String userId,
            @RequestParam(value = "start_date", required = false) String startDate,
            @RequestParam(value = "end_date", required = false) String endDate,
            @RequestParam(value = "reservation_id", required = false) String reservationId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        
        List<ReservationResponse> reservations = pagingService.getPagedReservations(
                userId, startDate, endDate, reservationId, page, size);
        
        if (reservations.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
        return ResponseEntity.ok(reservations);
    }

    // 예약 상세 조회
    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationResponse> getReservationDetail(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id) {
        
        Optional<ReservationResponse> reservation = reservationService.getReservationById(id);
        
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // 예약 등록
    @PostMapping("/reservation")
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestHeader("Authorization") String token,
            @RequestBody ReservationDto request) {
        
        ReservationResponse response = reservationService.createReservation(request);
        
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 예약 수정 폼 표시
    @GetMapping("/reservation/update/{id}")
    public String updateReservationForm(@PathVariable Long id) {
        return "";
    }

    // 예약 수정
    @PutMapping("/reservation/update/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody ReservationDto request) {
        
        ReservationResponse response = reservationService.updateReservation(id, request);
        
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
        return ResponseEntity.ok(response);
    }

    // 예약 삭제
    @DeleteMapping("/reservation/delete/{id}")
    public ResponseEntity<Void> deleteReservation(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id) {
        
        boolean isDeleted = reservationService.deleteReservation(id);
        
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
