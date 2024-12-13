//package infra.dto.response;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.ToString;
//
//@ToString
//@Getter
//@AllArgsConstructor
//public class ReservationResponse {
//	
//	
//	
//}
package infra.dto.response;

import lombok.Data;

@Data
public class ReservationResponse {
    private Long reservationId;
    private String roomName;
    private String reservationDate;
    private String startTime;
    private String endTime;
    private Integer peopleNum;
}
