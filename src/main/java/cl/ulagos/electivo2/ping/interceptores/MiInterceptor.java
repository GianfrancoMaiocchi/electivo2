package cl.ulagos.electivo2.ping.interceptores;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import cl.ulagos.electivo2.ping.entity.*;

@Interceptor
public class MiInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		
		Object [] lista = context.getParameters();
		for (Object objeto : lista) {
			
			if (objeto instanceof EspecificacionFusibles)
			{
				EspecificacionFusibles especificacionFusibles = (EspecificacionFusibles) objeto;
				System.out.println("Marca: " + especificacionFusibles.getMarca());
			}
			
		}
		return context.proceed();
	}
	
}
