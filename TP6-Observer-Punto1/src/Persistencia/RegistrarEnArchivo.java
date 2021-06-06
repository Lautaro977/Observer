package Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import modelo.Observer;

public class RegistrarEnArchivo implements Observer {

	private String ubicacion;

	public RegistrarEnArchivo(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public void actualizar(String texto) {
		// TODO Auto-generated method stub
		LocalDateTime fechaHoy = LocalDateTime.now();
		String fechaHoyConTemperatura = fechaHoy.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + texto + "\n";
		try {
			FileWriter file = new FileWriter(new File(this.ubicacion), true);
			file.write(fechaHoyConTemperatura);
			file.close();

		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}

}
