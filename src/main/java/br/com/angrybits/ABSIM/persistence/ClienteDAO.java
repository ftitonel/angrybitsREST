package br.com.angrybits.ABSIM.persistence;

import br.com.angrybits.ABSIM.entity.Cliente;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@PersistenceController
@Transactional
public class ClienteDAO extends JPACrud<Cliente, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
