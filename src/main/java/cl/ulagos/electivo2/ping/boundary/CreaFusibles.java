package cl.ulagos.electivo2.ping.boundary;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import cl.ulagos.electivo2.ping.control.CacheFusibles;
import cl.ulagos.electivo2.ping.control.FactoriaFusibles;
import cl.ulagos.electivo2.ping.control.RepositorioFusibles;
import cl.ulagos.electivo2.ping.entity.EspecificacionFusibles;
import cl.ulagos.electivo2.ping.entity.Fusibles;
import cl.ulagos.electivo2.ping.entity.FusiblesCreado;
import cl.ulagos.electivo2.ping.interceptores.MiInterceptor;


@Named
@RequestScoped
public class CreaFusibles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction utx;
	
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
	
	@Interceptors(MiInterceptor.class)
	public Fusibles creaFusibles(EspecificacionFusibles especificacionFusibles) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		
		Fusibles fusibles = factoriaFusibles.creaFusibles(especificacionFusibles);
		utx.begin();
		cacheFusibles.cache(fusibles);
		repositorioFusibles.store(fusibles);
		entityManager.persist(fusibles);
		utx.commit();
		fusiblesCreado.fire(new FusiblesCreado(fusibles.getIdentificador()));
		return fusibles;
	}

	public List<Fusibles> obtenerFusibles() {
		
		return repositorioFusibles.cargarFusibles();

	}

	public Fusibles obtenerFusibles(String id) {
	
		return repositorioFusibles.obtenerFusiblesl(id);
	}

}
