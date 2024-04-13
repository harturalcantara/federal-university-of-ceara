package br.ufc.crateus.aps.trabalhofinal;



import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;
import br.ufc.crateus.aps.trabalhofinal.fornecedores.CoffeOfProviders;

public class FranquiaDeCafe {

	private String cnpj;
	private String registro;
	private String razaoSocial;
	private String nomeFantasia;
	private double latitude;
	private double longitude;
	private String endereco;
	private String telefone;
	private ListDonos donos;
	private CoffeOfProviders fornecedores;
	private List<Coffee> tiposDeCafe;
	private Fidelizacao fidelizacao;
	private double total = 0;
	// private double totaTipoCafe = 0;

	private FranquiaDeCafe(Builder builder) {
		super();
		this.cnpj = builder.cnpj;
		this.registro = builder.registro;
		this.razaoSocial = builder.razaoSocial;
		this.nomeFantasia = builder.nomeFantasia;
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
		this.endereco = builder.endereco;
		this.telefone = builder.telefone;
		this.donos = builder.donos;
		this.fidelizacao = builder.fidelizacao;
		this.fornecedores = builder.fornecedores;
		this.total = fornecedores.total();
		
		for(Coffee e : fornecedores.getCoffee()) {
			
			e.setPreco(e.getPreco()*2);
			
			builder.tiposDeCafe(e);
		
			
		}

		this.tiposDeCafe = builder.tiposDeCafe;



	}

	public double lucroDoFraquia() {
		
		return 0;
	}

	@Override
	public String toString() {
		return "FraquiaDeCafe [cnpj : " + cnpj + ",\n registro : " + registro + ", \n razaoSocial : " + razaoSocial
				+ ",\n nomeFantasia : " + nomeFantasia + ",\n latitude : " + latitude + ",\n longitude : " + longitude
				+ ",\n endereco : " + endereco + ",\n telefone : " + telefone + ",\n donos : " + donos
				+ ",\n fornecedores : " + fornecedores + ",\n tiposDeCafé : " + tiposDeCafe + "]";
	}

	static class Builder {
		private String cnpj;
		private String registro;
		private String razaoSocial;
		private String nomeFantasia;
		private double latitude;
		private double longitude;
		private String endereco;
		private String telefone;
		private ListDonos donos;
		private CoffeOfProviders fornecedores;
		private List<Coffee> tiposDeCafe;
		private Fidelizacao fidelizacao;
	

		public Builder(String cnpj, String registro, String razaoSocial, String nomeFantasia) {
			this.cnpj = cnpj;
			this.registro = registro;
			this.razaoSocial = razaoSocial;
			this.nomeFantasia = nomeFantasia;
			tiposDeCafe = new ArrayList<>();
			// tiposDeCafé(fornecedores.getCoffee());

		}

		public Builder latitude(double latitude) {

			this.latitude = latitude;
			return this;
		}

		public Builder fidelizacao(Fidelizacao fidelizacao) {
			this.fidelizacao = fidelizacao;
			return this;
		}

		public Builder longitude(double longitude) {
			this.longitude = longitude;
			return this;
		}

		public Builder endereco(String endereco) {
			this.endereco = endereco;
			return this;

		}

		public Builder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public Builder fornecedores(CoffeOfProviders fornecedores) {
			
			this.fornecedores = fornecedores;
			return this;
		}

		public Builder tiposDeCafe(Coffee tiposDeCafe) {
			
			this.tiposDeCafe.add(tiposDeCafe.clone());
			this.tiposDeCafe.add(tiposDeCafe);
			return this;
		}

		public Builder donos(ListDonos donos) {
			this.donos = donos;
			return this;
		}

		public FranquiaDeCafe getBuilder() {
			return new FranquiaDeCafe(this);
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRegistro() {
		return registro;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public ListDonos getDonos() {
		return donos;
	}

	public CoffeOfProviders getFornecedores() {
		return fornecedores;
	}

	public List<Coffee> getTiposDeCafe() {
		return tiposDeCafe;
	}

	public Fidelizacao getFidelizacao() {
		return fidelizacao;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDonos(ListDonos donos) {
		this.donos = donos;
	}

	public void setFornecedores(CoffeOfProviders fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void setTiposDeCafe(List<Coffee> tiposDeCafe) {
		this.tiposDeCafe = tiposDeCafe;
	}

	public void setFidelizacao(Fidelizacao fidelizacao) {
		this.fidelizacao = fidelizacao;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double lucroDafranquia() {
		return (fornecedores.total() - total);
	}

	public void imprimir() {
		System.out.println("Nome da fraquia : " + nomeFantasia);
		System.out.println("Registrador : " + registro);
		System.out.println("CNPJ : " + cnpj);
		System.out.println("Endereco : " + endereco);
		System.out.println("Razao social : " + razaoSocial);
		System.out.println("Lucro da franquia : " + this.lucroDafranquia()+" R$");
	}
}
