package alquiler;

import java.util.Calendar;
import java.util.Optional;
import excepciones.NingunaMaquinaDisponibleException;
import reparaFix.Contratable;

public class Alquiler implements Contratable {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Optional<Calendar> fechaDevolucion= Optional.empty();
	private Maquina maquina;

	public Boolean enMora() {
		return (fechaFin.compareTo(fechaDevolucion.orElse(Calendar.getInstance()))) < 0;
	}
	
	//CONSTRUCTOR
	public Alquiler(Calendar fInicio, Integer cantDias, TipoMaquina tipoM) throws NingunaMaquinaDisponibleException{
		maquina= Maquina.disponible(tipoM).orElseThrow(NingunaMaquinaDisponibleException::new);
		fechaInicio= fInicio;
		fechaFin= fInicio;
		fechaFin.add(Calendar.DAY_OF_YEAR, cantDias);
	}
	//CONSTRUCTOR
	//GETTERS
	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public Optional<Calendar> getFechaDevolucion() {
		return fechaDevolucion;
	}

	public Maquina getMaquina() {
		return maquina;
	}
	//GETTERS
	
	// CONTRATABLE INTERFACE
	@Override
	public Float calcularCosto() throws Exception {
		Integer cantDiasTotales = (fechaDevolucion.orElse(Calendar.getInstance())
				.compareTo(fechaInicio)) / (24*60*60*1000);
		return cantDiasTotales * maquina.getPrecioPorDia();
	}

	@Override
	public Boolean contratar() throws Exception {
		maquina.setDisponible(false); 
		/*Si existe algun alquiler para una maquina, 
		 *la maquina no va a estar disponible para seleccionar en el alquiler
		 */
		return true;
		//TODO?
	}

	@Override
	public Boolean cancelarContrato() {
		maquina.setDisponible(true);
		return true;
	}

	@Override
	public Boolean finalizado() {
		return fechaDevolucion.isPresent();
	}
	//CONTRATABLE INTERFACE
	
}
