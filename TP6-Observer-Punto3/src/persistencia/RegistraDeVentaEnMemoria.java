package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.RegistrarVentas;
import modelo.Venta;

public class RegistraDeVentaEnMemoria implements RegistrarVentas {
	private List<Venta> ListaVentas = new ArrayList<>();

	public void guardarVentas(Venta venta) {
		ListaVentas.add(venta);
	}

	@Override
	public List<Venta> obtenerVentas() throws Exception {
		// TODO Auto-generated method stub
		return this.ListaVentas;
	}

}
