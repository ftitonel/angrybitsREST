package br.com.angrybits.ABSIM.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ConsumoDados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private Date dt_inicio;	
	private Date dt_fim;
	private String nome_app;
	private float download;
	private float upload;
	private Integer rede;
	private Integer id_app;
	
	@ManyToOne
	@JoinColumn(name="consumo_id", nullable = false, updatable = true, insertable = true)
	private Consumo consumo;
	
	public ConsumoDados() {
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
		ConsumoDados other = (ConsumoDados) obj;
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


	public String getNome_app() {
		return nome_app;
	}


	public void setNome_app(String nome_app) {
		this.nome_app = nome_app;
	}


	public float getDownload() {
		return download;
	}


	public void setDownload(float download) {
		this.download = download;
	}


	public float getUpload() {
		return upload;
	}


	public void setUpload(float upload) {
		this.upload = upload;
	}


	public Integer getRede() {
		return rede;
	}


	public void setRede(Integer rede) {
		this.rede = rede;
	}


	public Integer getId_app() {
		return id_app;
	}


	public void setId_app(Integer id_app) {
		this.id_app = id_app;
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
