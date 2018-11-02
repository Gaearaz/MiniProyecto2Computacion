package co.edu.icesi.mio.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

public interface ITmio1_Servicios_DAO {

	// normales
	public void save( Tmio1Servicio servicio);

	public void update( Tmio1Servicio servicio);

	public void delete( Tmio1Servicio servicio);

	public List<Tmio1Servicio> findAll();

	public Tmio1Servicio findById( Tmio1ServicioPK id);

	// Adicionales
	public List<Tmio1Servicio> findByRangeOfDates( Calendar fechaInicio, Calendar fechaFin);

	public List<Tmio1Servicio> servicesSaturdaysAndSundaysOrJustSundays();
}
