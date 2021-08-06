package cl.ulagos.electivo2.ping.boundary;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cl.ulagos.electivo2.ping.entity.Fusibles;


@Named("dtFusibles")
@ViewScoped
public class ListaFusiblesBackingBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Fusibles> fusibles;
	private Fusibles fusibleSeleccionado;

	@Inject 
	private CreaFusibles creaFusibles; 

	@PostConstruct
	public void init() {

		fusibles = creaFusibles.obtenerFusibles();
	}

	public List<Fusibles> getFusibles(){

		return fusibles;
	}

	public Fusibles getFusibleSeleccionado() {

		return fusibleSeleccionado;
	}

	public void setAutomovilSeleccionado(Fusibles fusibleSeleccionado) {

		this.fusibleSeleccionado = fusibleSeleccionado;
	}


}
