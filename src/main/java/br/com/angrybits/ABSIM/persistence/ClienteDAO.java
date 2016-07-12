package br.com.angrybits.ABSIM.persistence;

import javax.persistence.Query;

import br.com.angrybits.ABSIM.entity.Cliente;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;

@PersistenceController
@Transactional
public class ClienteDAO extends JPACrud<Cliente, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ClienteDAO getInstance() {
        return Beans.getReference(ClienteDAO.class);
	}

	public Cliente findByEmail(String email) {		
		String hql = "SELECT Cliente FROM Cliente cliente WHERE cliente.usuario_email=:usuario_email";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("usuario_email", email.trim());
		query.setMaxResults(1);
		Cliente cliente = (Cliente) query.getSingleResult();
		return cliente;
	}

}
