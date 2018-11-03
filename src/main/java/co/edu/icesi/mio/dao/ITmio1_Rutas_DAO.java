package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface ITmio1_Rutas_DAO {

	// normales
	public void save(Tmio1Ruta ruta);

	public void update(Tmio1Ruta ruta);

	public void delete(Tmio1Ruta ruta);

	public List<Tmio1Ruta> findAll();

	public Tmio1Ruta findById(Integer id);

	// adicionales
	public List<Tmio1Ruta> findByRangeOfDays(BigDecimal diaInicio, BigDecimal diaFin);
}
