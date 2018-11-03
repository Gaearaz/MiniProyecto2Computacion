package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Buses_DAO;
import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Bus;

@Service
public class TMIO1_BUSES_LOGIC implements ITMIO1_BUSES_LOGIC {

	@Autowired
	private ITmio1_Buses_DAO dao_buses;

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void save(Tmio1Bus entity) throws LogicException {
		if (entity != null) {
			if (entity.getPlaca() == null || entity.getPlaca().length() != 6) {
				throw new LogicException();
			}
			if (entity.getMarca() == null || entity.getMarca().length() < 3) {
				throw new LogicException();
			}

			if (entity.getModelo() == null || entity.getModelo().toString().length() > 4) {
				throw new LogicException();
			}

			if (entity.getTipo() == null) {
				throw new LogicException();
			}
			if (!entity.getTipo().equals("P") && !entity.getTipo().equals("A") && !entity.getTipo().equals("T")) {
				throw new LogicException();
			}
			if (entity.getCapacidad() == null || entity.getCapacidad().doubleValue() <= 0) {
				throw new LogicException();
			}
			dao_buses.save(entity);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void update(Tmio1Bus entity) throws LogicException {
		if (entity != null) {
			if (entity.getPlaca() == null || entity.getPlaca().length() != 6) {
				throw new LogicException();
			}
			if (entity.getMarca() == null || entity.getMarca().length() >= 3) {
				throw new LogicException();
			}

			if (entity.getModelo() == null || entity.getModelo().toString().length() > 4) {
				throw new LogicException();
			}

			if (entity.getTipo() == null) {
				throw new LogicException();
			}
			if (!entity.getTipo().equals("P") && !entity.getTipo().equals("A") && !entity.getTipo().equals("T")) {
				throw new LogicException();
			}
			if (entity.getCapacidad() == null || entity.getCapacidad().doubleValue() <= 0) {
				throw new LogicException();
			}
			dao_buses.update(entity);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public void delete(Tmio1Bus entity) throws LogicException {
		if (entity != null) {
			dao_buses.delete(entity);
		} else {
			throw new LogicException();
		}

	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Bus> findByModel(BigDecimal model) throws LogicException {
		if (model == null || model.toString().length() > 4) {
			throw new LogicException();
		}
		return dao_buses.findByModel(model);
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Bus> findByType(String type) throws LogicException {
		if (type == null) {
			throw new LogicException();
		}
		if (!type.equals("P") && !type.equals("A") && !type.equals("T")) {
			throw new LogicException();
		}
		return dao_buses.findByType(type);
	}

	@Override
	@Transactional(rollbackFor = LogicException.class)
	public List<Tmio1Bus> findByCapacity(BigDecimal capacity) throws LogicException {
		if (capacity == null || capacity.doubleValue() <= 0) {
			throw new LogicException();
		}
		return dao_buses.findByCapacity(capacity);
	}

}
