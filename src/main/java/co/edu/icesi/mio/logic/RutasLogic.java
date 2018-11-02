package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Ruta;

@Service
public class RutasLogic implements IRutasLogic {

	@Autowired
	private ITmio1_Rutas_DAO DAO;

	@Override
	public void create(Tmio1Ruta route) {
		String routeNumber = route.getNumero();
		BigDecimal startDay = route.getDiaInicio();
		BigDecimal finalDay = route.getDiaFin();
		BigDecimal startTime = route.getHoraInicio();
		BigDecimal finalTime = route.getHoraFin();
		String active = route.getActiva();

		boolean valrou = validateRouteNumber(routeNumber);
		boolean valstDay = validateDay(startDay);
		boolean valFiDay = validateDay(finalDay);
		boolean valstartTime = validateStartTime(startTime);
		boolean valfinalTime = validateEndTime(finalTime);
		boolean valActive = validateActive(active);

		if (valrou) {
			if (valstDay) {
				if (valFiDay) {
					if (startDay.compareTo(finalDay) <= 0) {
						if (valstartTime) {
							if (valfinalTime) {
								if (startTime.compareTo(finalTime) <= 0) {
									if (valfinalTime) {
										if (valActive) {

//											EntityTransaction entity1 = entity.getTransaction();
//											entity1.begin();
											DAO.save(route);
//											entity1.commit();

											System.out.println("La ruta número:" + routeNumber + "fue agregada.");
										} else
											System.out.println("El valor de activo sólo puede ser S o N");
									} else
										System.out.println("La hora de inicio debe ser menor o igual a la hora fin.");
								} else
									System.out.println("La hora fin debe estar entre 1 y 1440");
							} else
								System.out.println("La hora de inicio debe estar entre 1 y 1440");
						} else
							System.out.println("El dia inicio debe ser menor o igual al día fin");
					} else
						System.out.println("El día fin debe ser un número entre 1 y 7");
				} else
					System.out.println("El día de inicio debe ser un número entre 1 y 7");
			} else
				System.out.println("El número de ruta debe ser de 3 carácteres");
		}
	}

	@Override
	public void update(Tmio1Ruta route) {
		String routeNumber = route.getNumero();
		BigDecimal startDay = route.getDiaInicio();
		BigDecimal finalDay = route.getDiaFin();
		BigDecimal startTime = route.getHoraInicio();
		BigDecimal finalTime = route.getHoraFin();
		String active = route.getActiva();

		boolean valrou = validateRouteNumber(routeNumber);
		boolean valstDay = validateDay(startDay);
		boolean valFiDay = validateDay(finalDay);
		boolean valstartTime = validateStartTime(startTime);
		boolean valfinalTime = validateEndTime(finalTime);
		boolean valActive = validateActive(active);

		if (valrou) {
			if (valstDay) {
				if (valFiDay) {
					if (startDay.compareTo(finalDay) <= 0) {
						if (valstartTime) {
							if (valfinalTime) {
								if (startTime.compareTo(finalTime) <= 0) {
									if (valfinalTime) {
										if (valActive) {

//											EntityTransaction ent = entity.getTransaction();
//											ent.begin();
											DAO.update(route);
//											ent.commit();

											System.out.println("La ruta número:" + routeNumber + "fue agregada.");
										} else
											System.out.println("El valor de activo sólo puede ser S o N");
									} else
										System.out.println("La hora de inicio debe ser menor o igual a la hora fin.");
								} else
									System.out.println("La hora fin debe estar entre 1 y 1440");
							} else
								System.out.println("La hora de inicio debe estar entre 1 y 1440");
						} else
							System.out.println("El dia inicio debe ser menor o igual al día fin");
					} else
						System.out.println("El día fin debe ser un número entre 1 y 7");
				} else
					System.out.println("El día de inicio debe ser un número entre 1 y 7");
			} else
				System.out.println("El número de ruta debe ser de 3 carácteres");
		}
	}

	@Override
	public void remove(Tmio1Ruta route) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.delete(route);
//		ent.commit();
	}

	public List<Tmio1Ruta> findByDayRange(BigDecimal startDate, BigDecimal finalDate) {
		return DAO.findByRangeOfDays(startDate, finalDate);
	}

	public List<Tmio1Ruta> findAll() {
		return DAO.findAll();
	}

	public Tmio1Ruta findById(Integer id) {
		return DAO.findById(id);
	}

	// Validation's Stage

	private boolean validateRouteNumber(String number) {
		if (!number.equals("") && !(number.length() < 3))
			return true;
		else
			return false;
	}

	private boolean validateDay(BigDecimal day) {
		if (day.compareTo(new BigDecimal(1)) >= 0 && day.compareTo(new BigDecimal(7)) >= 0)
			return true;

		else
			return false;
	}

	private boolean validateStartTime(BigDecimal time) {
		if (time.compareTo(new BigDecimal(1)) >= 0 && time.compareTo(new BigDecimal(1440)) <= 0) {
			return true;
		} else
			return false;
	}

	private boolean validateEndTime(BigDecimal time) {
		if (time.compareTo(new BigDecimal(1)) >= 0 && time.compareTo(new BigDecimal(1440)) <= 0) {
			return true;
		} else
			return false;
	}

	private boolean validateActive(String active) {
		if (active.equals("S") || active.equals("N"))
			return true;
		else
			return false;
	}
}
