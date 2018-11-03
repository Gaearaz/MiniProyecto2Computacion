package co.edu.icesi.mio.testdao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Rutas_DAO;
import co.edu.icesi.mio.dao.Tmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class Test_Tmio1_Conductore_DAO {

	@Autowired
	private ITmio1_Conductores_DAO conductorDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {
		assertNotNull("Dao null", conductorDAO);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		tmioConductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		tmioConductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		Tmio1Conductore tmioConductor1 = new Tmio1Conductore();
		tmioConductor1.setCedula("12349");
		tmioConductor1.setNombre("Jack");
		tmioConductor1.setApellidos("Melo");
		Calendar d2 = new GregorianCalendar(2018, 01, 20);
		tmioConductor1.setFechaContratacion(d2.getTime());
		Calendar d3 = new GregorianCalendar(1999, 01, 20);
		tmioConductor1.setFechaNacimiento(d3.getTime());
		tmioConductor1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		tmioConductor1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		conductorDAO.save(tmioConductor);
		conductorDAO.save(tmioConductor1);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {
		Tmio1Conductore conductor = conductorDAO.findByCedula("12345");
		assertNotNull("Code not found", conductor);
		conductor.setNombre("Jack Jack");
		conductorDAO.update(conductor);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByName() {
		Tmio1Conductore conductor = conductorDAO.findByName("Jack").get(0);
		assertNotNull("No se encontro el conductor por ese nombre", conductor);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByLastName() {
		Tmio1Conductore conductor = conductorDAO.findByLastName("Melo").get(0);
		assertNotNull("No se encontro el conductor por ese apellido", conductor);
	}

	private void setUpEscenario1() {
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12346");
		tmioConductor.setNombre("Samantha");
		tmioConductor.setApellidos("Pocket");
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1967, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		tmioConductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		tmioConductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		conductorDAO.save(tmioConductor);

		Tmio1Conductore tmioConductor1 = new Tmio1Conductore();
		tmioConductor1.setCedula("12347");
		tmioConductor1.setNombre("Diego");
		tmioConductor1.setApellidos("Perez");
		Calendar d2 = new GregorianCalendar(2018, 01, 20);
		tmioConductor1.setFechaContratacion(d2.getTime());
		Calendar d3 = new GregorianCalendar(1997, 01, 20);
		tmioConductor1.setFechaNacimiento(d3.getTime());
		tmioConductor1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		tmioConductor1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		conductorDAO.save(tmioConductor1);
	}

	private void setUpEscenario2() {
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12348");
		tmioConductor.setNombre("Johnatan");
		tmioConductor.setApellidos("Garzon");
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1999, 03, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		tmioConductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		tmioConductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		conductorDAO.save(tmioConductor);

		Tmio1_Servicios_DAO servicioDAO = new Tmio1_Servicios_DAO();
		Tmio1ServicioPK s1PK = new Tmio1ServicioPK();
		s1PK.setCedulaConductor("12348");
		s1PK.setIdBus(-20);
		s1PK.setIdRuta(-41);
		Calendar d2 = new GregorianCalendar(2018, 1, 20);
		s1PK.setFechaInicio(d2.getTime());
		Calendar d3 = new GregorianCalendar(2018, 10, 27);
		s1PK.setFechaFin(d3.getTime());

		Tmio1Servicio s1 = new Tmio1Servicio();
		s1.setId(s1PK);
		Tmio1_Buses_DAO busDAO = new Tmio1_Buses_DAO();
		s1.setTmio1Bus(busDAO.findById(-20));
		Tmio1_Conductores_DAO conductorDAO = new Tmio1_Conductores_DAO();
		s1.setTmio1Conductore(conductorDAO.findByCedula("12348"));
		Tmio1_Rutas_DAO rutasDAO = new Tmio1_Rutas_DAO();
		s1.setTmio1Ruta(rutasDAO.findById(-41));

		Tmio1ServicioPK s2PK = new Tmio1ServicioPK();
		s2PK.setCedulaConductor("12348");
		s2PK.setIdBus(-19);
		s2PK.setIdRuta(-36);
		Calendar d4 = new GregorianCalendar(2018, 1, 27);
		s2PK.setFechaInicio(d4.getTime());
		Calendar d5 = new GregorianCalendar(2018, 10, 27);
		s2PK.setFechaFin(d5.getTime());

		Tmio1Servicio s2 = new Tmio1Servicio();
		s2.setId(s2PK);
		// Tmio1_Buses_DAO bus= new Tmio1_Buses_DAO();
		s2.setTmio1Bus(busDAO.findById(-19));
		s2.setTmio1Conductore(conductorDAO.findByCedula("12348"));
		// Tmio1_Rutas_DAO rutas2= new Tmio1_Rutas_DAO();
		s2.setTmio1Ruta(rutasDAO.findById(-36));

		servicioDAO.save(s1);
		servicioDAO.save(s2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindALlOrderedByBirthDate() {

		setUpEscenario1();
		List<Tmio1Conductore> conductores = conductorDAO.findAllOrderedByBirthDate();
		assertNotNull(conductores);
		// ASI se deja despues de eliminar a 12347 y cuando 12348 ya esta agregado
		assertEquals("12346", conductores.get(0).getCedula());
		// assertEquals("12347", conductores.get(1).getCedula());
		assertEquals("12345", conductores.get(1).getCedula());
		assertEquals("12349", conductores.get(2).getCedula());
		assertEquals("12348", conductores.get(3).getCedula());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDriversServicesInMoreThanOneBus() {

		setUpEscenario2();
		List<Tmio1Conductore> conductores = conductorDAO.driversWithServicesInMoreThanOneBus();
		assertNotNull("No existen conductores con servicios en m�s de 1 bus", conductores);
		assertEquals("12348", conductores.get(0).getCedula());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDriversThatAreFree() {
		List<Tmio1Conductore> conductores = conductorDAO.driversThatAreFree();
		assertNotNull("No existen conductores libres", conductores);
		// Es 4 antes del delete siguiente, es 3 despues del delete
		assertEquals(3, conductores.size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {
		Tmio1Conductore conductor = conductorDAO.findByCedula("12347");
		assertNotNull("El conductor NO existe", conductor);
		conductorDAO.delete(conductor);
	}
}
