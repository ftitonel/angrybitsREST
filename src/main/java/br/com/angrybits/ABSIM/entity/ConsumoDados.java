package br.com.angrybits.ABSIM.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConsumoDados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	
	private Date dtInicio;	
	private Date dtFim;
	private String nomeApp;
	private float download;
	private float upload;
	private Integer rede;
	private Integer idApp;
	
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

	//GETTERS AND SETTERS	
	public Long getId() {
		return id;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public String getNomeApp() {
		return nomeApp;
	}

	public void setNomeApp(String nomeApp) {
		this.nomeApp = nomeApp;
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

	public Integer getIdApp() {
		return idApp;
	}

	public void setIdApp(Integer idApp) {
		this.idApp = idApp;
	}
}
