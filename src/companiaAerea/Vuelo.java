package companiaAerea;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Vuelo {
	
	private static int numVuelos = 0;
	
	private DateTimeFormatter diaMes = DateTimeFormatter.ofPattern("dd-MM");
	
	private int avionVuelo;
	private String ciudadOrigen;
	private LocalTime horaPartida;
	private String ciudadDestino;
	private LocalTime horaDestino;
	private String codVuelo;
	private LocalDate diaSalida;
	private LocalDate diaLlegada;
	
	
	static public int nuevoVuelo() {
		
		numVuelos++;
		
		return numVuelos;
		
		
	}
	//El booleano decide si muestras la informadion con los dias o sin los dias, siendo true sin los dias y false con los dias
	public void MostrarInformacionVuelo(boolean eleccionMostrar) {
		//transforma a minuscula las ciudades
		String destinoMinuscula = this.ciudadDestino.substring(0,1) + this.ciudadDestino.substring(1, this.ciudadDestino.length()).toLowerCase();
		String origenMinuscula = this.ciudadOrigen.substring(0,1) + this.ciudadOrigen.substring(1,this.ciudadOrigen.length()).toLowerCase();
		
		
		if(eleccionMostrar)System.out.println(this.codVuelo + ": " + origenMinuscula + " - " + destinoMinuscula + " \t" + this.horaPartida);
		else if(!eleccionMostrar)System.out.println(this.codVuelo + ": " + origenMinuscula + " - " + destinoMinuscula + " \t" + this.horaPartida +" - " + this.horaDestino
														+ "\tDia de vuelo: " + this.diaSalida.format(diaMes) + " - " + this.diaLlegada.format(diaMes));
	}
	
	
	
	public void establecerHoraLlegada(Integer duracionVuelo) {
		
		horaDestino = horaPartida.plusMinutes(duracionVuelo);
		
		if(horaDestino.isBefore(LocalTime.of(07, 00)) ) {
			
			this.diaLlegada = diaSalida.plusDays(1);
			System.out.println("Hora de llegada: " + horaDestino + " del dia siguiente");
			
			
		}else {
			this.diaLlegada = this.diaSalida;
			System.out.println("Hora de llegada: " + horaDestino);
			
		}

		
	}
	
	
	//constructor
	public Vuelo(int avionVuelo, String ciudadOrigen, LocalTime horaPartida, String ciudadDestino, String codVuelo, LocalDate diaSalida) {
		super();
		this.avionVuelo = avionVuelo;
		this.ciudadOrigen = ciudadOrigen;
		this.horaPartida = horaPartida;
		this.ciudadDestino = ciudadDestino;
		this.codVuelo = codVuelo;
		this.diaSalida = diaSalida;
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
