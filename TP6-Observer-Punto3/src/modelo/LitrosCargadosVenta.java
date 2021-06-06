package modelo;

public class LitrosCargadosVenta {
	private String litros;

	public LitrosCargadosVenta(String litros) throws ValidarException {
		if (litros.equals("")) {
			throw new ValidarException("Los Litros No puede estar vacia");
		}
		this.litros = litros;
	}

	public String obtenerLitrosVenta() {
		return this.litros;
	}
}
