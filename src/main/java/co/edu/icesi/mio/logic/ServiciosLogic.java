package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.Tmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@Service
public class ServiciosLogic implements IServiciosLogic {

	@Autowired
	private Tmio1_Servicios_DAO DAO;

	@Override
	public void create(Tmio1Servicio service) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.save(service);
//		ent.commit();
	}

	@Override
	public void update(Tmio1Servicio service) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.update(service);
//		ent.commit();
	}

	@Override
	public void delete(Tmio1Servicio service) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.delete(service);
//		ent.commit();
	}

	public List<Tmio1Servicio> findByRangeOfDays(Calendar initialDate, Calendar finalDate) {
		return DAO.findByRangeOfDates(initialDate, finalDate);
	}

	public List<Tmio1Servicio> findAll() {
		return DAO.findAll();
	}

	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		return DAO.findById(id);
	}

	public List<Tmio1Servicio> servicesSaturdaysAndSundaysOrJustSundays() {
		return DAO.servicesSaturdaysAndSundaysOrJustSundays();
	}

	// Validations Stage

	public boolean validateForeignKeys(Tmio1Servicio service) {
		if (!service.getId().getCedulaConductor().equals("") && service.getId().getCedulaConductor() != null) {
			if (service.getId().getIdRuta() != null) {
				if (service.getId().getIdBus() != null)
					return true;
				else
					return false;
			} else
				return false;
		}
		return false;
	}

	public boolean validateInitialDate(Date initialDate, Date finalDate) {
		if (initialDate != null && initialDate.compareTo(finalDate) <= 0)
			return true;

		return false;
	}

	public boolean validateAvailability(Tmio1Bus bus, Tmio1Conductore driver, Date initialDate, Date finalDate) {
		for (int i = 0; i < bus.getTmio1Servicios().size(); i++) {
			Tmio1Servicio aux = bus.getTmio1Servicios().get(i);
			Date initialDateAux = aux.getId().getFechaInicio();
			Date finalDateAux = aux.getId().getFechaFin();
			if ((initialDate.compareTo(initialDateAux) >= 0 && initialDate.compareTo(finalDateAux) <= 0)
					|| finalDate.compareTo(finalDateAux) <= 0 && finalDate.compareTo(initialDateAux) >= 0)
				return false;
		}
		for (int i = 0; i < driver.getTmio1Servicios().size(); i++) {
			Tmio1Servicio dri = driver.getTmio1Servicios().get(i);
			Date initialDateAux = dri.getId().getFechaInicio();
			Date finalDateAux = dri.getId().getFechaFin();

			if ((initialDate.compareTo(initialDateAux) >= 0 && initialDate.compareTo(finalDateAux) <= 0)
					|| finalDate.compareTo(finalDateAux) <= 0 && finalDate.compareTo(initialDateAux) >= 0)
				return false;
		}
		return true;
	}
}