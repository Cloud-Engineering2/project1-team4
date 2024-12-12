package infra.service;


import org.springframework.stereotype.Service;

import infra.repository.ReservationRepository;
import infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;

	
}
