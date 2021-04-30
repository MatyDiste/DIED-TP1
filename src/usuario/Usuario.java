package usuario;
import java.util.ArrayList;
import excepciones.*;
import alquiler.*;
import reparaFix.Contratable;

public class Usuario {
	private String username="";
	private String email="";
	private String password="";
	private ArrayList<Contratable> listaContratables= new ArrayList<Contratable>();
	
	protected static ArrayList<Usuario> listaUsuarios= new ArrayList<Usuario>();
	
	public Usuario(String usr, String correo, String pssw) throws UsuarioYaExistenteException{
		username=usr;
		email=correo;
		password=pssw;
		if(listaUsuarios.contains(this)) throw new UsuarioYaExistenteException();
		else listaUsuarios.add(this);
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Boolean iniciarSesion(String pssw) {
		return pssw.equals(password);
	}
	
	public Boolean contratar(Contratable o) throws Exception{
		if(o instanceof Alquiler && !this.puedeAlquilar())
			throw new AlquilerNoEntregadoException();
		if(o.contratar()) {
			listaContratables.add(o);
			return true;
		} else return false;
	}
	
	public Boolean puedeAlquilar() {
		return listaContratables
				.stream()
				.filter(c -> c instanceof Alquiler && !c.finalizado()) //Si es alquiler y no lo devolvió
				.count() >= 2;
	}
	
	
	@Override
	public boolean equals(Object o) {
		/**
		 * @description		Un usuario es igual a otro si sus emails o sus nombres son iguales
		 */
		return this.username.equals(((Usuario) o).getUsername()) ||
				this.email.equals(((Usuario) o).getEmail());
	}
	//TODO
	//Moros
		
}
