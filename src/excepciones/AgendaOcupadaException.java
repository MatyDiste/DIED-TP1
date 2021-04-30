package excepciones;
import java.util.Calendar;

public class AgendaOcupadaException extends Exception {
	public AgendaOcupadaException(Calendar dia) {
		super("El d�a "+
				dia.get(Calendar.DAY_OF_MONTH)+"/"+
				dia.get(Calendar.MONTH)+1 +"/"+
				dia.get(Calendar.YEAR)+
				" ya est� agendado para el trabajador. No se puede agendar otro trabajo");
	}
}
