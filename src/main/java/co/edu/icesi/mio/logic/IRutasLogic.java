package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface IRutasLogic {

	public void create(Tmio1Ruta route);
	
	public void update(Tmio1Ruta route);
	
	public void remove(Tmio1Ruta route);
	
}
