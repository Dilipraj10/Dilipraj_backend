package librarymanagement.service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
//import librarymanagement.entity.User;
//import librarymanagement.entity.Material;

public class MainRunner {

	public static void main(String[] args) {
		
	
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("user");
		EntityManager man = fac.createEntityManager();
		EntityTransaction trans = man.getTransaction();
		
//		User user = new User();
//		user.setFirst_name("Dilip");
//		user.setLast_name("raj");
//		user.setEmail("dilipraj123@gmail.com");
//		user.setPassword("Dilipraj@123");
		
//		Material material = new Material();
		
		trans.begin();
		man.persist(material);
		trans.commit();
		man.clear();
		
	}

}
