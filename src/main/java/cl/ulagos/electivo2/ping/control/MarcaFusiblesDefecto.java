package cl.ulagos.electivo2.ping.control;

import java.awt.Color;

import javax.enterprise.inject.Produces;

import cl.ulagos.electivo2.ping.entity.Marca;

public class MarcaFusiblesDefecto {

		
		@Produces
		public Marca exponerMarcaDefecto() {
			
			return Marca.F1;
		}
		
	
	
}
