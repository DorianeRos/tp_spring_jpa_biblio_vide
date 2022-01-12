package myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import myapp.entities.Client;

@Repository
@Transactional
@PersistenceContext
public class DaoClient {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public Client addClient(Client c) {
		em.persist(c);
		System.err.println("addclient avec l\'id=" + c.getId());
		return c;
	}

}
