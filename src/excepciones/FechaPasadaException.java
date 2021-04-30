package excepciones;
import java.util.Calendar;

public class FechaPasadaException extends Exception {
	public FechaPasadaException(Calendar f) {
		super("La fecha "+
				f.get(Calendar.DAY_OF_MONTH)+"/"+
				f.get(Calendar.MONTH)+1+"/"+
				f.get(Calendar.YEAR)+
				" es una fecha inválida (la fecha actual "+
				Calendar.DAY_OF_MONTH+"/"+
				Calendar.MONTH+1+"/"+
				Calendar.YEAR+
				" es mayor a la ingresada)");
	}
}
