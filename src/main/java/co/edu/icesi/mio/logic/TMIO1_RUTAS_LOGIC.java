package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;
import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Ruta;

@Service
public class TMIO1_RUTAS_LOGIC implements ITMIO1_RUTAS_LOGIC {

	@Autowired
	private ITmio1_Rutas_DAO dao_rutas;

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void save(Tmio1Ruta entity) throws LogicException {
		if (entity != null) {
			if (entity.getNumero() == null || entity.getNumero().length() != 3) {
				throw new LogicException();
			}
			if (entity.getDiaInicio() == null || entity.getDiaFin() == null) {
				throw new LogicException();
			}
			if (entity.getDiaInicio().intValue() < 1 || entity.getDiaFin().intValue() > 7) {
				throw new LogicException();
			}
			if (entity.getDiaInicio().compareTo(entity.getDiaFin()) > 0) {
				throw new LogicException();
			}
			if (entity.getHoraFin() == null || entity.getHoraInicio() == null) {
				throw new LogicException();
			}
			if (entity.getHoraFin().intValue() > 1440 || entity.getHoraInicio().intValue() < 1) {
				throw new LogicException();
			}
			if (entity.getHoraInicio().compareTo(entity.getHoraFin()) > 0) {
				throw new LogicException();
			}
			if (!entity.getActiva().equals("S") && !entity.getActiva().equals("N")) {
				throw new LogicException();
			}
			dao_rutas.save(entity);
		} else {
			throw new LogicException();
		}
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void update(Tmio1Ruta entity) throws LogicException {
		if (entity != null) {
			if (entity.getNumero() == null || entity.getNumero().length() != 3) {
				throw new LogicException();
			}
			if (entity.getDiaInicio() == null || entity.getDiaFin() == null) {
				throw new LogicException();
			}
			if (entity.getDiaInicio().intValue() < 1 || entity.getDiaFin().intValue() > 7) {
				throw new LogicException();
			}
			if (entity.getDiaInicio().compareTo(entity.getDiaFin()) > 0) {
				throw new LogicException();
			}
			if (entity.getHoraFin() == null || entity.getHoraInicio() == null) {
				throw new LogicException();
			}
			if (entity.getHoraFin().intValue() > 1440 || entity.getHoraInicio().intValue() < 1) {
				throw new LogicException();
			}
			if (entity.getHoraInicio().compareTo(entity.getHoraFin()) > 0) {
				throw new LogicException();
			}
			if (!entity.getActiva().equals("S") && !entity.getActiva().equals("N")) {
				throw new LogicException();
			}
			dao_rutas.update(entity);
		} else {
			throw new LogicException();
		}
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void delete(Tmio1Ruta entity) throws LogicException {
		if (entity != null) {
			dao_rutas.delete(entity);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Ruta> findByRangeOfDays(BigDecimal diaInicio, BigDecimal diaFin) throws LogicException {
		if (diaInicio == null || diaFin == null) {
			throw new LogicException();
		}
		if (diaInicio.intValue() < 1 || diaFin.intValue() > 7) {
			throw new LogicException();
		}
		if (diaInicio.compareTo(diaFin) > 0) {
			throw new LogicException();
		}
		return dao_rutas.findByRangeOfDays(diaInicio, diaFin);
	}
}