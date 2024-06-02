package rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String nomecompleto;
	private String endereco;
	private String cidade;
	private String estado;
	private String pais;
	
	public User(int id, String username, String password, String email, String nomecompleto, String endereco,
			String cidade, String estado, String pais) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nomecompleto = nomecompleto;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}


	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", nomecompleto=" + nomecompleto + ", endereco=" + endereco + ", cidade=" + cidade + ", estado="
				+ estado + ", pais=" + pais + "]";
	}
	
	public User() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNomecompleto() {
		return nomecompleto;
	}


	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}
		


}
