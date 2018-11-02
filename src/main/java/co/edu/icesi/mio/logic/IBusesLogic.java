package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface IBusesLogic {

	public void create(Tmio1Bus bus);

	public void update(Tmio1Bus bus);

	public void remove(Tmio1Bus bus);

	public void save(Tmio1Bus bus);
}
