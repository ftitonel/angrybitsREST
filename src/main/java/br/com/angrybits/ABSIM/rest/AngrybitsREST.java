package br.com.angrybits.ABSIM.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.angrybits.ABSIM.business.ConsumoBC;
import br.com.angrybits.ABSIM.entity.Consumo;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("consumo")
public class AngrybitsREST{
	
	@Inject
	ConsumoBC consumoBC;
	
	@POST
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response inserir(ConsumoBody body, @Context UriInfo uriInfo){		
		Consumo consumo = new Consumo();
		consumo.setConsumo(body.consumo);
		
		String id = consumoBC.insert(consumo).getId().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();
		return Response.created(location).entity(id).build();
	}
	
	public static class ConsumoBody{
		
		public String consumo;
		
	}

}