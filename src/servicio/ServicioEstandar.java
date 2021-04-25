package servicio;
import servicio.TipoServicioEstandar;
import reparaFix.Oficio;

public class ServicioEstandar extends Servicio {
	TipoServicioEstandar tipo;
	
	@Override
	public Float calcularCosto() {
		Float precioTotal=0.0f;
		switch(tipo) {
		case INSTALACION:
			//TODO
			//PRECIO INSTALACION
			precioTotal=150.0f;
		case REPARACION:
			//PRECIO REPARACION
			precioTotal=200.0f;;
		case MANTENIMIENTO:
			//PRECIO MANTENIMIENTO
			precioTotal=120.0f;
		default:
			//NO DEBERIA ENTRAR NUNCA POR ACA
			precioTotal=-1.0f;
		}
		if(super.getUrgencia()) return precioTotal * 1.5f;
		else return precioTotal;
	}
	
	public ServicioEstandar(Oficio o, Boolean urg, TipoServicioEstandar t) {
		super.setOficio(o);
		super.setUrgencia(urg);
		tipo=t;
	}
	
	
	
}
