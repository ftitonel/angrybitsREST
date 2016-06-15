package br.com.angrybits.ABSIM.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("consumo")
public class AngrybitsREST{
	
	@POST
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response inserir(@Context UriInfo uriInfo){
		String id = "OK";
		URI location = uriInfo.getRequestUriBuilder().path(id).build();
		System.out.println("Recebendo dados");
		return Response.created(location).entity(id).build();
	}

}