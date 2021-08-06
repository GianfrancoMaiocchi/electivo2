package cl.ulagos.electivo2.ping.boundary;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import cl.ulagos.electivo2.ping.entity.EspecificacionFusibles;
import cl.ulagos.electivo2.ping.entity.Tamano;
import cl.ulagos.electivo2.ping.entity.Marca;



@Named("fusibleBacking")
@ViewScoped
public class FusibleBackingBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject 
	private CreaFusibles creaFusibles; 
	
	private String tamano;
	
	private String marca;
	
	public String crearFusible() throws SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException
	{
		EspecificacionFusibles especificacionFusibles = new EspecificacionFusibles(Tamano.valueOf(this.tamano), Marca.valueOf(marca));
		System.out.println("Hola Mundo");
		creaFusibles.creaFusibles(especificacionFusibles);
		FacesContext.getCurrentInstance().addMessage("formulario:mensaje", new FacesMessage("Fusible Creado", "Fusible Creado"));

		return "Fusible Creado";
	}

	public CreaFusibles getCreaFusibles() {
		return creaFusibles;
	}

	public void setCreaFusibles(CreaFusibles creaFusibles) {
		this.creaFusibles = creaFusibles;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
