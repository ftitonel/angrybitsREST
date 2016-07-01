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

import br.com.angrybits.ABSIM.business.ConsumoBC;
import br.com.angrybits.ABSIM.business.ConsumoDadosBC;
import br.com.angrybits.ABSIM.entity.Consumo;
import br.com.angrybits.ABSIM.entity.ConsumoChamadas;
import br.com.angrybits.ABSIM.entity.ConsumoDados;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("consumo")
public class AngrybitsREST{	
		
	@Inject
	private ConsumoBC consumoBC;
	
	@POST
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")	
	public Response inserir(ConsumoBody body, @Context UriInfo uriInfo){	
		String id;
		Consumo consumo = new Consumo();
		
		consumo.setDataConsumo(new Date(System.currentTimeMillis()));
		
//		for(ConsumoDados cd : body.dados){
//			cd.setConsumo(consumo);
//		}
//		for(ConsumoChamadas cc : body.chamadas){
//			cc.setConsumo(consumo);
//		}
		
		consumo.setConsumoDados(body.dados);
		consumo.setConsumoChamdas(body.chamadas);
		
		//RESPOSTA PARA CLIENTE
		id = consumoBC.insert(consumo).getConsumo_id().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();		
		return Response.created(location).entity(id).build();
	}
	
	public static class ConsumoBody{
		
		public Date dataConsumo;
		public List<ConsumoDados> dados;
		public List<ConsumoChamadas> chamadas;
		
	}	
	

}