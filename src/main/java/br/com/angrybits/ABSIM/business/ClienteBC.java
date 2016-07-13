package br.com.angrybits.ABSIM.business;

import java.util.List;

import br.com.angrybits.ABSIM.entity.Cliente;
import br.com.angrybits.ABSIM.persistence.ClienteDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
@Transactional
public class ClienteBC extends DelegateCrud<Cliente, Long, ClienteDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Cliente> findByEmail(String email){		
		try {
			return ClienteDAO.getInstance().findByEmail(email);
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

}
