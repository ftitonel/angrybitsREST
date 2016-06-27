package br.com.angrybits.ABSIM.persistence;

import br.com.angrybits.ABSIM.entity.Consumo;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.util.Beans;

@PersistenceController
public class ConsumoDAO extends JPACrud<Consumo, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ConsumoDAO getInstance() {
        return Beans.getReference(ConsumoDAO.class);
    }

}
