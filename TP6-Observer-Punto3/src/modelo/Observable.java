package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<Observer> ListaObservadores;

	public Observable() {
		this.ListaObservadores = new ArrayList<>();
	}

	public void agregarObservadores(Observer observador) {
		this.ListaObservadores.add(observador);
	}

	protected void notificar(Venta venta) {
		for (Observer ob : ListaObservadores) {
			ob.actualizar(venta);
		}
	}
}
