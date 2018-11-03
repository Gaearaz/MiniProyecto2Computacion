package co.edu.icesi.mio.testdao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Servicio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_Tmio1_Servicios_DAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ITmio1_Servicios_DAO servicioDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByRangeOfDates() {
		Calendar d = new GregorianCalendar(2018, 1, 15);
		Calendar d2 = new GregorianCalendar(2018, 11, 28);
		// List<Tmio1Servicio> servicios = servicioDAO.findByRangeOfDates(d, d2);
//		assertNotNull("No existen servicios en este rango de dias", servicios);
//		// da 4 por los 2 agregados en conductor
//		assertEquals(4, servicios.size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testServicesSaturdaysAndSundaysOrJustSundays() {
		List<Tmio1Servicio> servicios = servicioDAO.servicesSaturdaysAndSundaysOrJustSundays();
		assertNotNull("No existen servicios en dichos dias", servicios);
		assertEquals(2, servicios.size());
	}
}
