package cl.ulagos.electivo2.ping.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cl.ulagos.electivo2.ping.entity.Fusibles;

@Singleton
public class CacheFusibles {
	
	private final Map<String, Fusibles> cache = new ConcurrentHashMap<>();
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@PostConstruct
	private void inicializarCache() {

		cargarFusibles();
	}
	public void cache(Fusibles fusibles) {
		
		cache.put(fusibles.getIdentificador(), fusibles);
	}
	
	public void cargarFusibles() {
		
		List<Fusibles> lista = entityManager.createNamedQuery("TODOS_FUSIBLES", Fusibles.class).getResultList();
		lista.forEach(this::cache);
	}
	
	public List<Fusibles> retrieveFusibles(){
		
		return new ArrayList<>(cache.values());
	}
	

}








	
	
