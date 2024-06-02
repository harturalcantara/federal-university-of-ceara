package rest.model;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;


import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "comfilme")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComFilmes {
	
	private int id;
	private int idautor;
	private int idtopico;
	private String texto;
	
	public ComFilmes() {
		
	}
	
	public ComFilmes(int id, int idautor, int idtopico, String texto) {
		super();
		this.id = id;
		this.idautor = idautor;
		this.idtopico = idtopico;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdautor() {
		return idautor;
	}

	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}

	public int getIdtopico() {
		return idtopico;
	}

	public void setIdtopico(int idtopico) {
		this.idtopico = idtopico;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "ComFilmes [id=" + id + ", idautor=" + idautor + ", idtopico=" + idtopico + ", texto=" + texto + "]";
	}
}

