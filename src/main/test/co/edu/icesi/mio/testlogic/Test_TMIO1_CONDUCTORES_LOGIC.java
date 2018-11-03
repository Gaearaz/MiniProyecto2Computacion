package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.logic.ITMIO1_CONDUCTORES_LOGIC;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_TMIO1_CONDUCTORES_LOGIC {

	@Autowired
	private ITMIO1_CONDUCTORES_LOGIC conductores_logic;

	// Save Test
	@Test
	public void acorrectSaveTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());
		conductores_logic.save(tmioConductor);
		
	}

	@Test
	public void nullSaveTest() throws LogicException {
		assertNotNull(conductores_logic);

		try {
			conductores_logic.save(null);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void cedulaNullTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
//		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void cedulaNoNumericaTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("A0014128");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void nombreNullTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
//		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void tamanoNombreMenor3Test() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("CJ");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void apellidosNullTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
//		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void tamanoApellidosMenor3Test() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Ba");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaNacimientoNullTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
//		Calendar d1 = new GregorianCalendar(1998, 01, 20);
//		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void mayorEdadTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(2008, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaContratacionNullTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
//		Calendar d = new GregorianCalendar(2018, 01, 20);
//		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaContratacionFuturoTest() {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345");
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2050, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());

		try {
			conductores_logic.save(tmioConductor);
			fail("Se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	// Update test
	@Test
	public void nullUpdate() {
		assertNotNull(conductores_logic);

		try {
			conductores_logic.update(null);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void cedulaNullUpdateTest() {
		assertNotNull(conductores_logic);
		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setCedula(null);
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void cedulaNoNumericaUpdateTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setCedula("A0014128");
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void cedulaCorrectaUpdateTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setCedula("14128");
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void bnombreNullUpdateTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setNombre(null);
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void nombreMenor3UpdateTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setNombre("iv");
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void bnombreCorrectoUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		tmioConductor.setNombre("Mateo");
		conductores_logic.update(tmioConductor);
		assertEquals("Mateo", conductores_logic.findByCedula("12345").getNombre());
	}

	@Test
	public void apellidosNullUpdateTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setApellidos(null);
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void apellidosMenor3UpdateTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setApellidos("iv");
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void apellidosCorrectoUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		tmioConductor.setApellidos("Marin");
		conductores_logic.update(tmioConductor);
		assertEquals("Marin", conductores_logic.findByCedula("12345").getApellidos());
	}

	@Test
	public void fechaNacimientoNullUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setFechaNacimiento(null);
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaNacimientoMenorUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setFechaNacimiento(new GregorianCalendar(2015, 01, 20).getTime());
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaNacimientoCorrectaUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		tmioConductor.setFechaNacimiento(new GregorianCalendar(1990, 01, 20).getTime());
		conductores_logic.update(tmioConductor);
	}

	@Test
	public void fechaContratacionNullUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setFechaContratacion(null);
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaContratacionFuturoUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			tmioConductor.setFechaNacimiento(new GregorianCalendar(2050, 01, 20).getTime());
			conductores_logic.update(tmioConductor);
			fail("Se actualizo");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaContratacionCorrectaUpdateTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		tmioConductor.setFechaContratacion(new GregorianCalendar(2010, 01, 20).getTime());
		conductores_logic.update(tmioConductor);
	}

	// Find by name test
	@Test
	public void findBynombrenullTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			List<Tmio1Conductore> list = conductores_logic.findByName(null);
			fail("Busco");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void findByNombreMenor3Test() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			List<Tmio1Conductore> list = conductores_logic.findByName("lo");
			fail("Busco");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void findByNombreCorrectoTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		List<Tmio1Conductore> list = conductores_logic.findByName("Jack");
		assertNotEquals(0, list.size());
		for (Tmio1Conductore tmio1Conductore : list) {
			assertEquals("Nombres diferentes", "Jack", tmio1Conductore.getNombre());
		}
	}

	// Find by lastname test
	@Test
	public void findByLastnameNullTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			List<Tmio1Conductore> list = conductores_logic.findByLastName(null);
			fail("Busco");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void findByLastnameMenorTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
			assertNotNull(tmioConductor);
			List<Tmio1Conductore> list = conductores_logic.findByLastName("lo");
			fail("Busco");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void findByLastNameCorrectoTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		List<Tmio1Conductore> list = conductores_logic.findByLastName("Marin");
		assertNotEquals(0, list.size());
		for (Tmio1Conductore tmio1Conductore : list) {
			assertEquals("Nombres diferentes", "Marin", tmio1Conductore.getApellidos());
		}
	}

	// find by cedula test
	@Test
	public void findByCedulaNullTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula(null);
			fail("Busco");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void findByCedulanonumericaTest() {
		assertNotNull(conductores_logic);

		try {
			Tmio1Conductore tmioConductor = conductores_logic.findByCedula("A0014128");
			fail("Busco");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void findByCedulaCorrectaTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertEquals("12345", tmioConductor.getCedula());
	}

	// Deletet Test
	@Test
	public void zdeleteTest() throws LogicException {
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = conductores_logic.findByCedula("12345");
		assertNotNull(tmioConductor);
		conductores_logic.delete(tmioConductor);
	}

	@Test
	public void deleteNullTest() {
		assertNotNull(conductores_logic);

		try {
			conductores_logic.delete(null);
			fail("Elimino");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

}
