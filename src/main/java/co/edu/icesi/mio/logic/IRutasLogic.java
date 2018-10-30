package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface IRutasLogic {

	public void create(EntityManager entity, Tmio1Ruta route);
	
	public void update(EntityManager entity, Tmio1Ruta route);
	
	public void remove(EntityManager entity, Tmio1Ruta route);
	
}
