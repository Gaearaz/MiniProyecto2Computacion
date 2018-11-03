package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Servicios_DAO;
import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Servicio;

@Service
public class TMIO1_SERVICIOS_LOGIC implements ITMIO1_SERVICIOS_LOGIC {

	@Autowired
	private ITmio1_Servicios_DAO dao_servicios;

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void save(Tmio1Servicio servicio) throws LogicException {
		if (servicio != null) {
			if (servicio.getTmio1Conductore() == null) {
				throw new LogicException();
			}
			/**
			 * la fecha inicio esta definida y sea menor o igual que la fecha final
			 */
			if (servicio.getId().getFechaInicio() != null && servicio.getId().getFechaFin() != null) {
				if (servicio.getId().getFechaInicio().compareTo(servicio.getId().getFechaFin()) > 0) {
					throw new LogicException();
				}
			} else {
				throw new LogicException();
			}

			List<Tmio1Servicio> list = dao_servicios.findByRangeOfDates(servicio.getId().getFechaInicio(),
					servicio.getId().getFechaInicio());
			for (Tmio1Servicio object : list) {
				if (servicio.getTmio1Conductore().getCedula().equals(object.getTmio1Conductore().getCedula())) {
					throw new LogicException();
				}
				if (servicio.getTmio1Bus().getId().equals(object.getTmio1Bus().getId())) {
					throw new LogicException();
				}
			}

			if (servicio.getId().getCedulaConductor() == null) {
				throw new LogicException();
			}

			dao_servicios.save(servicio);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void update(Tmio1Servicio servicio) throws LogicException {
		if (servicio != null) {
			if (servicio.getTmio1Conductore() == null) {
				throw new LogicException();
			}
			/**
			 * la fecha inicio esta definida y sea menor o igual que la fecha final
			 */
			if (servicio.getId().getFechaInicio() != null && servicio.getId().getFechaFin() != null) {
				if (servicio.getId().getFechaInicio().compareTo(servicio.getId().getFechaFin()) > 0) {
					throw new LogicException();
				}
			} else {
				throw new LogicException();
			}

			if (servicio.getId().getCedulaConductor() == null) {
				throw new LogicException();
			}

			dao_servicios.update(servicio);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void delete(Tmio1Servicio servicio) throws LogicException {
		if (servicio != null) {
			dao_servicios.delete(servicio);
		} else {
			throw new LogicException();
		}
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Servicio> findByRangeOfDates(Date fechaInicio, Date fechaFin) throws LogicException {
		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.compareTo(fechaFin) > 0) {
				throw new LogicException();
			}
		} else {
			throw new LogicException();
		}
		return dao_servicios.findByRangeOfDates(fechaInicio, fechaFin);
	}

}

