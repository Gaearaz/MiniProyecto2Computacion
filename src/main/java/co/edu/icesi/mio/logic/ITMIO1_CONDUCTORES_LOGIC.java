package co.edu.icesi.mio.logic;

import java.util.List;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ITMIO1_CONDUCTORES_LOGIC {
	public void save(Tmio1Conductore entity) throws LogicException;

	public void update(Tmio1Conductore entity) throws LogicException;

	public void delete(Tmio1Conductore entity) throws LogicException;
	
	public List<Tmio1Conductore> findByName(String name) throws LogicException;
	
	public List<Tmio1Conductore> findByLastName(String lastname) throws LogicException;
	
	public Tmio1Conductore findByCedula(String cedula) throws LogicException;
}
