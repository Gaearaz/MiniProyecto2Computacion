package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;

@Service
public class BusesLogic implements IBusesLogic {

	private Tmio1_Buses_DAO DAO;

	@Override
	public void save(Tmio1Bus bus) {
		DAO.save(bus);
	}
	
	@Override
	public void create(Tmio1Bus bus) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.save(bus);
//		ent.commit();	
	}

	@Override
	public void update(Tmio1Bus bus) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.update(bus);
//		ent.commit();
	}

	@Override
	public void remove(Tmio1Bus bus) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.delete(bus);
//		ent.commit();
	}

	public List<Tmio1Bus> findByModel(BigDecimal model) {
		return DAO.findByModel(model);
	}

	public List<Tmio1Bus> findByType(String type) {
		return DAO.findByType(type);
	}

	public List<Tmio1Bus> findByCapacity(BigDecimal capacity) {
		return DAO.findByCapacity(capacity);
	}

// Validations stage

	private boolean validatePlate(String plate) {
		if (!plate.equals(null) && plate.length() == 6)
			return true;
		else
			return false;
	}

	private boolean validateMarca(String marca) {
		if (!marca.equals(null) && !(marca.length() < 3))
			return true;
		else
			return false;
	}

	private boolean validateModel(BigDecimal model) {
		if (model != null) {
			int n1 = model.stripTrailingZeros().precision();
			int n2 = model.stripTrailingZeros().scale();

			int n = n1 - n2;
			String r = n + "";
			if (r.length() == 4)
				return true;
		}
		return false;
	}

	private boolean validateType(String type) {
		if (type.equals("P") || type.equals("A") || type.equals("T"))
			return true;

		else
			return false;
	}

	private boolean validateCapacity(BigDecimal capacity) {
		if (capacity.compareTo(BigDecimal.ZERO) > 0)
			return true;
		return false;
	}

}
