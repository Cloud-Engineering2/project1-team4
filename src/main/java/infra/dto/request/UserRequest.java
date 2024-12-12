package infra.dto.request;

import infra.dto.UserDto;
import infra.entity.constant.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class UserRequest {
	
    private String uid;
	private String password;
    private String email;
    private UserRoleType userRoleType;
    private Long businessNum;
    
    public static UserRequest of(String uid, String password, String email,UserRoleType userRoleType) {
    	return new UserRequest(uid, password, email, userRoleType, null); 
    }
    
    public static UserRequest of(String uid, String password, String email, UserRoleType userRoleType, Long businessNum) {
    	return new UserRequest(uid, password, email, userRoleType, businessNum); 
    }
    
    public UserDto toDto(UserRoleType userRole) {
    	return UserDto.of(uid, 
    					  password, 
    					  email, 
    					  userRole);
    }
    
}
