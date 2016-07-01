package br.com.angrybits.ABSIM.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Consumo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date dataConsumo;
	
	@OneToMany(mappedBy="consumo", cascade=CascadeType.ALL )
	private List<ConsumoDados> consumoDados;
	
	@OneToMany(mappedBy="consumo", cascade=CascadeType.ALL)
	private List<ConsumoChamadas> consumoChamdas;
	
	public Consumo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
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
		this.consumoDados = consumoDados;
	}
	public List<ConsumoChamadas> getConsumoChamdas() {
		return consumoChamdas;
	}
	public void setConsumoChamdas(List<ConsumoChamadas> consumoChamdas) {
		this.consumoChamdas = consumoChamdas;
	}
}
