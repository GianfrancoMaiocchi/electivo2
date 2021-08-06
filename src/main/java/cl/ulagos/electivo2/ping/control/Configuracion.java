package cl.ulagos.electivo2.ping.control;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class Configuracion {

	private Properties propiedades;
	
	@PostConstruct
	private void incializarPropiedades() throws IOException{
		
		try (InputStream inputStream = Configuracion.class.getResourceAsStream("/application.properties")){
			
			propiedades = new Properties();
			propiedades.load(inputStream);
		}
	}
	
	@Produces
	@Config("nousado")
	public String exponerConfiguracion(InjectionPoint puntoInyeccion) {
		
		String key = puntoInyeccion.getAnnotated().getAnnotation(Config.class).value();
		return propiedades.getProperty(key);
	}
	
}
