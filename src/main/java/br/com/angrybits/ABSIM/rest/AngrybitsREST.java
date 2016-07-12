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

import br.com.angrybits.ABSIM.business.ClienteBC;
import br.com.angrybits.ABSIM.business.ConsumoBC;
import br.com.angrybits.ABSIM.entity.Cliente;
import br.com.angrybits.ABSIM.entity.Consumo;
import br.com.angrybits.ABSIM.entity.ConsumoChamadas;
import br.com.angrybits.ABSIM.entity.ConsumoDados;
import br.com.angrybits.ABSIM.entity.Token;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("consumo")
public class AngrybitsREST{	
		
	@Inject
	private ConsumoBC consumoBC;
	@Inject
	private ClienteBC clienteBC;
	
	@POST
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")	
	public Response inserir(ConsumoBody body, @Context UriInfo uriInfo){	
		String id="";	
		
		Consumo consumo = new Consumo();
		Cliente cliente = new Cliente();
				
		cliente.setTipo_usuario("Fisica");
		cliente.setUsuario_celular(body.usuario.get(0).getUsuario_celular());
		cliente.setUsuario_email(body.usuario.get(0).getUsuario_email());		
		cliente.setToken(body.token.get(0));
		
		consumo.setDataConsumo(new Date(System.currentTimeMillis()));
		consumo.setConsumoDados(body.dados);
		consumo.setConsumoChamdas(body.chamadas);
		consumo.setCliente(cliente);
				
		clienteBC.insert(cliente);
		
		//RESPOSTA PARA CLIENTE
		id = consumoBC.insert(consumo).getConsumo_id().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();		
		return Response.created(location).entity(id).build();
	}
	
	public static class ConsumoBody{
		
		public Date dataConsumo;
		public List<ConsumoDados> dados;
		public List<ConsumoChamadas> chamadas;
		public List<Token> token;
		public List<Cliente> usuario;
	}	
	

}