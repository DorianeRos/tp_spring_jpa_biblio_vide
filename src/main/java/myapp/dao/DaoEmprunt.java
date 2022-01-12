package myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import myapp.entities.Emprunt;

@Repository
@Transactional
@PersistenceContext
public class DaoEmprunt {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public Emprunt addEmprunt(Emprunt e) {
		em.persist(e);
		System.err.println("add emprunt avec l\'id=" + e.getId());
		return e;
	}
}
