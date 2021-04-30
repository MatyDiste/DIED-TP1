package excepciones;

public class NingunaMaquinaDisponibleException extends Exception {
	public NingunaMaquinaDisponibleException() {
		super("No hay ninguna maquina disponible de este tipo");
	}
}
