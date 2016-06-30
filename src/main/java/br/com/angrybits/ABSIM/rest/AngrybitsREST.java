package br.com.angrybits.ABSIM.rest;

import java.net.URI;
import java.sql.Date;
import java.util.List;

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
		String id = "";
		for(Consumo cons : body.dados ){
		ConsumoDados consumo = new ConsumoDados();
		consumo.setDtInicio(cons.dt_inicio);
		consumo.setDtFim(cons.dt_fim);
		consumo.setNomeApp(cons.nome_app);
		consumo.setDownload(cons.download);
		consumo.setUpload(cons.upload);
		consumo.setRede(cons.rede);
		consumo.setIdApp(cons.id_app);		
		id = consumoBC.insert(consumo).getId().toString();		
		}
		URI location = uriInfo.getRequestUriBuilder().path(id).build();		
		return Response.created(location).entity(id).build();
	}
	
	public static class ConsumoBody{
		public List<Consumo> dados;
	}
	
	public static class Consumo{
		
		public Date dt_inicio;
		public Date dt_fim;
		public String nome_app;
		public float download;
		public float upload;
		public Integer rede;
		public Integer id_app;
		
	}

}