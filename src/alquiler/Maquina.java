package alquiler;
import java.util.ArrayList;
import java.util.Optional;

public class Maquina {
	private Float precioPorDia=0.0f;
	private TipoMaquina tipo;
	private Boolean disponible=true;
	
	private static ArrayList<Maquina> listaMaquinas = new ArrayList<Maquina>();
	
	public static Optional<Maquina> disponible(TipoMaquina t){
		return listaMaquinas
				.stream()
				.filter(m -> m.getDisponible() && m.getTipoMaquina() == t)
				.findAny();
	}
	
	//CONSTRUCTOR
	public Maquina(TipoMaquina t, Float ppd) {
		precioPorDia=ppd;
		tipo=t;
		listaMaquinas.add(this);
	}
	//CONSTRUCTOR
	//GETTERS
	public Float getPrecioPorDia() {
		return precioPorDia;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public TipoMaquina getTipoMaquina() {
		return tipo;
	}
	//GETTERS
	//SETTERS
	public void setDisponible(Boolean d) {
		disponible=d;
	}
	//SETTERS
}
