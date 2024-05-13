package librarymanagement.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "account_details")
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	
	@OneToOne
	private User user;
	
	@Column(name = "phone_no")
	private long phoneNo;
	
	@Column(name = "fine_amount")
	private double fineAmount;
	
	@Column(name = "fine_paid_status")
	private boolean finePaidStatus;

}
