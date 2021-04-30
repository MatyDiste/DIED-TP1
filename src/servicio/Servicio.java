package servicio;
import reparaFix.Oficio;
import trabajador.Trabajador;
import trabajador.Trabajo;
import usuario.Usuario;
import reparaFix.Contratable;
import java.util.Calendar;
import java.util.Optional;



public abstract class Servicio implements Contratable{
	private Boolean urgencia;
	private Oficio oficio;
	private Usuario usuario;
	private Optional<Trabajo> trabajo= Optional.empty();
	private Calendar fecha;
	
	
	//CONSTRUCTOR
	public Servicio(Boolean urg, Oficio ofi, Usuario user, Calendar f) {
		urgencia=urg;
		oficio=ofi;
		usuario=user;
		fecha=f;
	}
	//CONSTRUCTOR
	public Boolean getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(Boolean b) {
		urgencia=b;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio o) {
		oficio=o;
	}
	public Calendar getFecha() throws NullPointerException{
		return trabajo.orElseThrow(NullPointerException::new).getFecha();
	}
	public Trabajo getTrabajo() throws NullPointerException{
		return trabajo.orElseThrow(NullPointerException::new);
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Trabajador getTrabajador() throws NullPointerException{
		return trabajo.orElseThrow(NullPointerException::new).getTrabajador();
	}
	
	
	//CONTRATABLE INTERFACE
	@Override
	public Boolean contratar() throws Exception{
		Trabajador heroe=Trabajador.getTrabajadorDisponible(fecha, oficio);
		trabajo =  Optional.of(new Trabajo(this, fecha, heroe));
		
		heroe.agregarTrabajo(trabajo.get());
		return true;
	}
	@Override
	public Boolean cancelarContrato() throws NullPointerException{
		trabajo.orElseThrow(NullPointerException::new).cancelar();
		oficio=null;
		usuario=null;
		return true;
	}
	
	public Boolean finalizado() throws NullPointerException{
		return trabajo.orElseThrow(NullPointerException::new).finalizado();
	}
	//CONTRATABLE INTERFACE
}