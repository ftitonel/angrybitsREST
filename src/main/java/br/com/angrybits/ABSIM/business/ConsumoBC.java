package br.com.angrybits.ABSIM.business;

import br.com.angrybits.ABSIM.entity.Consumo;
import br.com.angrybits.ABSIM.persistence.ConsumoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ConsumoBC extends DelegateCrud<Consumo, Long, ConsumoDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
