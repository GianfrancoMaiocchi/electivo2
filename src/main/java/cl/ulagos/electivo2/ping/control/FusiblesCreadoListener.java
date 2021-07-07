package cl.ulagos.electivo2.ping.control;

import javax.enterprise.event.Observes;

import cl.ulagos.electivo2.ping.entity.FusiblesCreado;

public class FusiblesCreadoListener {
	
	
	public void onFusiblesCreadoListener(@Observes FusiblesCreado fusiblesCreado) {
		
		//..
		
		System.out.println("Fusible Creado" + fusiblesCreado.getIdentificador());
		
	}

}
