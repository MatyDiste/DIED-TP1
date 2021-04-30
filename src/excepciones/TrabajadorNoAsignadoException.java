package excepciones;

public class TrabajadorNoAsignadoException extends Exception {
	
	public TrabajadorNoAsignadoException() {
		super("No se ha asignado trabajador para el trabajo");
	}

}
