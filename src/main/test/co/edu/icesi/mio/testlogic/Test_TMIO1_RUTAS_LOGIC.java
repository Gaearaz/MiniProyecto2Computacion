package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.LogicException;
import co.edu.icesi.mio.logic.ITMIO1_RUTAS_LOGIC;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;
import co.edu.icesi.mio.model.Tmio1SitiosRuta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_TMIO1_RUTAS_LOGIC {

	@Autowired
	private ITMIO1_RUTAS_LOGIC rutas_logic;

	@Test
	public void numeroTengaTresCaracteres() throws LogicException {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		rutas_logic.save(ruta);

	}

	@Test
	public void numeroTengaMenosDeTresCaracteres() {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P4");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta);
			fail("guardado");
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void diaInicioDiaFinNumericos() {
		Tmio1Ruta ruta1 = new Tmio1Ruta();
		ruta1.setActiva("S");
		ruta1.setDescripcion("ruta A a B");
		ruta1.setDiaInicio(new BigDecimal(7));
		ruta1.setDiaFin(new BigDecimal(7));
		ruta1.setHoraInicio(new BigDecimal(4));
		ruta1.setHoraFin(new BigDecimal(17));
		ruta1.setNumero("P37");
		ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta1);
			assertTrue(rutas_logic != null);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void diaInicioDiaFinNumericosEntreUnoySiete() {
		Tmio1Ruta ruta1 = new Tmio1Ruta();
		ruta1.setActiva("S");
		ruta1.setDescripcion("ruta A a B");
		ruta1.setDiaInicio(new BigDecimal(1));
		ruta1.setDiaFin(new BigDecimal(7));
		ruta1.setHoraInicio(new BigDecimal(4));
		ruta1.setHoraFin(new BigDecimal(17));
		ruta1.setNumero("P37");
		ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta1);
			assertTrue(rutas_logic.findByRangeOfDays(new BigDecimal("1"), new BigDecimal("7")) != null);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inicioMenorOIgualAFin() {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P27");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta);
			assertTrue(rutas_logic.findByRangeOfDays(new BigDecimal("6"), new BigDecimal("7")) != null);
			rutas_logic.delete(ruta);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inicioMayorAFin() {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(7));
		ruta.setDiaFin(new BigDecimal(2));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P27");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta);
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void horaInicioYFinAgregadoCorrecto() {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P27");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta);
			assertTrue(rutas_logic != null);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void horaInicioYFinFueradeRangos() {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(-20));
		ruta.setHoraFin(new BigDecimal(2350000));
		ruta.setNumero("P27");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta);
		} catch (LogicException e) {
			e.printStackTrace();
			assertEquals("error", e.getMessage());
		}
	}

	@Test
	public void activaSoNCorrecta() throws LogicException {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("T47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		rutas_logic.save(ruta);

	}

	@Test
	public void activaSoNIncorrecta() {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("Z");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("T47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		try {
			rutas_logic.save(ruta);
		} catch (LogicException e) {
			assertEquals("error", e.getMessage());
		}
	}

}
