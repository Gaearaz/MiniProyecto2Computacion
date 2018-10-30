package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;

public class BusesLogic implements IBusesLogic {

	private Tmio1_Buses_DAO DAO = new Tmio1_Buses_DAO();
	
	@Override
	public void create(EntityManager entity, Tmio1Bus bus) {
		EntityTransaction ent = entity.getTransaction();
		ent.begin();
		DAO.save(entity, bus);
		ent.commit();	
	}
	
	@Override
	public void update(EntityManager entity, Tmio1Bus bus) {
		EntityTransaction ent = entity.getTransaction();
		ent.begin();
		DAO.update(entity, bus);
		ent.commit();
	}
	
	@Override
	public void remove(EntityManager entity, Tmio1Bus bus) {
		EntityTransaction ent = entity.getTransaction();
		ent.begin();
		DAO.delete(entity, bus);
		ent.commit();
	}

	
	public List<Tmio1Bus> findByModel(EntityManager entity, BigDecimal model) {
		return DAO.findByModel(entity, model);
	}
	
	public List<Tmio1Bus> findByType(EntityManager entity, String type) {
		return DAO.findByType(entity, type);
	}
	
	public List<Tmio1Bus> findByCapacity(EntityManager entity, BigDecimal capacity) {
		return DAO.findByCapacity(entity,capacity);
	}

// Validations stage

	private boolean validatePlate(String plate) {
		if(!plate.equals(null)&&plate.length()==6) {
			
		}
	}
	
	

}
