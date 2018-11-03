package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ITMIO1_BUSES_LOGIC {
	public void save(Tmio1Bus entity) throws LogicException;

	public void update(Tmio1Bus entity) throws LogicException;

	public void delete(Tmio1Bus entity) throws LogicException;

	public List<Tmio1Bus> findByModel(BigDecimal model) throws LogicException;

	public List<Tmio1Bus> findByType(String type) throws LogicException;

	public List<Tmio1Bus> findByCapacity(BigDecimal capacity) throws LogicException;
}
