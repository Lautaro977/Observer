package modelo;

import java.time.LocalDateTime;

public class Super extends Combustible {

	public Super(float precioPorLitro) throws ValidarException {
		super(precioPorLitro);
	}

	public float calcularMonto(int litrosDeCombustible) {

		return this.precioPorLitro() * litrosDeCombustible;

	}

	public float realizarDescuento(float precioCombustible, LocalDateTime dia) {
		float combustibleSuper = precioCombustible;

		float precioPorLitro = this.precioPorLitro();
		if ((precioCombustible >= precioPorLitro * 20) && (dia.getDayOfWeek().toString().contentEquals("SATURDAY"))) {
			combustibleSuper -= combustibleSuper * 12 / 100;
		}
		if (dia.getDayOfWeek().toString().contentEquals("SUNDAY")) {
			combustibleSuper -= combustibleSuper * 10 / 100;
		}

		return combustibleSuper;

	}

}
