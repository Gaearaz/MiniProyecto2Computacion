package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@Repository
@Scope("singleton")
public class Tmio1_Servicios_DAO implements ITmio1_Servicios_DAO{

	@PersistenceContext
	private EntityManager em;
	
	//adicionales
	@Override
	public List<Tmio1Servicio> findByRangeOfDates( Calendar fechaInicio, Calendar fechaFin) {
		
		String cadenaInicio="'"+fechaInicio.get(Calendar.YEAR)+"-"+fechaInicio.get(Calendar.MONTH)+"-"+fechaInicio.get(Calendar.DAY_OF_MONTH)+"'";
		String cadenaFin= "'"+fechaFin.get(Calendar.YEAR)+"-"+fechaFin.get(Calendar.MONTH)+"-"+fechaFin.get(Calendar.DAY_OF_MONTH)+"'";
		String jpql = "Select s from Tmio1Servicio s Where s.id.fechaInicio>=" + cadenaInicio + "and s.id.fechaFin<=" + cadenaFin;
		
		return 	em.createQuery(jpql).getResultList();
	}
	
	@Override
	public List<Tmio1Servicio> servicesSaturdaysAndSundaysOrJustSundays() {
		BigDecimal saturday= new BigDecimal(6);
		BigDecimal sunday= new BigDecimal(7);
		String jpql = "Select s from Tmio1Servicio s Where (s.tmio1Ruta.diaInicio ="+ saturday+ "AND s.tmio1Ruta.diaFin = " + sunday+ 
				") or (s.tmio1Ruta.diaInicio ="+ sunday+ "AND s.tmio1Ruta.diaFin = " + sunday + ")";
		return 	em.createQuery(jpql).getResultList();
	}

	//normales
	@Override
	public void save( Tmio1Servicio servicio) {
		em.persist(servicio);
	}

	@Override
	public void update( Tmio1Servicio servicio) {
		em.merge(servicio);
	}

	@Override
	public void delete( Tmio1Servicio servicio) {
		em.remove(servicio);
	}

	@Override
	public List<Tmio1Servicio> findAll() {
		String jpql = "Select s from Tmio1Servicio s";
		return 	em.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Servicio findById( Tmio1ServicioPK id) {
		return em.find(Tmio1Servicio.class, id);
	}
}
