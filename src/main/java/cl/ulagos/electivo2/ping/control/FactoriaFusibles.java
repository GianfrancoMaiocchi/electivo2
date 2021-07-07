package cl.ulagos.electivo2.ping.control;

import java.util.UUID;

import javax.inject.Inject;

import cl.ulagos.electivo2.ping.entity.EspecificacionFusibles;
import cl.ulagos.electivo2.ping.entity.Fusibles;
import cl.ulagos.electivo2.ping.entity.Marca;




public class FactoriaFusibles {
	
	@Inject
	Marca marcaFusiblesDefecto;

	public Fusibles creaFusibles(EspecificacionFusibles especificacionFusibles) {
	
		Fusibles fusibles = new Fusibles();
		fusibles.setIdentificador(UUID.randomUUID().toString());
		fusibles.setMarca(especificacionFusibles.getMarca()== null ? marcaFusiblesDefecto: especificacionFusibles.getMarca());
		fusibles.setTamaño(especificacionFusibles.getTamano());
		
		
		//store en base de datos
		return fusibles;
	}
	
}
