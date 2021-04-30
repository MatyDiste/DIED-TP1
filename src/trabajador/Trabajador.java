package trabajador;
import reparaFix.Oficio;
import java.util.Calendar;
import java.util.ArrayList;
import excepciones.*;
import java.util.Optional;

public abstract class Trabajador {
	private String nombre="";
	private String correo="";
	private Float comision=-1.0f;
	private Float costoPorHora=-1.0f;
	private Oficio oficio;
	private ArrayList<Trabajo> listaTrabajos= new ArrayList<Trabajo>();
	private ArrayList<Calendar> agenda= new ArrayList<Calendar>();
	
	protected static ArrayList<Trabajador> listaTrabajadores= new ArrayList<Trabajador>();
	/*Podria ser una fila, pero considero que los trabajos 
	 * no van a completarse necesariamente en orden de llegada
	 *
	 * TODO
	 * metodos para la lista de trabajadores
	 * buscar disponible por fecha
	 * eliminar un trabajador (con muchos throws)
	 */
	
	public static Trabajador getTrabajadorDisponible(Calendar f, Oficio o) throws NingunTrabajadorDisponibleException{
		Optional<Trabajador> heroe;
		heroe=listaTrabajadores
				.stream()
				.filter(t -> t.agendaLibre(f) && t.getOficio()==o) //todos los que tengan la agenda disponible en la fecha f y tengan oficio o
				.findAny(); //cualquiera de esos
		return heroe.orElseThrow(NingunTrabajadorDisponibleException::new);
	}
	
	
	
	public Trabajador(String nom, String email, Float com, Float cph, Oficio o) {
		/**
		 * @param 	nom=	Nombre,
		 * 			email=	correo electronico,
		 * 			com=	comision (expresado en múltiplo, no porcentaje),
		 * 			cph=	costo por hora,
		 * 			o=		Oficio.
		 */
		nombre=nom;
		correo=email;
		comision=com;
		costoPorHora=cph;
		oficio=o;
		listaTrabajadores.add(this);
	}
	
	public Boolean agregarTrabajo(Trabajo t) throws Exception{
		if(t.getOficio() != oficio) //Si el oficio no coincide
			throw new OficioNoCoincideException(t.getOficio(), oficio);
		
		if(agenda.contains(t.getFecha())) //Si la agenda está ocupada
			throw new AgendaOcupadaException(t.getFecha());
			
		return listaTrabajos.add(t);
	}
	
	public Boolean eliminarTrabajo(Trabajo t) throws RuntimeException{
		Boolean ret= agenda.remove(t.getFecha()) && listaTrabajos.remove(t);
		if(!ret) throw new RuntimeException("No se pudo encontrar el trabajo en la agenda o en la lista de trabajos");
		return ret;
		
	}
	
	public Boolean agendaLibre(Calendar fecha) {
		return !agenda.contains(fecha);
	}
	
	public Boolean tieneTrabajos() {
		return !listaTrabajos.isEmpty();
	}
	
	public Integer cuantosTrabajos() {
		return listaTrabajos.size();
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Float getComision() {
		return comision;
	}

	public void setComision(Float comision) {
		this.comision = comision;
	}

	public Float getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(Float costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public Oficio getOficio() {
		return oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}

	public ArrayList<Trabajo> getListaTrabajos() {
		return listaTrabajos;
	}
	
	@Override
	public boolean equals(Object o) {
		/**
		 * @description Dos trabajadores son iguales si tienen el mismo correo
		 */
		return ((Trabajador) o).getCorreo().equals(this.getCorreo()); 
	}
	
	
}
