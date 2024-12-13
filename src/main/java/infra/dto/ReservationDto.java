//package infra.dto;
//
//public class ReservationDto {
//
//}


package infra.dto;

import lombok.Data;

@Data
public class ReservationDto {
    private String roomId;
    private String guestId;
    private String startTime;
    private String endTime;
    private Integer peopleNum;
}
