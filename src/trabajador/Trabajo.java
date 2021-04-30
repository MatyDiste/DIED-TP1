package trabajador;
import servicio.Servicio;
import reparaFix.Oficio;
import java.util.Calendar;
import java.util.Optional;

public class Trabajo {
	
	private Servicio servicio;
	private Optional<Trabajador> trabajador= Optional.empty();
	private Calendar fecha;
	private Optional<Calendar> fechaFin= Optional.empty();
	
	
	public Trabajo(Servicio s, Calendar f, Trabajador t) {
		servicio=s;
		fecha=f;
		trabajador=Optional.of(t);
	}
	
	public Boolean getUrgente() {
		return servicio.getUrgencia();
	}
	
	public Oficio getOficio() {
		return servicio.getOficio();
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	public Trabajador getTrabajador() throws NullPointerException{
		return trabajador.orElseThrow(NullPointerException::new);
	}
	
	public Boolean cancelar() throws NullPointerException{
		/**
		 * @description ESTE METODO DEBE SER UTILIZADO POR UN SERVICIO
		 */
		if(trabajador.orElseThrow(NullPointerException::new).eliminarTrabajo(this));
		fecha=null;
		return true;
	}
	
	public void completado(Calendar f) {
		fechaFin=Optional.of(f);
	}
	
	public Optional<Calendar> getFechaFin(){
		return fechaFin;
	}
	
	public Boolean finalizado() {
		return fechaFin.isPresent();
	}
	
}
