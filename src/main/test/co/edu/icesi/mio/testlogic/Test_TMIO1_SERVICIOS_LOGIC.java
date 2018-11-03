package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.logic.ITMIO1_BUSES_LOGIC;
import co.edu.icesi.mio.logic.ITMIO1_CONDUCTORES_LOGIC;
import co.edu.icesi.mio.logic.ITMIO1_RUTAS_LOGIC;
import co.edu.icesi.mio.logic.ITMIO1_SERVICIOS_LOGIC;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_TMIO1_SERVICIOS_LOGIC {

	@Autowired
	private ITMIO1_SERVICIOS_LOGIC servicios_logic;

	@Autowired
	private ITMIO1_CONDUCTORES_LOGIC conductores_logic;

	@Autowired
	private ITMIO1_BUSES_LOGIC buses_logic;

	@Autowired
	private ITMIO1_RUTAS_LOGIC rutas_logic;

	@Test
	public void acorrectSave() throws LogicException {
		assertNotNull(servicios_logic);
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = new Tmio1Conductore();
		tmioConductor.setCedula("12345"+System.currentTimeMillis());
		tmioConductor.setNombre("Jack");
		tmioConductor.setApellidos("Bauer");
		Calendar d1 = new GregorianCalendar(1998, 01, 20);
		tmioConductor.setFechaNacimiento(d1.getTime());
		Calendar d = new GregorianCalendar(2018, 01, 20);
		tmioConductor.setFechaContratacion(d.getTime());
		conductores_logic.save(tmioConductor);

		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("hhr465");
		BigDecimal modelo = new BigDecimal(2018);
		bus.setModelo(modelo);
		bus.setTipo("P");
		BigDecimal capacidad = new BigDecimal(384);
		bus.setCapacidad(capacidad);
		bus.setMarca("Audi");
		buses_logic.save(bus);

		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setNumero("123");
		ruta.setActiva("N");
		ruta.setDescripcion("Ruta 1");
		BigDecimal diaInicio = new BigDecimal(6);
		ruta.setDiaInicio(diaInicio);
		BigDecimal diaFin = new BigDecimal(7);
		ruta.setDiaFin(diaFin);
		BigDecimal horaInicio = new BigDecimal(500);
		ruta.setHoraInicio(horaInicio);
		BigDecimal horaFin = new BigDecimal(1400);
		ruta.setHoraFin(horaFin);
		rutas_logic.save(ruta);

		// ------------------------------------------------------------------
		// Test save
		Tmio1ServicioPK servicioPk = new Tmio1ServicioPK();
		servicioPk.setIdRuta(ruta.getId());
		servicioPk.setCedulaConductor(tmioConductor.getCedula());
		servicioPk.setIdBus(bus.getId());
		Date fechaInicio = new Date("1/1/2018");
		Date fechaFin = new Date("12/5/2018");
		servicioPk.setFechaInicio(fechaInicio);
		servicioPk.setFechaFin(fechaFin);

		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setId(servicioPk);
		servicio.setTmio1Bus(bus);
		servicio.setTmio1Conductore(tmioConductor);
		servicio.setTmio1Ruta(ruta);

		servicios_logic.save(servicio);

		servicios_logic.delete(servicio);
		buses_logic.delete(bus);
		rutas_logic.delete(ruta);
		conductores_logic.delete(tmioConductor);
	}

	@Test
	public void servicioNullSave() {
		assertNotNull(servicios_logic);
		try {
			servicios_logic.save(null);
			fail("guardado");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void fechaInicioMayorFinSave() throws LogicException {
		assertNotNull(servicios_logic);
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

		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("hhr465");
		BigDecimal modelo = new BigDecimal(2018);
		bus.setModelo(modelo);
		bus.setTipo("P");
		BigDecimal capacidad = new BigDecimal(384);
		bus.setCapacidad(capacidad);
		bus.setMarca("Audi");
		buses_logic.save(bus);

		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setNumero("123");
		ruta.setActiva("N");
		ruta.setDescripcion("Ruta 1");
		BigDecimal diaInicio = new BigDecimal(6);
		ruta.setDiaInicio(diaInicio);
		BigDecimal diaFin = new BigDecimal(7);
		ruta.setDiaFin(diaFin);
		BigDecimal horaInicio = new BigDecimal(500);
		ruta.setHoraInicio(horaInicio);
		BigDecimal horaFin = new BigDecimal(1400);
		ruta.setHoraFin(horaFin);
		rutas_logic.save(ruta);

		// ------------------------------------------------------------------
		// Test save
		Tmio1ServicioPK servicioPk = new Tmio1ServicioPK();
		servicioPk.setIdRuta(ruta.getId());
		servicioPk.setCedulaConductor(tmioConductor.getCedula());
		servicioPk.setIdBus(bus.getId());
		Date fechaInicio = new Date("1/1/2019");
		Date fechaFin = new Date("12/5/2018");
		servicioPk.setFechaInicio(fechaInicio);
		servicioPk.setFechaFin(fechaFin);

		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setId(servicioPk);
		servicio.setTmio1Bus(bus);
		servicio.setTmio1Conductore(tmioConductor);
		servicio.setTmio1Ruta(ruta);

		try {
			servicios_logic.save(servicio);
			servicios_logic.delete(servicio);
			fail("guardado");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}

		buses_logic.delete(bus);
		rutas_logic.delete(ruta);
		conductores_logic.delete(tmioConductor);
	}

	@Test
	public void conductorNullSave() throws LogicException {
		assertNotNull(servicios_logic);
		assertNotNull(conductores_logic);
		Tmio1Conductore tmioConductor = null;
//		tmioConductor.setCedula("12345");
//		tmioConductor.setNombre("Jack");
//		tmioConductor.setApellidos("Bauer");
//		Calendar d1 = new GregorianCalendar(1998, 01, 20);
//		tmioConductor.setFechaNacimiento(d1.getTime());
//		Calendar d = new GregorianCalendar(2018, 01, 20);
//		tmioConductor.setFechaContratacion(d.getTime());
//		conductores_logic.save(tmioConductor);

		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("hhr465");
		BigDecimal modelo = new BigDecimal(2018);
		bus.setModelo(modelo);
		bus.setTipo("P");
		BigDecimal capacidad = new BigDecimal(384);
		bus.setCapacidad(capacidad);
		bus.setMarca("Audi");
		buses_logic.save(bus);

		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setNumero("123");
		ruta.setActiva("N");
		ruta.setDescripcion("Ruta 1");
		BigDecimal diaInicio = new BigDecimal(6);
		ruta.setDiaInicio(diaInicio);
		BigDecimal diaFin = new BigDecimal(7);
		ruta.setDiaFin(diaFin);
		BigDecimal horaInicio = new BigDecimal(500);
		ruta.setHoraInicio(horaInicio);
		BigDecimal horaFin = new BigDecimal(1400);
		ruta.setHoraFin(horaFin);
	

		// ------------------------------------------------------------------
		// Test save
		Tmio1ServicioPK servicioPk = new Tmio1ServicioPK();
		servicioPk.setIdRuta(ruta.getId());
//		servicioPk.setCedulaConductor(tmioConductor.getCedula());
		servicioPk.setIdBus(bus.getId());
		Date fechaInicio = new Date("1/1/2019");
		Date fechaFin = new Date("12/5/2018");
		servicioPk.setFechaInicio(fechaInicio);
		servicioPk.setFechaFin(fechaFin);

		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setId(servicioPk);
		servicio.setTmio1Bus(bus);
		servicio.setTmio1Conductore(tmioConductor);
		servicio.setTmio1Ruta(ruta);

		try {
			servicios_logic.save(servicio);
			servicios_logic.delete(servicio);
			fail("guardado");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}

		buses_logic.delete(bus);
		rutas_logic.delete(ruta);
//		conductores_logic.delete(tmioConductor);
	}
	
	
}
