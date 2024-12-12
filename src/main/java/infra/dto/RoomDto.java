package infra.dto;

public class RoomDto {
	
	private String name;
    private Integer maxPeople;
    private Integer price;
    private String addr1;
    private String addr2;
    private String addr3;
    private String content;
    private UserDto userDto;
    

	public static RoomDto of(String name, Integer maxPeople, Integer price, String addr1, String addr2, String addr3,
			String content, UserDto userDto) {
		return null;
	}
	
	 public RoomDto(String name, Integer maxPeople, Integer price, String addr1, String addr2, String addr3, String content, UserDto userDto) {
	        this.name = name;
	        this.maxPeople = maxPeople;
	        this.price = price;
	        this.addr1 = addr1;
	        this.addr2 = addr2;
	        this.addr3 = addr3;
	        this.content = content;
	        this.userDto = userDto;
	    }
	 

}
