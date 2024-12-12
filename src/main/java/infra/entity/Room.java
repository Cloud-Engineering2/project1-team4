package infra.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Entity
public class Room extends AuditingFields {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    private User user;
	
	@Setter
    private String name;
	
	@Setter
    private Integer maxPeople;
	
	@Setter
    private Integer price;
	
	@Setter
    private String addr1;
	
	@Setter
    private String addr2;
	
	@Setter
    private String addr3;
    
	@Setter
    private String content;
	
	@Setter
    private Boolean isAccepted;

    
    
    protected Room() {}
    
    
	private Room(Long id, User user, String name, Integer maxPeople, Integer price, String addr1, String addr2,
			String addr3, String content, Boolean isAccepted) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.maxPeople = maxPeople;
		this.price = price;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.content = content;
		this.isAccepted = isAccepted;
	}
    
    public static Room of(Long id, User user, String name, Integer maxPeople, Integer price, String addr1, String addr2,
			String addr3, String content, Boolean isAccepted) {
    	return new Room(id, user, name, maxPeople, price, addr1, addr2,
    		 addr3, content, isAccepted);
    }
    
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }




}
