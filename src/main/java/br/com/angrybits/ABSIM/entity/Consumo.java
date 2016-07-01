package br.com.angrybits.ABSIM.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	private Long consumo_id;
	private Date dataConsumo;
	
	
	@OneToMany	(mappedBy="consumo", cascade=CascadeType.PERSIST)
	private List<ConsumoDados> consumoDados;
	
	@OneToMany	(mappedBy="consumo", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<ConsumoChamadas> consumoChamdas;
	
	public Consumo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consumo_id == null) ? 0 : consumo_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumo other = (Consumo) obj;
		if (consumo_id == null) {
			if (other.consumo_id != null)
				return false;
		} else if (!consumo_id.equals(other.consumo_id))
			return false;
		return true;
	}
	//GETTERS AND SETTERS
	public Long getConsumo_id() {
		return consumo_id;
	}
	
	public Date getDataConsumo() {
		return dataConsumo;
	}
	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	public List<ConsumoDados> getConsumoDados() {
		return consumoDados;
	}
	public void setConsumoDados(List<ConsumoDados> consumoDados) {
		for(ConsumoDados cd : consumoDados){
			cd.setConsumo(this);
		}		
		this.consumoDados = consumoDados;
	}
	public List<ConsumoChamadas> getConsumoChamdas() {
		return consumoChamdas;
	}
	public void setConsumoChamdas(List<ConsumoChamadas> consumoChamdas) {
		for(ConsumoChamadas cc : consumoChamdas){
			cc.setConsumo(this);
		}
		this.consumoChamdas = consumoChamdas;
	}
}
