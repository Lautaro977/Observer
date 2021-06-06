package modelo;

public class EmailVenta {
	private String email;

	public EmailVenta(String email) throws ValidarException {
		if (email.equals("")) {
			throw new ValidarException("El Email No puede estar vacio");
		}
		this.email =email;
	}

	public String obtenerEmailVenta() {
		return this.email;
	}
}
