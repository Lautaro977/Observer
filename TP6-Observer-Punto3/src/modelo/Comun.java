package modelo;

import java.time.LocalDateTime;

public class Comun extends Combustible {

	public Comun(float precioPorLitro) throws ValidarException {
		super(precioPorLitro);
	}

	public float calcularMonto(int litrosDeCombustible) {

		return this.precioPorLitro() * litrosDeCombustible;

	}

	public float realizarDescuento(float precioCombustible, LocalDateTime dia) {
		float combustible = precioCombustible;

		if (entreDosHoras(dia.getHour())) {
			combustible -= combustible * 5 / 100;
		}

		return combustible;

	}

	public boolean entreDosHoras(int hora) {
		if (hora >= 8 && hora <= 10)
			return true;

		return false;
	}
}
