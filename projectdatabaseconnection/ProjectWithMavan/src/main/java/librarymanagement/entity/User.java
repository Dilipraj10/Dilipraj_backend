package librarymanagement.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password_hash")
	private String password;
	
	@OneToOne(mappedBy = "user.user_id")
	private AccountDetails accountdetails;
	
	@OneToOne(mappedBy = "user.user_id")
	private Notification notifications;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CirculationTransaction> circulationtransactions;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<HoldRequest> holdRequests;
	
}
