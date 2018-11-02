package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Repository
@Scope("singleton")
public class Tmio1_Buses_DAO implements ITmio1_Buses_DAO {

	@PersistenceContext
	private EntityManager em;
	
	// adicionales
	@Override
	public List<Tmio1Bus> findByModel( BigDecimal model) {
		String jpql = "Select b from Tmio1Bus b where b.modelo=" + model;
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByType( String type) {
		String jpql = "Select b from Tmio1Bus b where b.tipo= '" + type + "'";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByCapacity( BigDecimal capacity) {
		String jpql = "Select b from Tmio1Bus b where b.capacidad=" + capacity;
		return em.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save( Tmio1Bus bus) {
		em.persist(bus);
	}

	@Override
	public void update( Tmio1Bus bus) {
		em.merge(bus);
	}

	@Override
	public void delete( Tmio1Bus bus) {
		em.remove(bus);
	}

	@Override
	public List<Tmio1Bus> findAll() {
		String jpql = "Select b from Tmio1Bus b";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Bus findById( Integer id) {
		return em.find(Tmio1Bus.class, id);
	}

}
