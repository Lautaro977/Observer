package modelo;

public class PrecioPorLitro {

	private float precioPorLitro;

	public PrecioPorLitro(float precioPorLitro) throws ValidarException {
		if (precioPorLitro <= 0) {
			throw new ValidarException("El precio No puede ser menor o igual a cero");
		}
		this.precioPorLitro = precioPorLitro;
	}

	public float obtenerPrecioPorLitro() {
		return this.precioPorLitro;
	}

}
