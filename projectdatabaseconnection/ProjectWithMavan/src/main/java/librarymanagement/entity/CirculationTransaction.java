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
@Table(name = "circulation_transaction")
public class CirculationTransaction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private String transactionId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Material> materials;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "tarnsaction_date")
	private Date transactionDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	@Column(name = "is_returned")
	private boolean isReturned;
	
	@Column(name = "is_renewed")
	private boolean isRenewed;
	
}
