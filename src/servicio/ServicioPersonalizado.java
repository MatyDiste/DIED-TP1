package servicio;
import reparaFix.Oficio;
import excepciones.ServicioPersonalizadoSinDatosException;

public class ServicioPersonalizado extends Servicio {
	private Float costoPresupuesto=-1.0f;
	private Float costoMateriales=-1.0f;
	private Float costoTransporte=-1.0f;
	
	
	@Override
	public Float calcularCosto() throws ServicioPersonalizadoSinDatosException {
		if(	costoPresupuesto==-1.0f ||
			costoMateriales==-1.0f ||
			costoTransporte==-1.0f) {
			//NO INICIALIZO VARIABLES
			throw new ServicioPersonalizadoSinDatosException(
					costoPresupuesto,
					costoMateriales,
					costoTransporte);
		}
		
		Float total= costoPresupuesto + costoMateriales + costoTransporte;
		if(super.getUrgencia()) return total*1.5f;
		else return total;
	}
	
	public ServicioPersonalizado(Oficio o, Boolean urg, Float cp, Float cm, Float ct) {
		super.setOficio(o);
		super.setUrgencia(urg);
		costoPresupuesto=cp;
		costoMateriales=cm;
		costoTransporte=ct;
	}
	public ServicioPersonalizado(Oficio o, Boolean urg) {
		super.setOficio(o);
		super.setUrgencia(urg);
	}
	
	public Float getCostoPresupuesto() {
		return costoPresupuesto;
	}

	public void setCostoPresupuesto(Float costoPresupuesto) {
		this.costoPresupuesto = costoPresupuesto;
	}

	public Float getCostoMateriales() {
		return costoMateriales;
	}

	public void setCostoMateriales(Float costoMateriales) {
		this.costoMateriales = costoMateriales;
	}

	public Float getCostoTransporte() {
		return costoTransporte;
	}

	public void setCostoTransporte(Float costoTransporte) {
		this.costoTransporte = costoTransporte;
	}
	
}
