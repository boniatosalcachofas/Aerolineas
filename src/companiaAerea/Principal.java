package companiaAerea;
import java.time.*;
import java.util.HashSet;
import java.time.format.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;


public class Principal {
	
	static Avion aviones[] = new Avion[4];
	//Mete todos los vuelos
	static LinkedList <Vuelo> VuelosTotales = new LinkedList();
	//Mete los vuelos con su duracion
	static HashMap <Vuelo, Integer> vuelosDuracion = new HashMap();
	static LocalDate fechaVuelo = LocalDate.now();
	static LocalTime horaPrueba = LocalTime.now();
	

	public static void main(String[] args) {
		// TODO Aasacdsauto-generated method stub
		HashSet<Avion> vehiculos = new HashSet();
		Random r = new Random();
		aviones[0] = new Avion(1);
		aviones[1] = new Avion(2);
		aviones[2] = new Avion(3);
		aviones[3] = new Avion(4);
		
		menuPrincipal();
		
	}
	
	public static void menuPrincipal() {
	
		HashSet <Vuelo> vuelos = vuelosProgramados();
		
		DateTimeFormatter diaMesAnyo = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		DateTimeFormatter mesDiaAnyo = DateTimeFormatter.ofPattern("MM-dd-YYYY");

		System.out.println(fechaVuelo.format(diaMesAnyo) + 
				"\n1.- Listado de vuelos totales\n"
				+ "2.- Pasar dia siguiente y ver vuelos\n"
				+ "\nVuelos " + fechaVuelo.format(mesDiaAnyo) + "\tHora de salida");
		
		for(Vuelo v : vuelos) {
			
			v.MostrarInformacionVuelo();
			
		}
		
		establecerDuracionHoraDestino(vuelos);
		
		
		
	}

	public static void establecerDuracionHoraDestino(HashSet<Vuelo> vuelos) {
		for(Vuelo v : vuelos) {
			
			if(!vuelosDuracion.containsKey(v)) {
				Integer duracion;
				
				while (true) {
					System.out.println("Duracion del vuelo en minutos del avion " + v.getAvionVuelo() + ": "
							+ v.getCiudadOrigen() + " - " + v.getCiudadDestino());
					
					duracion = new Scanner(System.in).nextInt();
					if (duracion > 300) {
						
						System.out.println("duracion excedida, por favor, introduce un tiempo menor a 5 horas o 300 minutos.");
						
					}else break;
				}
				//anyade el vuelo a los arrays, tanto totales como los de duracion
				vuelosDuracion.put(v, duracion);
				VuelosTotales.addLast(v);
				
			}
			
		}
	}
	
	//saca 4 vuelos
	public static HashSet <Vuelo> vuelosProgramados() {
		HashSet <Vuelo> vuelosDiarios = new HashSet();
		
		for(int i = 0; i < aviones.length; i++) {
			
			String destino = ubicacionVuelos(i).toUpperCase();
			String origen = aviones[i].getUbicacionAvion().toUpperCase();
			LocalTime horaPartida = generadorHoras();
			String codVuelo = aviones[i].getNumAvion() + origen.substring(0,2) + destino.substring(0,2) + Vuelo.nuevoVuelo();
			
			Vuelo vuelo = new Vuelo((i+1), origen, horaPartida, destino, codVuelo);
			
			if(vuelosDiarios.contains(vuelo)) {
				i--;
				continue;
			
			}
			aviones[i].cambiarUbicacion(destino);
			vuelosDiarios.add(vuelo);
			
		}
		return vuelosDiarios;
		
		
		
		
	}
	public static String ubicacionVuelos(int numAvion) {
		
			String ubicacionAvion = aviones[numAvion].getUbicacionAvion().toUpperCase();
			String ubicacionDestino = ubicacionAvion;
			int destino = -5;
			
		    while (ubicacionAvion.equals(ubicacionDestino)) {
				
		    	destino = new Random().nextInt(Ciudad.values().length);
		    	ubicacionDestino = Ciudad.values()[destino].name();
				
			}
		    
		    return Ciudad.values()[destino].name();
		
	}
	
	public static LocalTime generadorHoras() {
		Random r = new Random();
		
		int horas = r.nextInt(17)+7;
		int minutos = (r.nextInt(11)+1)*5;
		
		LocalTime horaVuelo = LocalTime.of(horas, minutos);
		
		
	return horaVuelo;	
		
	}
	

}
