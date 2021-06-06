package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstacionDeServicio extends Observable {

	private RegistrarVentas rv;

	public EstacionDeServicio(RegistrarVentas rv, List<Observer> observadores) {
		this.rv = rv;

		for (Observer observador : observadores) {
			this.agregarObservadores(observador);
		}

	}

	public void realizarVenta(String tipoCombustible, int litrosCargados, String email)
			throws ValidarException, Exception {

		Venta venta = new Venta(LocalDate.now().toString(), Integer.toString(litrosCargados),
				String.valueOf(this.realizarMontoTotal(tipoCombustible, litrosCargados, LocalDateTime.now())), email);
		rv.guardarVentas(venta);
		this.notificar(venta);

	}

	public List<Venta> recuperarVentasEntreDosFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception {

		List<Venta> ListaTodasLasVentas = new ArrayList<Venta>();
		List<Venta> ListaVentas = new ArrayList<Venta>();

		ListaTodasLasVentas = rv.obtenerVentas();

		for (Venta venta : ListaTodasLasVentas) {
			String fechaSplit = venta.obtenerfecha();
			String[] splitFecha = fechaSplit.split("-");
			LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(splitFecha[0]), Integer.parseInt(splitFecha[1]),
					Integer.parseInt(splitFecha[2]), 13, 0);

			if (fecha.isAfter(inicio) && fecha.isBefore(fin)) {
				ListaVentas.add(venta);
			}

		}

		return ListaVentas;

	}

	public float realizarMontoTotal(String tipo, int litros, LocalDateTime fecha) throws ValidarException {
		Combustible combustible = this.tipoCombustible(tipo);
		float precioCombustible = combustible.calcularMonto(litros);
		return combustible.realizarDescuento(precioCombustible, fecha);
	}

	public Combustible tipoCombustible(String tipo) throws ValidarException {

		Combustible combustible = null;

		if (tipo.contentEquals("Super"))
			combustible = new Super(90);
		else {
			combustible = new Comun(70);
		}

		return combustible;
	}

	public List<Venta> obtenerVentas() throws Exception {
		List<Venta> ListaVentas = new ArrayList<Venta>();
		ListaVentas = rv.obtenerVentas();
		return ListaVentas;
	}

	public boolean existeVenta(Venta venta) throws Exception {

		List<Venta> ListaVentas = new ArrayList<Venta>();
		ListaVentas = rv.obtenerVentas();

		return ListaVentas.contains(venta);

	}

}
