package myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import myapp.entities.Livre;

@Repository
@Transactional
@PersistenceContext
public class DaoLivre {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	public Livre addLivre(Livre l ) {
		em.persist(l);
		System.out.println("add livre avec id = " +l.getId());
		return l;
	}

}
