package infra.entity;

import java.util.Objects;

import infra.common.utils.UserRoleTypeAttributeConverter;
import infra.entity.constant.UserRoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Entity
public class User extends AuditingFields {
	
	@Column(name = "uid")
    private String uid;    
	
	@Column(length = 20)
    private String password;

    private String email;
    
    @Id
    private Long mid;  // 'mid' 속성 추가
    
    @Column
	private Long businessNum;
    
	@Column(name = "role_type", columnDefinition = "VARCHAR(50)")
    @Convert(converter = UserRoleTypeAttributeConverter.class)
    private UserRoleType userRoleType;
    
    protected User() {}
    
	private User(String uid, String password, String email, UserRoleType userRoleType, Long businessNum) {
		this.uid = uid;
		this.password = password;
		this.email = email;
		this.userRoleType = userRoleType;
		this.businessNum = businessNum;
	}
	
	public static User of(String uid, String password, String email, UserRoleType userRoleType, Long businessNum) {
		return new User(uid, password, email, userRoleType, businessNum);
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User that)) return false;
        return this.getUid() != null && this.getUid().equals(that.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUid());
    }
}
