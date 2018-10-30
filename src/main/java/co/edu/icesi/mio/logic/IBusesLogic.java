package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface IBusesLogic {

	public void create(EntityManager entity, Tmio1Bus bus);
	
	public void update(EntityManager entity, Tmio1Bus bus);
	
	public void remove(EntityManager entity, Tmio1Bus bus);

	
}
