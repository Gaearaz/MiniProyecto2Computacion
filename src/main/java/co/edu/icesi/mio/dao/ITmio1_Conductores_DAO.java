package co.edu.icesi.mio.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Conductore;

@Repository
@Scope("singleton")
public interface ITmio1_Conductores_DAO {

	// normales
	public void save(Tmio1Conductore conductor);

	public void update(Tmio1Conductore conductor);

	public void delete(Tmio1Conductore conductor);

	public List<Tmio1Conductore> findAll();

	// adicionales
	public List<Tmio1Conductore> findByName(String name);

	public List<Tmio1Conductore> findByLastName(String lastname);

	public Tmio1Conductore findByCedula(String cedula);

	public List<Tmio1Conductore> findAllOrderedByBirthDate();

	public List<Tmio1Conductore> driversWithServicesInMoreThanOneBus();

	public List<Tmio1Conductore> driversThatAreFree();
}
