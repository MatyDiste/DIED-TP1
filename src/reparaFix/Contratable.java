package reparaFix;
public interface Contratable {
	//Agrega funcionalidad para que sea contratable
	public Float calcularCosto() throws Exception;
	public Boolean contratar() throws Exception;
	public Boolean cancelarContrato();
	public Boolean finalizado();
	
}
