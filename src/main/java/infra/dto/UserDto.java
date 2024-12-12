package infra.dto;

import java.time.LocalDateTime;

import infra.entity.User;
import infra.entity.constant.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    private String uid;
	private String password;
    private String email;
    private UserRoleType userRoleType;
    private Long businessNum;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    
    public static UserDto of(String uid,  String password, String email, UserRoleType userRoleType) {
    	return UserDto.of(uid, password, email, userRoleType, null, null, null);
    }
    
    public static UserDto of(String uid, String password, String email, UserRoleType userRoleType,
    		Long businessNum, LocalDateTime createdDate, LocalDateTime modifiedDate) {
    	return new UserDto(uid, password, email, userRoleType, businessNum, createdDate, modifiedDate);
    }

    
    public static UserDto from(User user) {
    	return new UserDto(
	    					user.getUid(),
	    					user.getPassword(),
	    					user.getEmail(),
	    					user.getUserRoleType(),
	    					user.getBusinessNum(),
	    					user.getCreatedDate(),
	    					user.getModifiedDate()
		);
    }
    
    public User toEntity() {
    	return User.of(
						uid,
						password, 
						email, 
						userRoleType,
						businessNum
		);
    }
    
    
    
}
