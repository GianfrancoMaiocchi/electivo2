package cl.ulagos.electivo2.ping.control;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import cl.ulagos.electivo2.ping.entity.Fusibles;
import cl.ulagos.electivo2.ping.entity.Marca;
import cl.ulagos.electivo2.ping.entity.Tamano;


public class RepositorioFusibles {

	List<Fusibles> listaFusibles = new ArrayList<Fusibles>();

	public void store(Fusibles fusibles) {
		//store
		listaFusibles.add(fusibles);
	}

	public Fusibles obtenerFusiblesl(String id) {

		for (Fusibles fusibles : listaFusibles)
		{
			if (fusibles.getIdentificador().equals(id))
				return fusibles;
		}

		return null;
	}

	public List<Fusibles> cargarFusibles(){

		return listaFusibles;
	}

	public List<Fusibles> cargarFusibles(Marca marca){

		return listaFusibles.stream().filter(fusibles->fusibles.getMarca().equals(marca)).collect(Collectors.toList());
	}

	public void inicializar() {

		Fusibles fusibles = new Fusibles();
		fusibles.setIdentificador(UUID.randomUUID().toString());
		fusibles.setMarca(Marca.F2);
		fusibles.setTamano(Tamano.PEQUEÑO);
		listaFusibles.add(fusibles);

		fusibles = new Fusibles();
		fusibles.setIdentificador(UUID.randomUUID().toString());
		fusibles.setMarca(Marca.F1);
		fusibles.setTamano(Tamano.GRANDE);
		listaFusibles.add(fusibles);
	}
	
}
