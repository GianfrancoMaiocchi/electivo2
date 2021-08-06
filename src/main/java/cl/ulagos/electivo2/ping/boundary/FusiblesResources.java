package cl.ulagos.electivo2.ping.boundary;



import java.net.URI;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import com.sun.istack.NotNull;



import cl.ulagos.electivo2.ping.entity.EspecificacionFusibles;
import cl.ulagos.electivo2.ping.entity.Fusibles;
import cl.ulagos.electivo2.ping.entity.Marca;
import jakarta.validation.Valid;

@Path("Fusibles")
public class FusiblesResources {

	@Inject
	CreaFusibles creaFusibles;
	
	@Context
	UriInfo uriInfo;
	
	
	@GET
	public JsonArray obtenerFusibles(@NotNull @QueryParam("filter") Marca marca){
		
		return creaFusibles.obtenerFusibles()
		.stream()
		.map(c->Json.createObjectBuilder()
				.add("Marca", c.getMarca().name())
				.add("Tamano", c.getTamano().name())
				.add("id", c.getMarca().name())
				.add("test", "valor")
				.build())
		.collect(JsonCollectors.toJsonArray());

	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearFusibles(@Valid @NotNull EspecificacionFusibles especificacionfusibles) throws SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		Fusibles fusibles = creaFusibles.creaFusibles(especificacionfusibles);
		
		URI uri = uriInfo.getBaseUriBuilder()
				.path(FusiblesResources.class)
				.path(FusiblesResources.class, "obtenerFusible")
				.build(fusibles.getIdentificador());
		
		return Response.created(uri).build();	
	}

	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Fusibles obtenerFusible(@PathParam("id") String identificador) {
		
		return creaFusibles.obtenerFusibles(identificador);
	}
	
	
}
