package excepciones;
import reparaFix.Oficio;

public class OficioNoCoincideException extends Exception {
	public OficioNoCoincideException(Oficio t, Oficio laburo) {
		/**
		 * @param	t= oficio trabajador
		 * 			laburo= oficio trabajo.
		 */
		super("El oficio del trabajador es " + t.toString() + "\n"+
				"El oficio del trabajo es "+laburo.toString());
		
	}
}
