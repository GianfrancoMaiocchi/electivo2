package cl.ulagos.electivo2.ping.entity;

public class EspecificacionFusibles {

	private final Marca marca;
	private final Tamano tamano;
	
	public EspecificacionFusibles(Marca marca, Tamano tamano) {
		
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
