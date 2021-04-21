package servicio;

public abstract class Servicio {
	Float precio=0f;
	Boolean urgente=false;
	TipoServicio tipo=TipoServicio.INSTALACION;
	
	
	//TODO
	//Oficio al que pertenece
	//Funciones
	public Float getPrecio() {
		if(urgente) return precio*1.5f;
		else return precio;
	}
	
	
}
