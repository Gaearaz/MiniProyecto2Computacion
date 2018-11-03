package co.edu.icesi.mio.testdao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;
import co.edu.icesi.mio.model.Tmio1SitiosRuta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test_Tmio1_Rutas_DAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ITmio1_Rutas_DAO rutasDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {

		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("A");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

		rutasDAO.save(ruta);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {

		Tmio1Ruta ruta = rutasDAO.findById(-46);
		assertNotNull("Code not found", ruta);
		ruta.setDiaFin(new BigDecimal(5));
		rutasDAO.update(ruta);
	}

	private void setUpEscenario1() {

		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("A");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(7));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P27");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

		rutasDAO.save(ruta);

		Tmio1Ruta ruta1 = new Tmio1Ruta();
		ruta1.setActiva("A");
		ruta1.setDescripcion("ruta A a B");
		ruta1.setDiaInicio(new BigDecimal(7));
		ruta1.setDiaFin(new BigDecimal(7));
		ruta1.setHoraInicio(new BigDecimal(4));
		ruta1.setHoraFin(new BigDecimal(17));
		ruta1.setNumero("P37");
		ruta1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta1.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

		rutasDAO.save(ruta1);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByRangeOfDays() {
		setUpEscenario1();
		List<Tmio1Ruta> rutas = rutasDAO.findByRangeOfDays(new BigDecimal(1), new BigDecimal(7));
		assertNotNull("No existen rutas en este rango de dias", rutas);
		assertEquals(6, rutas.size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {
		Tmio1Ruta ruta = rutasDAO.findById(-42);
		assertNotNull("La ruta NO existe", ruta);
		rutasDAO.delete(ruta);

	}
}
