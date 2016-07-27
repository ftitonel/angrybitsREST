package br.com.angrybits.angrybitsrest.rest;

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

import br.com.angrybits.angrybitsCore.business.ClienteBC;
import br.com.angrybits.angrybitsCore.business.ConsumoBC;
import br.com.angrybits.angrybitsCore.entity.Cliente;
import br.com.angrybits.angrybitsCore.entity.Consumo;
import br.com.angrybits.angrybitsCore.entity.ConsumoChamadas;
import br.com.angrybits.angrybitsCore.entity.ConsumoDados;
import br.com.angrybits.angrybitsCore.entity.Token;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("consumo")
public class AngrybitsREST {

	@Inject
	private ConsumoBC consumoBC;
	@Inject
	private ClienteBC clienteBC;

	@POST
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response inserir(ConsumoBody body, @Context UriInfo uriInfo) {
		String id = "";
		if(clienteBC.findAll().size()<=0){
			Cliente cliente1 = new Cliente("felipe.titonel@gmail.com", "(85)999383404", "PF", null, null);
			Cliente cliente2 = new Cliente("tamara@gmail.com", "(71)999647153", "PF", null, null);
			Cliente cliente3 = new Cliente("thadeu@gmail.com", "(88)912344321", "PF", null, null);
			clienteBC.insert(cliente1);
			clienteBC.insert(cliente2);
			clienteBC.insert(cliente3);
		}
		
		List<Cliente> clientes = clienteBC.findByEmail(body.usuario.get(0).getUsuario_email());
		Cliente cliente = clientes.get(0);
		Consumo consumo = new Consumo();

		Date dataAtual = new Date(System.currentTimeMillis());
		Token token = new Token();

		token = body.token.get(0);
		 token.setDataAtualizacao(dataAtual);
		 
		 if(cliente.getToken()==null){
			 cliente.setToken(token);
		 }else{
			 cliente.getToken().setToken(token.getToken());
			 cliente.getToken().setDataAtualizacao(dataAtual);
		 }
			 
		 
		 
		 clienteBC.update(cliente);

		consumo.setDataConsumo(dataAtual);
		consumo.setConsumoDados(body.dados);
		consumo.setConsumoChamdas(body.chamadas);
		consumo.setCliente(clientes.get(0));

		// RESPOSTA PARA CLIENTE
		//id = "1";
		 id = consumoBC.insert(consumo).getConsumo_id().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();
		return Response.created(location).entity(id).build();
	}

	public static class ConsumoBody {

		public Date dataConsumo;
		public List<ConsumoDados> dados;
		public List<ConsumoChamadas> chamadas;
		public List<Token> token;
		public List<Cliente> usuario;
	}

}