package modelo;

public class ImprimarPorConsola implements Observer {

	@Override
	public void actualizar(String texto) {
		// TODO Auto-generated method stub
		// FIJIRSE SI ESTO ESTA BIEN HECHO
		String[] numero = texto.split(" ");

		int grados = Integer.parseInt(numero[0]);

		System.out.println(grados);

		if (grados < 12) {
			System.out.println("Hace frio, se encenderá la caldera");
		} else {
			System.out.println("Hace calor, se encenderá el aire acondicionado");
		}

	}

}
