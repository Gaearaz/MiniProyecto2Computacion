package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface IConductoresLogic {

	public void create(EntityManager entity,Tmio1Conductore driver);
	
	public void update(EntityManager entity,Tmio1Conductore driver);
	
	public void remove(EntityManager entity,Tmio1Conductore driver);
}
