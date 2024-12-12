package infra.dto;

import infra.entity.Room;

public class RoomDto {
	
	private String name;
    private Integer maxPeople;
    private Integer price;
    private String addr1;
    private String addr2;
    private String addr3;
    private String content;
    private UserDto userDto;
    

 
    
    public RoomDto(Room room) {
        this.name = room.getName();
        this.maxPeople = room.getMaxPeople();
        this.price = room.getPrice();
        this.addr1 = room.getAddr1();
        this.addr2 = room.getAddr2();
        this.addr3 = room.getAddr3();
        this.content = room.getContent();
        this.userDto = new UserDto(room.getUser().getUid()); // assuming 'uid' is the user identifier
    }

}
