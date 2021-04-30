package excepciones;

public class NingunTrabajadorDisponibleException extends Exception {
	public NingunTrabajadorDisponibleException(){
		super("No hay ningun trabajador disponible para este día");
	}
}
