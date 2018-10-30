package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

public interface IServiciosLogic {

	public void createServicio(EntityManager entity);

	public void updateServicio(EntityManager entity) ;
	
	public void removeServicio(EntityManager entity) ;
}
