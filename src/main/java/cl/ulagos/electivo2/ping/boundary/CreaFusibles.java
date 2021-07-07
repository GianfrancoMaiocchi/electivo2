package cl.ulagos.electivo2.ping.boundary;


import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cl.ulagos.electivo2.ping.control.CacheFusibles;
import cl.ulagos.electivo2.ping.control.FactoriaFusibles;
import cl.ulagos.electivo2.ping.control.RepositorioFusibles;
import cl.ulagos.electivo2.ping.entity.EspecificacionFusibles;
import cl.ulagos.electivo2.ping.entity.Fusibles;
import cl.ulagos.electivo2.ping.entity.FusiblesCreado;


@Stateless
public class CreaFusibles {
	
	
	@Inject
	private FactoriaFusibles factoriaFusibles = new FactoriaFusibles();
	@Inject
	private RepositorioFusibles repositorioFusibles = new RepositorioFusibles();
	
	@Inject 
	CacheFusibles cacheFusibles;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Inject
	Event<FusiblesCreado> fusiblesCreado;
	
	public Fusibles creaFusibles(EspecificacionFusibles especificacionFusibles) {
		
		Fusibles fusibles = factoriaFusibles.creaFusibles(especificacionFusibles);
		cacheFusibles.cache(fusibles);
		repositorioFusibles.store(fusibles);
		entityManager.persist(fusibles);
		fusiblesCreado.fire(new FusiblesCreado(fusibles.getIdentificador()));
		return fusibles;
	}

	public List<Fusibles> obtenerFusibles() {
		
		return cacheFusibles.retrieveFusibles();

	}

}
