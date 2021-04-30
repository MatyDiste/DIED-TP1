package excepciones;

public class AlquilerNoEntregadoException extends Exception {
	public AlquilerNoEntregadoException() {
		super("El usuario tiene 2 o más alquileres sin devolver");
	}
}
