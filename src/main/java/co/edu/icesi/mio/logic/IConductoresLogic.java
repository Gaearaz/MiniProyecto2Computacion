package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface IConductoresLogic {

	public void create(Tmio1Conductore driver);
	
	public void update(Tmio1Conductore driver);
	
	public void remove(Tmio1Conductore driver);
}
