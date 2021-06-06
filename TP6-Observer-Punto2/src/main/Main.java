package main;

import java.util.ArrayList;
import java.util.List;

import Persistencia.RegistrarEnArchivo;
import modelo.ClimaOnline;
import modelo.ImprimirPorConsola;
import modelo.Medidor;
import modelo.MedidorConNotificacion;
import modelo.Observer;
import modelo.servicioDeCanalMeteorologico;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClimaOnline clima = new servicioDeCanalMeteorologico();
		List<Observer> listaObserver = new ArrayList<Observer>();

		listaObserver.add(new RegistrarEnArchivo(
				"C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Archivo-tp6-Observer-Punto2.txt"));

		listaObserver.add(new ImprimirPorConsola());

		Medidor medidor = new Medidor(clima);

		MedidorConNotificacion medidorNotificacion = new MedidorConNotificacion(medidor, listaObserver);
		medidorNotificacion.leerTemperatura();

		ClimaOnline climaSinNotificacion = new servicioDeCanalMeteorologico();

		Medidor medidorSinNotificacion = new Medidor(climaSinNotificacion);

		System.out.println("Temperatura:" + medidorSinNotificacion.leerTemperatura());
	}

}
