package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import modelo.RegistrarVentas;
import modelo.Venta;

public class RegistroEnArchivoVentas implements RegistrarVentas {

	private String ubicacion;

	public RegistroEnArchivoVentas(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public void guardarVentas(Venta venta) {

		String Stringventa = venta.obtenerfecha() + "," + venta.obtenerLitrosCargados() + ","
				+ venta.obtenerMontoFactura() + "," + venta.obtenerEmail() + "\n";
		try {
			Files.write(Paths.get(this.ubicacion), Stringventa.getBytes(), StandardOpenOption.APPEND);

		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}

	@Override
	public List<Venta> obtenerVentas() throws Exception {
		// TODO Auto-generated method stub
		List<Venta> ListaVenta = new ArrayList<>();

		try {

			List<String> contenido = Files.readAllLines(Paths.get(this.ubicacion));

			for (String ven : contenido) {

				String[] contenidoSplit = ven.split(",");
				String fechaSplit = contenidoSplit[0];

				try {
					Venta venta = new Venta(contenidoSplit[0], contenidoSplit[1], contenidoSplit[2], contenidoSplit[3]);
					ListaVenta.add(venta);
				} catch (Exception ex) {
					throw new Exception("No se pudo crear la venta");
				}
			}
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("No se pudo Abrir...", ex);
		} catch (IOException ex) {
			throw new RuntimeException("No se pudo Abrir...", ex);
		}

		return ListaVenta;
	}

}
