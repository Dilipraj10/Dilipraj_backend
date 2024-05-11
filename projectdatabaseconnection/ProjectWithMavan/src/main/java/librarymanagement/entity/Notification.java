package librarymanagement.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private int notificationId;
	@Column(name = "user_id")
	
	private int userId;
	
	@Column(name = "notification_type")
	private String notificationType;
	
	@Column(name =  "message")
	private String message;
	
	@Column(name = "sent_datetime")
	private Date sentDateTime;
	
	@Column(name = "is_read")
	private boolean isRead;
	
}
