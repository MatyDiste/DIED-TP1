package excepciones;

public class AlquilerNoEntregadoException extends Exception {
	public AlquilerNoEntregadoException() {
		super("El usuario tiene 2 o m�s alquileres sin devolver");
	}
}
