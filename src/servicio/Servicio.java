package servicio;

public abstract class Servicio {
	Float precio=0f;
	Boolean urgente=false;
	
	//TODO
	//Oficio al que pertenece
	//Tipo de servicio, si es personalizado o estandar
	
	public Float getPrecio() {
		if(urgente) return precio*1.5f;
		else return precio;
	}
	
	
}
