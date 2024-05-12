package librarymanagement.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hold_requests")
public class HoldRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hold_id")
	private int holdId;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Material> materials;
	
	@Column(name = "request_date")
	private Date requestDate;
	
	@Column(name = "pickup_ready")
	private boolean pickupReady;
}
