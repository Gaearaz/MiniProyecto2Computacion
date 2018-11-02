package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Servicio;

public interface IServiciosLogic {

	public void create(Tmio1Servicio service);

	public void update(Tmio1Servicio service);

	public void delete(Tmio1Servicio service);
}
