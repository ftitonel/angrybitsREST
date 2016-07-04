package br.com.angrybits.ABSIM.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String usuario_email;
	private String  usuario_celular;
	private String tipo_usuario;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany	(mappedBy="cliente")
	private List<Consumo> consumo;
	
	
	
	
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//GETTERS AND SETTERS
	public String getUsuario_email() {
		return usuario_email;
	}
	public void setUsuario_email(String usuario_email) {
		this.usuario_email = usuario_email;
	}
	public String getUsuario_celular() {
		return usuario_celular;
	}
	public void setUsuario_celular(String usuario_celular) {
		this.usuario_celular = usuario_celular;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public Long getId() {
		return id;
	}
	public List<Consumo> getConsumo() {
		return consumo;
	}
	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}
	
	
}
