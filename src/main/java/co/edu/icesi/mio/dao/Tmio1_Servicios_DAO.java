package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@Repository
@Scope("singleton")
public class Tmio1_Servicios_DAO implements ITmio1_Servicios_DAO {

	@PersistenceContext
	private EntityManager entityManager;

	public String fecha(Date date) {
		@SuppressWarnings("deprecation")
		StringTokenizer token = new StringTokenizer(new StringTokenizer(date.toLocaleString()).nextToken(), "/");
		String dia = token.nextToken();
		String mes = token.nextToken();
		String ano = token.nextToken();
		if (dia.length() == 1) {
			return ano + "-" + mes + "-0" + dia;
		} else {
			return ano + "-" + mes + "-" + dia;
		}
	}

	@Override
	public List<Tmio1Servicio> servicesSaturdaysAndSundaysOrJustSundays() {
		BigDecimal saturday = new BigDecimal(6);
		BigDecimal sunday = new BigDecimal(7);
		String jpql = "Select s from Tmio1Servicio s Where (s.tmio1Ruta.diaInicio =" + saturday
				+ "AND s.tmio1Ruta.diaFin = " + sunday + ") or (s.tmio1Ruta.diaInicio =" + sunday
				+ "AND s.tmio1Ruta.diaFin = " + sunday + ")";
		return entityManager.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save(Tmio1Servicio servicio) {
		entityManager.persist(servicio);
	}

	@Override
	public void update(Tmio1Servicio servicio) {
		entityManager.merge(servicio);
	}

	@Override
	public void delete(Tmio1Servicio servicio) {
		servicio = entityManager.merge(servicio);
		entityManager.remove(servicio);
	}

	@Override
	public List<Tmio1Servicio> findAll() {
		String jpql = "Select s from Tmio1Servicio s";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		return entityManager.find(Tmio1Servicio.class, id);
	}

	@Override
	public List<Tmio1Servicio> findByRangeOfDates(Date fechaInicio, Date fechaFin) {
		String jpql = "Select a from Tmio1Servicio a Where a.id.fechaInicio >= '" + fecha(fechaInicio)
				+ "' and a.id.fechaFin <= '" + fecha(fechaFin) + "'";
		List<Tmio1Servicio> buses = entityManager.createQuery(jpql).getResultList();

		return buses;
	}
}
