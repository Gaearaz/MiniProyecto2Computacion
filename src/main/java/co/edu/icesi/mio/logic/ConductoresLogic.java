package co.edu.icesi.mio.logic;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Service
public class ConductoresLogic implements IConductoresLogic {

	private ITmio1_Conductores_DAO DAO;

	@Override
	public void create(Tmio1Conductore driver) {
		String id = driver.getCedula();
		String name = driver.getNombre();
		String lastName = driver.getApellidos();
		Date birthdayDate = driver.getFechaNacimiento();
		Date hiringDate = driver.getFechaContratacion();

		boolean vId = validateId(id);
		boolean vName = validateName(name);
		boolean vLastName = validateLastName(lastName);
		boolean vBirthdayDate = validateBirthdayDate(birthdayDate);
		boolean vHiringDate = validationHiringDate(hiringDate);

		if (vId) {
			if (vName) {
				if (vLastName) {
					if (vBirthdayDate) {
						if (vHiringDate) {
//							EntityTransaction ent = entity.getTransaction();
//							ent.begin();
							DAO.save(driver);
//							ent.commit();

							System.out.println("El conductor con ID: " + id + " , fue registrado ");
						} else
							System.out.println("La fecha de contratación debe definirse y ser menor a la fecha actual");
					} else
						System.out.println(
								"Es necesario definir la fecha de nacimiento, además de que sea mayor de edad");
				} else
					System.out.println("Por favor defina un apellido válido, tal que contenga 3 carácteres o más");
			} else
				System.out.println("Por favor defina un nombre válido, tal que contenga 3 carácteres o más");
		} else
			System.out.println("Por favor introduzca un número de cédula, compuesto por números");
	}

	@Override
	public void update(Tmio1Conductore driver) {
		String id = driver.getCedula();
		String name = driver.getNombre();
		String lastName = driver.getApellidos();
		Date birthdayDate = driver.getFechaNacimiento();
		Date hiringDate = driver.getFechaContratacion();

		boolean vId = validateId(id);
		boolean vName = validateName(name);
		boolean vLastName = validateLastName(lastName);
		boolean vBirthdayDate = validateBirthdayDate(birthdayDate);
		boolean vHiringDate = validationHiringDate(hiringDate);

		if (vId) {
			if (vName) {
				if (vLastName) {
					if (vBirthdayDate) {
						if (vHiringDate) {
//							EntityTransaction ent = entity.getTransaction();
//							ent.begin();
							DAO.update(driver);
//							ent.commit();

							System.out.println("El conductor con ID: " + id + " , fue actualizado ");
						} else
							System.out.println("La fecha de contratación debe definirse y ser menor a la fecha actual");
					} else
						System.out.println(
								"Es necesario definir la fecha de nacimiento, además de que sea mayor de edad");
				} else
					System.out.println("Por favor defina un apellido válido, tal que contenga 3 carácteres o más");
			} else
				System.out.println("Por favor defina un nombre válido, tal que contenga 3 carácteres o más");
		} else
			System.out.println("Por favor introduzca un número de cédula, compuesto por números");
	}

	@Override
	public void remove(Tmio1Conductore driver) {
//		EntityTransaction ent = entity.getTransaction();
//		ent.begin();
		DAO.delete(driver);
//		ent.commit();
	}

	public List<Tmio1Conductore> findByName(String name) {
		return DAO.findByName(name);
	}

	public List<Tmio1Conductore> findByLastName(String lastName) {
		return DAO.findByLastName(lastName);
	}

	public Tmio1Conductore findById(String id) {
		return DAO.findByCedula(id);
	}

	public List<Tmio1Conductore> findAll() {
		return DAO.findAll();
	}

	public List<Tmio1Conductore> findAllOrderedByBirthDate() {
		return DAO.findAllOrderedByBirthDate();
	}

	public List<Tmio1Conductore> driversWithServicesInMoreThanOneBus() {
		return DAO.driversWithServicesInMoreThanOneBus();
	}

	public List<Tmio1Conductore> driversThatAreFree() {
		return DAO.driversThatAreFree();
	}

	// Validations Stage

	private boolean validateId(String Id) {
		if (!Id.equals("")) {
			try {
				Integer.parseInt(Id);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean validateName(String name) {
		if (!name.equals("") && !(name.length() < 3))
			return true;
		else
			return false;
	}

	private boolean validateLastName(String lastName) {
		if (!lastName.equals("") && !(lastName.length() < 3))
			return true;
		else
			return false;
	}

	private boolean validateBirthdayDate(Date birthdayDate) {
		if (birthdayDate != null) {
			LocalDate dateBirth = birthdayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate now = LocalDate.now();
			long years = ChronoUnit.YEARS.between(dateBirth, now);
			if (years >= 18)
				return true;
			else
				return false;
		} else
			return false;
	}

	private boolean validationHiringDate(Date hiringDate) {
		if (hiringDate != null && (hiringDate.compareTo(new Date())) < 0)
			return true;
		else
			return false;

	}
}
