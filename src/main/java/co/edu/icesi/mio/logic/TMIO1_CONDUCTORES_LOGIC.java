package co.edu.icesi.mio.logic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Service
public class TMIO1_CONDUCTORES_LOGIC implements ITMIO1_CONDUCTORES_LOGIC {

	@Autowired
	private ITmio1_Conductores_DAO dao_conductores;

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void save(Tmio1Conductore entity) throws LogicException {
		if (entity != null) {
			if (entity.getCedula() != null) {
				try {
					Integer.parseInt(entity.getCedula());
				} catch (Exception e) {
					throw new LogicException();
				}
			} else {
				throw new LogicException();
			}

			if (entity.getNombre() == null || entity.getNombre().length() < 3) {
				throw new LogicException();
			}

			if (entity.getApellidos() == null || entity.getApellidos().length() < 3) {
				throw new LogicException();
			}

			if (entity.getFechaNacimiento() == null
					|| new Date().getYear() - entity.getFechaNacimiento().getYear() < 18) {
				throw new LogicException();
			}
			if (entity.getFechaContratacion() == null || entity.getFechaContratacion().after(new Date())) {
				throw new LogicException();
			}

			dao_conductores.save(entity);
		} else {
			throw new LogicException();
		}
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void update(Tmio1Conductore entity) throws LogicException {
		if (entity != null) {
			if (entity.getCedula() != null && dao_conductores.findByCedula(entity.getCedula()) != null) {//Verifica que la entidad a actualizar si existe
				try {
					Integer.parseInt(entity.getCedula());
				} catch (Exception e) {
					throw new LogicException();
				}
			} else {
				throw new LogicException();
			}

			if (entity.getNombre() == null || entity.getNombre().length() < 3) {
				throw new LogicException();
			}

			if (entity.getApellidos() == null || entity.getApellidos().length() < 3) {
				throw new LogicException();
			}

			if (entity.getFechaNacimiento() == null
					|| new Date().getYear() - entity.getFechaNacimiento().getYear() < 18) {
				throw new LogicException();
			}
			if (entity.getFechaContratacion() == null || entity.getFechaContratacion().after(new Date())) {
				throw new LogicException();
			}

			dao_conductores.update(entity);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void delete(Tmio1Conductore entity) throws LogicException {
		if (entity != null) {
			dao_conductores.delete(entity);
		} else {
			throw new LogicException();
		}
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Conductore> findByName(String name) throws LogicException {
		if (name == null || name.length() < 3) {
			throw new LogicException();
		}
		return dao_conductores.findByName(name);
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Conductore> findByLastName(String lastname) throws LogicException {
		if (lastname == null || lastname.length() < 3) {
			throw new LogicException();
		}
		return dao_conductores.findByLastName(lastname);
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public Tmio1Conductore findByCedula(String cedula) throws LogicException {
		if (cedula != null) {
			try {
				Integer.parseInt(cedula);
			} catch (Exception e) {
				throw new LogicException();
			}
		} else {
			throw new LogicException();
		}
		return dao_conductores.findByCedula(cedula);
	}

}
