package modelo;

public class FechaVenta {

	private String fecha;

	public FechaVenta(String fecha) throws ValidarException {
		if (fecha.equals("")) {
			throw new ValidarException("La fecha No puede estar vacia");
		}
		this.fecha = fecha;
	}

	public String obtenerFechaVenta() {
		return this.fecha;
	}
}
