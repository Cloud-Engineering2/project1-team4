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
	@Column(name = "mid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
	
	@ManyToOne
	@JoinColumn(name = "uid")
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
    
	private Room(Long mid, User user, String name, Integer maxPeople, Integer price, String addr1, String addr2,
			String addr3, String content, Boolean isAccepted) {
		this.mid = mid;
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
	
	
    
    public static Room of(Long mid, User user, String name, Integer maxPeople, Integer price, String addr1, String addr2,
			String addr3, String content, Boolean isAccepted) {
        Room room = new Room();
        room.mid = mid;
        room.user = user;
        room.name = name;
        room.maxPeople = maxPeople;
        room.price = price;
        room.addr1 = addr1;
        room.addr2 = addr2;
        room.addr3 = addr3;
        room.content = content;
        room.isAccepted = isAccepted;
        return room;
    }
    
    
  
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room that)) return false;
        return this.getMid() != null && this.getMid().equals(that.getMid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getMid());
    }




}
