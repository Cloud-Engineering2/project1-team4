//package infra.service;
//
//
//import org.springframework.stereotype.Service;
//
//import infra.repository.ReservationRepository;
//import infra.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class ReservationService {
//	
//	private final ReservationRepository reservationRepository;
//	private final UserRepository userRepository;
//
//	
//}
package infra.service;

import org.springframework.stereotype.Service;
import infra.dto.ReservationDto;
import infra.dto.response.ReservationResponse;
import infra.entity.Reservation;
import infra.repository.ReservationRepository;
import infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public List<ReservationResponse> getAllReservations(String userId, String startDate, String endDate, String reservationId, int page, int size) {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<ReservationResponse> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).map(this::convertToDto);
    }

    public ReservationResponse createReservation(ReservationDto request) {
        Reservation reservation = new Reservation();
        reservation.setRoomId(Long.parseLong(request.getRoomId()));
        reservation.setUserId(Long.parseLong(request.getGuestId()));
        reservation.setStartTime(LocalDateTime.parse(request.getStartTime()));
        reservation.setEndTime(LocalDateTime.parse(request.getEndTime()));
        reservation.setPeopleNum(request.getPeopleNum());
        reservation.setCreatedDate(LocalDateTime.now());
        reservation.setModifiedDate(LocalDateTime.now());

        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToDto(savedReservation);
    }

    public ReservationResponse updateReservation(Long reservationId, ReservationDto request) {
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationId);
        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setStartTime(LocalDateTime.parse(request.getStartTime()));
            reservation.setEndTime(LocalDateTime.parse(request.getEndTime()));
            reservation.setPeopleNum(request.getPeopleNum());
            reservation.setModifiedDate(LocalDateTime.now());

            Reservation updatedReservation = reservationRepository.save(reservation);
            return convertToDto(updatedReservation);
        } else {
            return null;
        }
    }

    public boolean deleteReservation(Long reservationId) {
        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
            return true;
        } else {
            return false;
        }
    }

    private ReservationResponse convertToDto(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();
        response.setReservationId(reservation.getId());
        response.setRoomName("Room Name");
        response.setReservationDate(reservation.getStartTime().toLocalDate().toString());
        response.setStartTime(reservation.getStartTime().toString());
        response.setEndTime(reservation.getEndTime().toString());
        response.setPeopleNum(reservation.getPeopleNum());
        return response;
    }
}
