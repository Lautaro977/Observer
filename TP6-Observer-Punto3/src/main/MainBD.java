package main;

import java.util.ArrayList;
import java.util.List;

import modelo.EnvioEmail;
import modelo.EstacionDeServicio;
import modelo.Observer;
import persistencia.RegistrarEnBD;
import servicio_email.Email;
import ui.Conexion;
import ui.MenuPrincipal;

public class MainBD {
	public static void main(String[] args) {

		List<Observer> ListaObservadores = new ArrayList<>();
		ListaObservadores.add(new EnvioEmail(new Email()));

		EstacionDeServicio estacion = new EstacionDeServicio(new RegistrarEnBD(new Conexion()), ListaObservadores);

		MenuPrincipal mp = new MenuPrincipal(estacion);
		mp.setVisible(true);

	}
}
