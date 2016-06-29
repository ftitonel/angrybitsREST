package br.com.angrybits.ABSIM.rest;

import java.net.URI;
import java.sql.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.angrybits.ABSIM.business.ConsumoDadosBC;
import br.com.angrybits.ABSIM.entity.ConsumoDados;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("consumo")
public class AngrybitsREST{	
		
	@Inject
	private ConsumoDadosBC consumoBC;
	
	@POST
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response inserir(ConsumoBody body, @Context UriInfo uriInfo){		
		ConsumoDados consumo = new ConsumoDados();
		consumo.setDtInicio(body.dt_inicio);
		consumo.setDtFim(body.dt_fim);
		consumo.setNomeApp(body.nome_app);
		consumo.setDownload(body.download);
		consumo.setUpload(body.upload);
		consumo.setRede(body.rede);
		consumo.setIdApp(body.id_app);
		
		String id = consumoBC.insert(consumo).getId().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();
		return Response.created(location).entity(id).build();
	}
	
	public static class ConsumoBody{
		
		public Date dt_inicio;
		public Date dt_fim;
		public String nome_app;
		public float download;
		public float upload;
		public Integer rede;
		public Integer id_app;
		
	}

}