package br.com.angrybits.ABSIM.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@Entity
public class ConsumoChamadas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date dt_inicio;	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date dt_fim;
	private String numero_destino;
	private String numero_origem;
	private Integer duracao;
	private String label;
	private Integer numero_linha;
	@ManyToOne
	@JoinColumn(name="consumo_id")
	private Consumo consumo;
	
	public ConsumoChamadas() {
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
		ConsumoChamadas other = (ConsumoChamadas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public Date getDt_inicio() {
		return dt_inicio;
	}



	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}



	public Date getDt_fim() {
		return dt_fim;
	}



	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}



	public String getNumero_destino() {
		return numero_destino;
	}



	public void setNumero_destino(String numero_destino) {
		this.numero_destino = numero_destino;
	}



	public String getNumero_origem() {
		return numero_origem;
	}



	public void setNumero_origem(String numero_origem) {
		this.numero_origem = numero_origem;
	}



	public Integer getDuracao() {
		return duracao;
	}



	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public Integer getNumero_linha() {
		return numero_linha;
	}



	public void setNumero_linha(Integer numero_linha) {
		this.numero_linha = numero_linha;
	}



	public Consumo getConsumo() {
		return consumo;
	}



	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}



	public Long getId() {
		return id;
	}

	//GETTERS AND SETTERS
	
}
