package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface ITmio1_Buses_DAO {

	// normales
	public void save(Tmio1Bus bus);

	public void update(Tmio1Bus bus);

	public void delete(Tmio1Bus bus);

	public List<Tmio1Bus> findAll();

	public Tmio1Bus findById(Integer id);

	// adicionales
	public List<Tmio1Bus> findByModel(BigDecimal model);

	public List<Tmio1Bus> findByType(String type);

	public List<Tmio1Bus> findByCapacity(BigDecimal capacity);
}
