package modelo;

import java.time.LocalDateTime;

public abstract class Combustible {

	private PrecioPorLitro precioPorLitro;

	public Combustible(float precioPorLitro) throws ValidarException {
		this.precioPorLitro = new PrecioPorLitro(precioPorLitro);
	}

	public float precioPorLitro() {
		return precioPorLitro.obtenerPrecioPorLitro();
	}

	public abstract float calcularMonto(int litrosDeCombustible);

	public abstract float realizarDescuento(float precioCombustible, LocalDateTime dia);

}
