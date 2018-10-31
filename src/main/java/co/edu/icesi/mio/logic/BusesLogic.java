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
		if(!plate.equals(null)&&plate.length()==6) return true;
		else return false;
	}
	
	private boolean validateMarca(String marca) {
		if(!marca.equals(null)&&!(marca.length()<3)) return true;
		else return false;
	}
	
	private boolean validateModel(BigDecimal model) {
		if(model!=null) {
			int n1 = model.stripTrailingZeros().precision();
			int n2 = model.stripTrailingZeros().scale();
			
			int n = n1-n2;
			String r = n+"";
		if (r.length()==4) 	return true;}
		return false;
	}
	
	private boolean validateType(String type) {
		if(type.equals("P") || type.equals("A") || type.equals("T")) 
			return true;
		
		else return false;
	}
	
	private boolean validateCapacity(BigDecimal capacity) {
		if(capacity.compareTo(BigDecimal.ZERO) > 0)	return true;
		return false;
	}

}
