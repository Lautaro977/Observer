package modelo;

public class EnvioEmail implements Observer {
	private Servicio servicio;

	public EnvioEmail(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public void actualizar(Venta venta) {
		// TODO Auto-generated method stub
		servicio.enviar(venta);
	}

}
