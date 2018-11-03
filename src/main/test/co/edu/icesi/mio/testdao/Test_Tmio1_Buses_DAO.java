package co.edu.icesi.mio.testdao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_Tmio1_Buses_DAO {

	@Autowired
	private ITmio1_Buses_DAO busDAO;

	/**
	 * Test del método save donde se guardan 4 buses 
	 * previamente creados con sus atributos completos
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() {

		Tmio1Bus bus = new Tmio1Bus();

		bus.setCapacidad(new BigDecimal(1000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setPlaca("KGZ 310");
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		busDAO.save(bus);

		Tmio1Bus bus1 = new Tmio1Bus();

		bus1.setCapacidad(new BigDecimal(1000));
		bus1.setMarca("Volvo");
		bus1.setModelo(new BigDecimal(2015));
		bus1.setPlaca("KGZ 311");
		bus1.setTipo("P");
		bus1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		busDAO.save(bus1);

		Tmio1Bus bus2 = new Tmio1Bus();

		bus2.setCapacidad(new BigDecimal(1700));
		bus2.setMarca("Mercedes Benz");
		bus2.setModelo(new BigDecimal(2017));
		bus2.setPlaca("KGZ 320");
		bus2.setTipo("A");
		bus2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		busDAO.save(bus2);

		Tmio1Bus bus3 = new Tmio1Bus();

		bus3.setCapacidad(new BigDecimal(1050));
		bus3.setMarca("Volvo");
		bus3.setModelo(new BigDecimal(2016));
		bus3.setPlaca("KGZ 325");
		bus3.setTipo("A");
		bus3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());

		busDAO.save(bus3);
	}

	/**
	 * Test del método save donde se valida que el bus que se actualizará 
	 * se encuentre en la base de datos y luego se le actualiza uno de sus atributos(capacidad)
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {

		Tmio1Bus bus = busDAO.findById(-23);
		assertNotNull("Code not found", bus);
		bus.setCapacidad(new BigDecimal(1500));
		busDAO.update(bus);
	}

	/**
	 * Test del método findByModel en el cual se prueba la validación de la búsqueda de un bus por su modelo
	 * que es un atributo Bigdecimal, y luego se verifica si  el valor del size de los resultados es el esperado
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByModel() {

		List<Tmio1Bus> bus = busDAO.findByModel(new BigDecimal(2015));
		assertNotNull("No se encontro el bus por ese modelo", bus);
		assertEquals(2, bus.size());
	}

	/**
	 * Test del método findByType en el cual se prueba la validación de la búsqueda de un bus por su tipo
	 * qye es un String de tamaño 1, y luego se verifica (en caso de ser encontrado) que el tamaño del size
	 * de la lista de los resultados es el esperado. 
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByType() {

		List<Tmio1Bus> bus = busDAO.findByType("T");
		assertNotNull("No se encontro el bus por ese tipo", bus);
		assertEquals(1, bus.size());
	}

	/**
	 * Test del método findByCapacity en el cual se prueba la validación de la búsqueda en un bus por su
	 * capacidad, que es un BigDecimal, luego se verifica (en caso de ser encontrado) que el tamaño del size
	 * de la lista de los resultados sea el esperado.
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByCapacity() {

		List<Tmio1Bus> bus = busDAO.findByCapacity(new BigDecimal(1500));

		assertNotNull("No se encontro el bus por esa capacidad", bus);
		assertEquals(1, bus.size());
	}

	/**
	 * Test del método Delete en el que se hace la búsqueda de un bus por medio de su Id y, luego de encontrado,
	 * se procede a la realización del borrado del bus de la base de datos. 
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {

		Tmio1Bus bus = busDAO.findById(-21);
		assertNotNull("El bus NO existe", bus);
		busDAO.delete(bus);
	}
}
