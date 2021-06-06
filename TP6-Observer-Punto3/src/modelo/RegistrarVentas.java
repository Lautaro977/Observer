package modelo;

import java.util.List;

public interface RegistrarVentas {

	void guardarVentas(Venta venta) throws Exception;

	List<Venta> obtenerVentas() throws Exception;

}
