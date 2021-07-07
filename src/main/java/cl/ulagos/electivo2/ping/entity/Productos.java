package cl.ulagos.electivo2.ping.entity;

public class Productos {
	private final Baterias baterias;
	private final Bujias bujias;
	private final Fusibles fusibles;
	
	
	public Productos(Baterias baterias, Bujias bujias, Fusibles fusibles ) {
		this.baterias = baterias;
		this.bujias = bujias;
		this.fusibles = fusibles;
	}

	public Baterias getBaterias() {
		return baterias;
	}

	public Bujias getBujias() {
		return bujias;
	}

	public Fusibles getFusibles() {
		return fusibles;
	}

}
