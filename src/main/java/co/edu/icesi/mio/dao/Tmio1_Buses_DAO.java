package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Bus;

@Repository
@Scope("singleton")
public class Tmio1_Buses_DAO implements ITmio1_Buses_DAO {

	@PersistenceContext
	private EntityManager entityManager;

	// adicionales
	@Override
	public List<Tmio1Bus> findByModel(BigDecimal model) {
		String jpql = "Select b from Tmio1Bus b where b.modelo=" + model;
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByType(String type) {
		String jpql = "Select b from Tmio1Bus b where b.tipo= '" + type + "'";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByCapacity(BigDecimal capacity) {
		String jpql = "Select b from Tmio1Bus b where b.capacidad=" + capacity;
		return entityManager.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save(Tmio1Bus bus) {
		entityManager.persist(bus);
	}

	@Override
	public void update(Tmio1Bus bus) {
		entityManager.merge(bus);
	}

	@Override
	public void delete(Tmio1Bus bus) {
		bus = entityManager.merge(bus);
		entityManager.remove(bus);
	}

	@Override
	public List<Tmio1Bus> findAll() {
		String jpql = "Select b from Tmio1Bus b";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		return entityManager.find(Tmio1Bus.class, id);
	}

}
