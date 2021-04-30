package excepciones;


public class UsuarioYaExistenteException extends Exception {
	public UsuarioYaExistenteException() {
		super("El usuario o el correo ya existe en el sistema.");
	}
}
