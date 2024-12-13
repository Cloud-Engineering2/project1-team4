//package infra.service;
//
//import java.util.List;
//import java.util.stream.IntStream;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class PagingService {
//
//	// 화면당 보여줄 페이지의 개수
//	private final static int PAGE_LENGTH = 10;
//	
//	
//	// 화면에서 start, end 페이지를 정의
//	public List<Integer> getPagingNumbers(int pageNumber, int totalPages) {
//		int startPage = Math.max((pageNumber - PAGE_LENGTH / 2),0);
//		int endPage = Math.min(startPage + PAGE_LENGTH,totalPages);
//		
//		return IntStream.range(startPage, endPage).boxed().toList();
//		
//	}
//	
//	public int getPageLength() {
//		return PAGE_LENGTH;
//	}
//
//}
package infra.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import infra.dto.response.ReservationResponse;
import infra.entity.Reservation;
import infra.repository.ReservationRepository;

@Service
public class PagingService {

    @Autowired
    private ReservationRepository reservationRepository;

    // 화면당 보여줄 페이지의 개수
    private final static int PAGE_LENGTH = 10;

    // 페이징 처리된 예약 목록 반환
    public List<ReservationResponse> getPagedReservations(String userId, String startDate, String endDate, String reservationId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Reservation> reservations = reservationRepository.findAll(pageable).getContent();
        return reservations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // 화면에서 start, end 페이지를 정의
    public List<Integer> getPagingNumbers(int pageNumber, int totalPages) {
        int startPage = Math.max((pageNumber - PAGE_LENGTH / 2), 0);
        int endPage = Math.min(startPage + PAGE_LENGTH, totalPages);

        return IntStream.range(startPage, endPage).boxed().collect(Collectors.toList());
    }

    public int getPageLength() {
        return PAGE_LENGTH;
    }

    private ReservationResponse convertToDto(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();
        response.setReservationId(reservation.getId());
        response.setRoomName("Room Name"); // 예시로 roomName을 설정
        response.setReservationDate(reservation.getStartTime().toLocalDate().toString());
        response.setStartTime(reservation.getStartTime().toString());
        response.setEndTime(reservation.getEndTime().toString());
        response.setPeopleNum(reservation.getPeopleNum());
        return response;
    }
}

