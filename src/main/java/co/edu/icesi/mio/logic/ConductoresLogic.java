package co.edu.icesi.mio.logic;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

public class ConductoresLogic implements IConductoresLogic {
	
	private ITmio1_Conductores_DAO DAO;

	@Override
	public void create(EntityManager entity, Tmio1Conductore driver) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(EntityManager entity, Tmio1Conductore driver) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void remove(EntityManager entity, Tmio1Conductore driver) {
		EntityTransaction ent = entity.getTransaction();
		ent.begin();
		DAO.delete(entity, driver);
		ent.commit();	
		}

	public List<Tmio1Conductore> findByName(EntityManager entity,String name) {
		return DAO.findByName(entity, name);
	}
	
	public List<Tmio1Conductore> findByLastName(EntityManager entity,String lastName) {
		return DAO.findByLastName(entity, lastName);
	}
	
	public Tmio1Conductore findById(EntityManager entity,String id) {
		return DAO.findByCedula(entity, id);
	}

	public List<Tmio1Conductore> findAll(EntityManager entity) {
		return DAO.findAll(entity);
	}
	public List<Tmio1Conductore> findAllOrderedByBirthDate(EntityManager entity) {
		return DAO.findAllOrderedByBirthDate(entity);
	}
	public List<Tmio1Conductore> driversWithServicesInMoreThanOneBus(EntityManager entity) {
		return DAO.driversWithServicesInMoreThanOneBus(entity);
	}
		
	public List<Tmio1Conductore> driversThatAreFree(EntityManager entity) {
		return DAO.driversThatAreFree(entity);
	}

	// Validations Stage
	
	private boolean validateId(String Id) {
		if (!Id.equals("")) {
			try {
				Integer.parseInt(Id);
				return true;
			}
			catch (Exception e) {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private boolean validateName(String name) {
		if (!name.equals("") && !(name.length()<3)) return true;
		else return false;
	}
	private boolean validateLastName(String lastName) {
		if (!lastName.equals("") && !(lastName.length()<3)) return true;
		else return false;
	}
	
	private boolean validateBirthdayDate(Date birthdayDate) {
		if(birthdayDate!=null) {
			//NO TERMINADOOOOOOOOOOOOOOOOOOOOOOO
			return null;
		}
	}
}
