package servicio;
import reparaFix.Oficio;
import usuario.Usuario;
import java.util.Calendar;


public class ServicioEstandar extends Servicio{
	TipoServicioEstandar tipo;
	
	@Override
	public Float calcularCosto() throws RuntimeException{
		Float precioTotal=0.0f;
		switch(tipo) {
		case INSTALACION:
			precioTotal=150.0f;
			break;
		case REPARACION:
			precioTotal=200.0f;
			break;
		case MANTENIMIENTO:
			precioTotal=120.0f;
			break;
		default:
			throw new RuntimeException("Tipo de servicio estándar inválido");
		}
		if(super.getUrgencia()) precioTotal *= 1.5f;
		precioTotal+= super.getTrabajador().getComision() * precioTotal;
		return precioTotal;
	}
	
	public ServicioEstandar(Boolean urg, Oficio o, Usuario u, Calendar f, TipoServicioEstandar t) {
		super(urg, o, u, f);
		tipo=t;
	}
	
	
	
}
