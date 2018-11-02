package co.edu.icesi.mio.testlogic;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.logic.BusesLogic;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class Test_TMIO1_BUSES_LOGIC {

	@Autowired
	private BusesLogic buses_logica;

	@Test
	public void testAgregadoCorrecto(){
		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("SDF457");
		bus.setCapacidad(new BigDecimal(1000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		buses_logica.save(bus);
	}

	@Test
	public void testPlacaMayor6Elementos(){
		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("SDF 4578");
		bus.setCapacidad(new BigDecimal(1000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		buses_logica.save(bus);
	}

	@Test
	public void testMarcaNull(){
		Tmio1Bus bus = new Tmio1Bus();
		bus.setPlaca("SDF578");
		bus.setCapacidad(new BigDecimal(1000));
		bus.setModelo(new BigDecimal(2015));
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		buses_logica.save(bus);
	}

	@Test
	public void testTipoDiferente(){
		Tmio1Bus bus1 = new Tmio1Bus();
		bus1.setCapacidad(new BigDecimal(1000));
		bus1.setMarca("Volvo");
		bus1.setModelo(new BigDecimal(2015));
		bus1.setPlaca("KGZ 311");
		bus1.setTipo("W");
		bus1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		buses_logica.save(bus1);
	}

	@Test
	public void testCapacidadNull(){
		Tmio1Bus bus1 = new Tmio1Bus();
		bus1.setMarca("Volvo");
		bus1.setModelo(new BigDecimal(2015));
		bus1.setPlaca("KGZ 311");
		bus1.setTipo("W");
		bus1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());

		buses_logica.save(bus1);
	}

}
