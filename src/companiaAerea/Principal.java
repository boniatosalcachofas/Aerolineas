package companiaAerea;
import java.time.*;
import java.util.LinkedHashSet;
import java.time.format.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;


public class Principal {
	static DateTimeFormatter diaMesAnyo = DateTimeFormatter.ofPattern("dd-MM-YYYY");
	static DateTimeFormatter mesDiaAnyo = DateTimeFormatter.ofPattern("MM-dd-YYYY");
	
	
	static Avion aviones[] = new Avion[4];
	//Mete todos los vuelos
	static LinkedList <Vuelo> VuelosTotales = new LinkedList();
	//Mete los vuelos con su duracion
	static HashMap <Vuelo, Integer> vuelosDuracion = new HashMap();
	static LocalDate fechaActual = LocalDate.now();
	//Comprueba que los vuelos que se introducen no se repiten para mostrarlos en pantalla
	static boolean vuelosNuevos = true;

	
	

	public static void main(String[] args) {
		// TODO Aasacdsauto-generated method stub
	
		aviones[0] = new Avion(1);
		aviones[1] = new Avion(2);
		aviones[2] = new Avion(3);
		aviones[3] = new Avion(4);
		
		while (true) {
			menuPrincipal();
		}
		
	}
	
	public static void menuPrincipal() {
	
		LinkedHashSet <Vuelo> vuelos = vuelosProgramados();
		

		while (true) {
			System.out.println(fechaActual.format(diaMesAnyo) + "\n1.- Listado de vuelos totales\n"
					+ "2.- Pasar dia siguiente y ver vuelos\n" + "\nVuelos " + fechaActual.format(mesDiaAnyo)
					+ "\tHora de salida");
			for (Vuelo v : vuelos) {
				v.MostrarInformacionVuelo(true);
			}
			System.out.println();
			establecerDuracionHoraDestino(vuelos);
			System.out.println("\n1.- Listado de vuelos totales" + "\n2.- Pasar dia siguiente y ver vuelos"
					+ "\nPulsa una opcion:");
			int eleccion = new Scanner(System.in).nextInt();
			switch (eleccion) {

			case 1:
				mostrarVuelosTotales();
				vuelosNuevos = false;
				break;

			case 2:
				pasoDia();
				break;

			}
		}
		
		
	}
	//Pregunta, si no se conoce la duracion de ese vuelo, su duracion, y si es asi, lo omite y almacena el vuelo en vuelos totales.
	//muestra siempre la hora de llegada
	public static void establecerDuracionHoraDestino(LinkedHashSet<Vuelo> vuelos) {
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

				
			}else {
				
				System.out.println("Hora de llegada del vuelo del avion " + v.getAvionVuelo() + ": "
						+ v.getCiudadOrigen() + " - " + v.getCiudadDestino());
				
				
			}
			
			Integer duracion = vuelosDuracion.get(v);
			v.establecerHoraLlegada(duracion);
			
			
			if(vuelosNuevos)VuelosTotales.addLast(v);
			
			
			
		}
	}
	
	//saca 4 vuelos diarios
	public static LinkedHashSet <Vuelo> vuelosProgramados() {
		LinkedHashSet <Vuelo> vuelosDiarios = new LinkedHashSet();
		
		for(int i = 0; i < aviones.length; i++) {
			
			String destino = ubicacionVuelos(i).toUpperCase();
			String origen = aviones[i].getUbicacionAvion().toUpperCase();
			LocalTime horaPartida = generadorHoras();
			String codVuelo = aviones[i].getNumAvion() + origen.substring(0,2) + destino.substring(0,2) + Vuelo.nuevoVuelo();
			
			Vuelo vuelo = new Vuelo((i+1), origen, horaPartida, destino, codVuelo, fechaActual);
			
			if(vuelosDiarios.contains(vuelo)) {
				Vuelo.setNumVuelos(Vuelo.getNumVuelos()-1);
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
	
	public static void pasoDia() {
		
		fechaActual = fechaActual.plusDays(1);
		
	}
	
	public static void mostrarVuelosTotales() {
		
		for(Vuelo v : VuelosTotales) {
			v.MostrarInformacionVuelo(false);
		}
		
		System.out.println("Continuar con el menu");
		String continuar = new Scanner(System.in).nextLine();
		
	}
	

}
