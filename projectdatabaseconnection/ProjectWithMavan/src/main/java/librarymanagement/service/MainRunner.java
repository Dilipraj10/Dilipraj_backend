package librarymanagement.service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import librarymanagement.entity.*;


public class MainRunner { 

	public static void main(String[] args) {
		
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		User user = new User();
		Material material = new Material();
		CirculationTransaction circulationtransaction = new CirculationTransaction();
		Notification notification = new Notification();
		HoldRequest holdrequest = new HoldRequest();
		AccountDetails accountdetails = new AccountDetails();
		
		
		user.setFirst_name("Dilip");
		user.setLast_name("raj");
		user.setEmail("dilipraj123@gmail.com");
		user.setPassword("Dilipraj@123");
		
		
		
		
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		manager.clear();
		
	}

}
