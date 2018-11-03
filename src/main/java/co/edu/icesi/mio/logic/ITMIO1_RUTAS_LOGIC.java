package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.model.Tmio1Ruta;

public interface ITMIO1_RUTAS_LOGIC {
	public void save(Tmio1Ruta entity) throws LogicException;

	public void update(Tmio1Ruta entity) throws LogicException;

	public void delete(Tmio1Ruta entity) throws LogicException;

	public List<Tmio1Ruta> findByRangeOfDays(BigDecimal diaInicio, BigDecimal diaFin) throws LogicException;
}
