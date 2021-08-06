package cl.ulagos.electivo2.ping.entity;


public class EspecificacionFusibles {

	
	private  Marca marca;

	private  Tamano tamano;
	
	

	public EspecificacionFusibles(Tamano tamano, Marca marca) {
		
		this.marca = marca;
		this.tamano = tamano;
		
		
	}

	public Marca getMarca() {
		return marca;
	}

	public Tamano getTamano() {
		return tamano;
	}
}
