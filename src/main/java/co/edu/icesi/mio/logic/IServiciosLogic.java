package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Servicio;

public interface IServiciosLogic {

	public void create(EntityManager entity, Tmio1Servicio service);
	
	public void update(EntityManager entity, Tmio1Servicio service);
	
	public void delete(EntityManager entity, Tmio1Servicio service);
}
