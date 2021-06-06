package main;

import java.util.ArrayList;
import java.util.List;

import modelo.EnvioEmail;
import modelo.EstacionDeServicio;
import modelo.Observer;
import persistencia.RegistroEnArchivoVentas;
import servicio_email.Email;
import ui.MenuPrincipal;

public class MainDisco {
	public static void main(String[] args) {

		List<Observer> ListaObservadores = new ArrayList<>();

		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(
				new RegistroEnArchivoVentas(
						"C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Archivo-tp6-Observer-Punto3.txt"),
				ListaObservadores);

		MenuPrincipal mp = new MenuPrincipal(estacion);
		mp.setVisible(true);

	}
}
