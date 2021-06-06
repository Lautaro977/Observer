package modelo;

public class MontoFacturadoVenta {
	private String monto;

	public MontoFacturadoVenta(String monto) throws ValidarException {
		if (monto.equals("")) {
			throw new ValidarException("El Monto No puede ser vacio");
		}
		this.monto = monto;
	}

	public String obtenerMontoVenta() {
		return this.monto;
	}
}
