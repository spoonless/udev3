package ni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DemoHibernate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("udev3");
		try {
			EntityManager em = emf.createEntityManager();
			em.close();
		} finally {
			emf.close();
		}
	}
}
