package rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;


import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "postfilme")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostFilmes {
	
	private int id;
	private int idautor;
	private String topico;
	private String descricao;
	private int idcategoria;
	
	public PostFilmes() {
		
	}
	
	public PostFilmes(int id, int idautor,  String topico, String descricao, int idcategoria) {
		super();
		this.id = id;
		this.idautor = idautor;
		this.idcategoria = idcategoria;
		this.topico = topico;
		this.descricao = descricao;
	}
		
	@Override
	public String toString() {
		return "PostFilmes [id=" + id + ", idAutor=" + idautor + ", topico=" + topico + ", descricao=" + descricao
				+ "]";
	}

	public int getIdAutor() {
		return idautor;
	}

	public void setIdAutor(int idAutor) {
		this.idautor = idAutor;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	

}
