package modelo;

import java.util.List;

public class MedidorConNotificacion extends Observable implements AbstractDecorador {

	private String temperatura;
	private Medidor medidor;

	public MedidorConNotificacion(Medidor medidor, List<Observer> observadores) {
		this.medidor = medidor;

		for (Observer observador : observadores) {
			this.agregarObservadores(observador);
		}

	}

	@Override
	public String leerTemperatura() {
		// TODO Auto-generated method stub
		this.temperatura = this.medidor.leerTemperatura();
		this.notificar(this.temperatura);
		return temperatura;

	}

}
