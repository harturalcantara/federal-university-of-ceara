package br.ufc.crateus.aps.trabalhofinal;

import java.util.ArrayList;

import java.util.List;



public class Fidelizacao {
	private List<Invoker> pessoas;

	public Fidelizacao() {
		pessoas = new ArrayList<>();
	}

	public void add(Invoker p) {

		pessoas.add(p);
	}

	public void ListaFuncionarios() {
		System.out.println("*****Lista de Funcionarios*****");
		for (Invoker p : pessoas) {

			p.imprimirFuncionarios();

			// System.out.println("Pessoa Funcao : "+p.getPessoaFisica().getNome());

		}
	}

	public void ListaClientes() {

		System.out.println("*****Lista de Clientes*****");
		for (Invoker p : pessoas) {
			p.imprimirClientes();
		}

	}
	public void funcionariosEClientes(){
		System.out.println("*****Lista de Clientes & Funcionarios*****");
		for(Invoker e : pessoas) {
			e.imprimirTodos();
			
		}
	}
	public void Acao() {

			pessoas.iterator().next().Acao();
		
	}

}
