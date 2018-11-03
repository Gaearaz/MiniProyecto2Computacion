package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.logic.ITMIO1_BUSES_LOGIC;
import co.edu.icesi.mio.model.Tmio1Bus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_TMIO1_BUSES_LOGIC {

	@Autowired
	private ITMIO1_BUSES_LOGIC buses_logica;

	@Test
	public void agregadoCorrectoTest() throws LogicException {
		assertNotNull(buses_logica);
		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("SDF457");
		bus.setCapacidad(new BigDecimal(1000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setTipo("T");

		buses_logica.save(bus);
	}

	@Test
	public void placaMayor6ElementosTest() throws LogicException {
		assertNotNull(buses_logica);
		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("SDF 4578");
		bus.setCapacidad(new BigDecimal(1000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setTipo("T");

		try {
			buses_logica.save(bus);
			fail("se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void marcaNullTest() throws LogicException {
		assertNotNull(buses_logica);
		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("SDF578");
		bus.setCapacidad(new BigDecimal(1000));
		bus.setModelo(new BigDecimal(2015));
		bus.setTipo("T");

		try {
			buses_logica.save(bus);
			fail("se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void testTipoDiferente() throws LogicException {
		assertNotNull(buses_logica);
		Tmio1Bus bus1 = new Tmio1Bus();
		bus1.setCapacidad(new BigDecimal(1000));
		bus1.setMarca("Volvo");
		bus1.setModelo(new BigDecimal(2015));
		bus1.setPlaca("KGZ 311");
		bus1.setTipo("W");

		try {
			buses_logica.save(bus1);
			fail("se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void CapacidadNullTest() throws LogicException {
		assertNotNull(buses_logica);
		Tmio1Bus bus1 = new Tmio1Bus();
		bus1.setMarca("Volvo");
		bus1.setModelo(new BigDecimal(2015));
		bus1.setPlaca("KGZ 311");
		bus1.setTipo("P");

		try {
			buses_logica.save(bus1);
			fail("se agrego");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

}
