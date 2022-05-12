package companiaAerea;

import java.time.*;
import java.util.Objects;

public class Vuelo {
	
	static int numVuelos = 0;
	
	int avionVuelo;
	String ciudadOrigen;
	LocalTime horaPartida;
	String ciudadDestino;
	LocalTime horaDestino;
	String codVuelo;
	
	
	static public int nuevoVuelo() {
		
		numVuelos++;
		
		return numVuelos;
		
		
	}
	public void MostrarInformacionVuelo() {
		
		System.out.println(this.codVuelo + ": " + this.ciudadOrigen + " - " + this.ciudadDestino + " \t" + this.horaPartida);
		
	}
	
	
	//constructor
	public Vuelo(int avionVuelo, String ciudadOrigen, LocalTime horaPartida, String ciudadDestino, String codVuelo) {
		super();
		this.avionVuelo = avionVuelo;
		this.ciudadOrigen = ciudadOrigen;
		this.horaPartida = horaPartida;
		this.ciudadDestino = ciudadDestino;
		this.codVuelo = codVuelo;
	}



	@Override
	public int hashCode() {
		return Objects.hash(ciudadDestino, ciudadOrigen);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(ciudadDestino, other.ciudadDestino) && Objects.equals(ciudadOrigen, other.ciudadOrigen);
	}


//getters
	public static int getNumVuelos() {
		return numVuelos;
	}



	public static void setNumVuelos(int numVuelos) {
		Vuelo.numVuelos = numVuelos;
	}



	public int getAvionVuelo() {
		return avionVuelo;
	}



	public void setAvionVuelo(int avionVuelo) {
		this.avionVuelo = avionVuelo;
	}



	public String getCiudadOrigen() {
		return ciudadOrigen;
	}



	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}



	public LocalTime getHoraPartida() {
		return horaPartida;
	}



	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}



	public String getCiudadDestino() {
		return ciudadDestino;
	}



	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}



	public LocalTime getHoraDestino() {
		return horaDestino;
	}



	public void setHoraDestino(LocalTime horaDestino) {
		this.horaDestino = horaDestino;
	}



	public String getCodVuelo() {
		return codVuelo;
	}



	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}
	
	
	

	
	
	
	
}
