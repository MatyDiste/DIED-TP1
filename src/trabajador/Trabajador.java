package trabajador;
import reparaFix.Oficio;
import java.util.ArrayList;

public abstract class Trabajador {
	private String nombre="";
	private String correo="";
	private Float comision=0.0f;
	private Float costoPorHora=0.0f;
	private Oficio oficio;
	private ArrayList<Trabajo> listaTrabajos= new ArrayList<Trabajo>();
	/*Podria ser una fila, pero considero que los trabajos 
	 * no van a completarse en orden de llegada*/
	/*
	 * TODO
	 * Cuanto cobra el trabajador
	 * fijarse si es responsabilidad de trabajo o trabajador eso
	 */
	
	public Trabajador(String nom, String email, Float com, Float cph, Oficio o) {
		/**
		 * @param 	nom=	Nombre,
		 * 			email=	correo electronico,
		 * 			com=	comision,
		 * 			cph=	costo por hora,
		 * 			o=		Oficio.
		 */
		nombre=nom;
		correo=email;
		comision=com;
		costoPorHora=cph;
		oficio=o;
	}
	
	public Boolean addTrabajo(Trabajo t) {
		return listaTrabajos.add(t);
	}
	
	public Boolean delTrabajo(Trabajo t) {
		return listaTrabajos.remove(t);
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
	
	
}
