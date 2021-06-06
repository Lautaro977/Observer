package modelo;

import java.util.List;

public class Medidor extends Observable {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima, List<Observer> listaObservadores) {
		this.clima = clima;
		for (Observer observador : listaObservadores) {
			this.agregarObservadores(observador);
		}
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		this.notificar(this.temperatura);
		return this.temperatura;
	}
}
