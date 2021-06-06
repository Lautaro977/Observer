package modelo;

public class Venta {

	private FechaVenta fechaVenta;
	private LitrosCargadosVenta litrosCargados;
	private MontoFacturadoVenta montoFacturado;
	private EmailVenta email;

	public Venta(String fechaVenta, String litrosCargados, String montoFacturado, String email)
			throws ValidarException {
		this.fechaVenta = new FechaVenta(fechaVenta);
		this.litrosCargados = new LitrosCargadosVenta(litrosCargados);
		this.montoFacturado = new MontoFacturadoVenta(montoFacturado);
		this.email = new EmailVenta(email);
	}

	public String obtenerfecha() {
		return this.fechaVenta.obtenerFechaVenta();
	}

	public String obtenerLitrosCargados() {
		return this.litrosCargados.obtenerLitrosVenta();
	}

	public String obtenerMontoFactura() {
		return this.montoFacturado.obtenerMontoVenta();
	}

	public String obtenerEmail() {
		return this.email.obtenerEmailVenta();
	}

}
