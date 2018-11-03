package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Ruta;

@Repository
@Scope("singleton")
public class Tmio1_Rutas_DAO implements ITmio1_Rutas_DAO {

	@PersistenceContext
	private EntityManager entityManager;

	// adicionales
	@Override
	public List<Tmio1Ruta> findByRangeOfDays(BigDecimal diaInicio, BigDecimal diaFin) {
		String jpql = "Select r from Tmio1Ruta r Where r.diaInicio >=" + diaInicio + "and r.diaFin <=" + diaFin;
		return entityManager.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save(Tmio1Ruta ruta) {
		entityManager.persist(ruta);
	}

	@Override
	public void update(Tmio1Ruta ruta) {
		entityManager.merge(ruta);
	}

	@Override
	public void delete(Tmio1Ruta ruta) {
		ruta = entityManager.merge(ruta);
		entityManager.remove(ruta);
	}

	@Override
	public List<Tmio1Ruta> findAll() {
		String jpql = "Select r from Tmio1Ruta r";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Ruta findById(Integer id) {
		return entityManager.find(Tmio1Ruta.class, id);
	}

}
