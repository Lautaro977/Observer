package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import modelo.EnvioEmail;
import modelo.EstacionDeServicio;
import modelo.Observer;
import modelo.Venta;
import persistencia.RegistraDeVentaEnMemoria;
import servicio_email.Email;

class Test {

	@org.junit.jupiter.api.Test
	void testCombustibleSuperDiaSabadoLitros20() throws Exception {
		float resultadoEsperado = 1584.0f;

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		LocalDateTime fecha = LocalDateTime.of(2021, 06, 5, 22, 30);

		assertEquals(resultadoEsperado, estacion.realizarMontoTotal("Super", 20, fecha), 0.1);

	}

	@org.junit.jupiter.api.Test
	void testCombustibleSuperDiaDomingoLitros10() throws Exception {
		float resultadoEsperado = 810.0f;

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		LocalDateTime fecha = LocalDateTime.of(2021, 06, 6, 22, 30);

		assertEquals(resultadoEsperado, estacion.realizarMontoTotal("Super", 10, fecha), 0.1);

	}

	@org.junit.jupiter.api.Test
	void testCombustibleSuperSinDescuento() throws Exception {
		float resultadoEsperado = 900.0f;

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		LocalDateTime fecha = LocalDateTime.of(2021, 06, 3, 22, 30);

		assertEquals(resultadoEsperado, estacion.realizarMontoTotal("Super", 10, fecha), 0.1);

	}

	@org.junit.jupiter.api.Test
	void testCombustibleComunDescuentoTempranoTodosLosDias() throws Exception {
		float resultadoEsperado = 665.0f;

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		LocalDateTime fecha = LocalDateTime.of(2021, 06, 6, 9, 00);

		assertEquals(resultadoEsperado, estacion.realizarMontoTotal("Comun", 10, fecha), 0.1);

	}

	@org.junit.jupiter.api.Test
	void testCombustibleComunSinDescuento() throws Exception {
		float resultadoEsperado = 700.0f;

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		LocalDateTime fecha = LocalDateTime.of(2021, 06, 6, 12, 00);

		assertEquals(resultadoEsperado, estacion.realizarMontoTotal("Comun", 10, fecha), 0.1);

	}

	@org.junit.jupiter.api.Test
	void testObtenerListaVentasEntreDosFechas() throws Exception {
		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		estacion.realizarVenta("Comun", 2, "simp");
		estacion.realizarVenta("Super", 3, "pepe");

		List<Venta> ListaVentas = new ArrayList<Venta>();

		ListaVentas = estacion.recuperarVentasEntreDosFechas(LocalDateTime.of(2021, 05, 5, 0, 0),
				LocalDateTime.of(2021, 12, 31, 23, 59));

		assertFalse(ListaVentas.isEmpty());

	}

	@org.junit.jupiter.api.Test
	void testExisteVenta() throws Exception {

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistraDeVentaEnMemoria(), ListaObservadores);

		estacion.realizarVenta("Super", 2, "chopchop");

		List<Venta> ListaVentas = estacion.obtenerVentas();

		assertTrue(estacion.existeVenta(ListaVentas.get(ListaVentas.size() - 1)));

	}

}
