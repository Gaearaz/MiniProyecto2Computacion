package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Ruta;

public class RutasLogic implements IRutasLogic {

	private ITmio1_Rutas_DAO DAO;


	@Override
	public void create(EntityManager entity, Tmio1Ruta route) {
		String routeNumber= route.getNumero();
		BigDecimal startDay=route.getDiaInicio();
		BigDecimal finalDay=route.getDiaFin();
		BigDecimal startTime=route.getHoraInicio();
		BigDecimal finalTime= route.getHoraFin();
		String active = route.getActiva();
		
		
		
	}
	
	@Override
	public void update(EntityManager entity, Tmio1Ruta route) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void remove(EntityManager entity, Tmio1Ruta route) {
		// TODO Auto-generated method stub
		
	}


	public List<Tmio1Ruta> findByDayRange() {
		return null;
	}


	//Validation's Stage
	
	private boolean validateRouteNumber(String number) {
		if (!number.equals("") && !(number.length()<3)) return true;
		else return false;
	}
	
	private boolean validateDay(BigDecimal day) {
		
	}
	
}
