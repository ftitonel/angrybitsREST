package br.com.angrybits.ABSIM.persistence;

import br.com.angrybits.ABSIM.entity.Token;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class TokenDAO  extends JPACrud<Token, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
