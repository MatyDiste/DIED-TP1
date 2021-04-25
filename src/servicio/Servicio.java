package servicio;
import reparaFix.Oficio;

public abstract class Servicio {
	private Boolean urgencia=false;
	private Oficio oficio;
	
	public Boolean getUrgencia() {
		return urgencia;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setUrgencia(Boolean b) {
		urgencia=b;
	}
	public void setOficio(Oficio o) {
		oficio=o;
	}
	
	public abstract Float calcularCosto() throws Exception;
}