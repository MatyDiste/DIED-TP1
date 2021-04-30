package servicio;
import reparaFix.Oficio;
import excepciones.ServicioPersonalizadoSinDatosException;
import usuario.Usuario;
import java.util.Calendar;

public class ServicioPersonalizado extends Servicio {
	private Float costoPresupuesto=-1.0f;
	private Float costoMateriales=-1.0f;
	private Float costoTransporte=-1.0f;
	
	
	@Override
	public Float calcularCosto() throws ServicioPersonalizadoSinDatosException {
		
		Float total= this.getCostoPresupuesto() + this.getCostoMateriales() + this.getCostoTransporte();
		if(super.getUrgencia()) total*=1.5f;
		total+= super.getTrabajador().getComision() * total;
		return total;
	}
	//CONSTRUCTOR
	public ServicioPersonalizado(Boolean urg, Oficio o, Usuario u, Calendar f, Float cp, Float cm, Float ct) {
		super(urg, o, u, f);
		costoPresupuesto=cp;
		costoMateriales=cm;
		costoTransporte=ct;
	}
	public ServicioPersonalizado(Boolean urg, Oficio o, Usuario u, Calendar f) {
		super(urg, o, u, f);
	}
	//CONSTRUCTOR
	public Float getCostoPresupuesto() throws ServicioPersonalizadoSinDatosException {
		if(costoPresupuesto==-1.0f) 
			throw new ServicioPersonalizadoSinDatosException(
					costoPresupuesto,
					costoMateriales,
					costoTransporte);
		return costoPresupuesto;
	}

	public void setCostoPresupuesto(Float costoPresupuesto) {
		this.costoPresupuesto = costoPresupuesto;
	}

	public Float getCostoMateriales() throws ServicioPersonalizadoSinDatosException {
		if(costoMateriales==-1.0f) 
			throw new ServicioPersonalizadoSinDatosException(
					costoPresupuesto,
					costoMateriales,
					costoTransporte);
		return costoMateriales;
	}

	public void setCostoMateriales(Float costoMateriales) {
		this.costoMateriales = costoMateriales;
	}

	public Float getCostoTransporte() throws ServicioPersonalizadoSinDatosException {
		if(costoMateriales==-1.0f) 
			throw new ServicioPersonalizadoSinDatosException(
					costoPresupuesto,
					costoMateriales,
					costoTransporte);
		return costoTransporte;
	}

	public void setCostoTransporte(Float costoTransporte) {
		this.costoTransporte = costoTransporte;
	}
	
}
