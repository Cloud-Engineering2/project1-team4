package infra.dto;

import java.time.LocalDateTime;

import infra.entity.Room;
import infra.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class RoomDto {
	private Long mid;
	private String name;
    private Integer maxPeople;
    private Integer price;
    private String addr1;
    private String addr2;
    private String addr3;
    private String content;
    private Boolean isAccepted;
    private UserDto userDto;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    

//	public static RoomDto of(Long mid, String name, Integer maxPeople, Integer price, String addr1, String addr2, String addr3, String content, UserDto userDto) {
//		return RoomDto.of(mid, name, maxPeople, price, addr1, addr2, addr3, content, userDto, null, null);
//	}
//	
//	public static RoomDto of(Long mid, String name, Integer maxPeople, Integer price, String addr1, String addr2, String addr3, String content, UserDto userDto, LocalDateTime createdDate, LocalDateTime modifiedDate) {
//		return new RoomDto(mid, name, maxPeople, price, addr1, addr2, addr3, content, userDto, createdDate, modifiedDate);
//	}

	
	public static RoomDto from(Room room) {
		return new RoomDto (
							room.getMid(),
							room.getName(),
							room.getMaxPeople(),
							room.getPrice(),
							room.getAddr1(),
							room.getAddr2(),
							room.getAddr3(),
							room.getContent(),
							room.getIsAccepted(),
							UserDto.from(room.getUser()),
	    					room.getCreatedDate(),
	    					room.getModifiedDate()
				);
	}
	
    public Room toEntity(User user) {
    	return Room.of(
						this.mid,
						user,
						this.name,
						this.maxPeople,
						this.price,
						this.addr1,
						this.addr2,
						this.addr3,
						this.content,
						this.isAccepted !=null ? this.isAccepted: false
		);
    }

	
	 public RoomDto(Long mid, String name, Integer maxPeople, Integer price, String addr1, String addr2, String addr3, String content, Boolean isAccepted,UserDto userDto) {
	        this.mid = mid;
		 	this.name = name;
	        this.maxPeople = maxPeople;
	        this.price = price;
	        this.addr1 = addr1;
	        this.addr2 = addr2;
	        this.addr3 = addr3;
	        this.content = content;
	        this.userDto = userDto;
	        this.isAccepted = isAccepted;
	    }
	 
	 public static RoomDto of(
		        String name, 
		        Integer maxPeople, 
		        Integer price, 
		        String addr1, 
		        String addr2, 
		        String addr3, 
		        String content,
		        Boolean isAccepted,
		        UserDto userDto
		    ) {
		        return new RoomDto(
		            null,
		            name, 
		            maxPeople, 
		            price, 
		            addr1, 
		            addr2, 
		            addr3, 
		            content,
		            isAccepted,
		            userDto, 
		            null,
		            null 
		        );
		    }

}
