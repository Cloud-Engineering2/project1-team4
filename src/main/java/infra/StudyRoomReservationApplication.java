package infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // JPA 감사 기능 활성화
@SpringBootApplication
public class StudyRoomReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyRoomReservationApplication.class, args);
	}

}
