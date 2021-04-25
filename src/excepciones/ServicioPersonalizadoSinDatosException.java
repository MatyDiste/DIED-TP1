package excepciones;

public class ServicioPersonalizadoSinDatosException extends Exception {
	/*
	 * Excepcion de ServicioPersonalizado
	 */
	String message="";
	public ServicioPersonalizadoSinDatosException(Float cp, Float cm, Float ct) {
		/**
		 * @param 	cp=costoPresupuesto,
		 * 			cm=costoMateriales,
		 * 			ct=costoTransporte
		 */
		StringBuffer strMsg=new StringBuffer("No se puede calcular el costo porque falta inicializar: \n");
		if(cp==-1.0f) strMsg.append("Costo presupuestado\n");
		if(cm==-1.0f) strMsg.append("Costo de materiales\n");
		if(ct==-1.0f) strMsg.append("Costo de transporte");
		message = strMsg.toString();
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
