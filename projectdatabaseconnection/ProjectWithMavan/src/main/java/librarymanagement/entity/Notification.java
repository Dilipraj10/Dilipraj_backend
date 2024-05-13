package librarymanagement.entity;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private int notificationId;
	
	@ManyToOne
	private User user;
	
	@Column(name = "notification_type")
	private String notificationType;
	
	@Column(name =  "message")
	private String message;
	
	@Column(name = "sent_datetime")
	private Date sentDateTime;
	
	@Column(name = "is_read")
	private boolean isRead;
	
}
