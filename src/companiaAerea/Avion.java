package companiaAerea;

import java.util.Objects;

public class Avion {

	private int numAvion;
	private String ubicacionAvion = "Madrid";
	
	
	public void cambiarUbicacion(String ubicacion) {
		
		this.ubicacionAvion = ubicacion;
		
	}
	
	//Constructors
	public Avion(int numAvion) {
		super();
		this.numAvion = numAvion;
	}
	//Getters and setters
	public String getUbicacionAvion() {
		return ubicacionAvion;
	}
	public void setUbicacionAvion(String ubicacionAvion) {
		this.ubicacionAvion = ubicacionAvion;
	}
	public int getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(int numAvion) {
		this.numAvion = numAvion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numAvion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return numAvion == other.numAvion;
	}
	
	
	
	

	
	
}
