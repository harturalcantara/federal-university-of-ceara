package br.ufc.crateus.aps.trabalhofinal;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.pessoas.Cliente;
import br.ufc.crateus.aps.trabalhofinal.pessoas.Command;
import br.ufc.crateus.aps.trabalhofinal.pessoas.Pessoa;
import br.ufc.crateus.aps.trabalhofinal.pessoas.PessoaFisica;

public class Invoker {

	List<Command> list;
	List<Pessoa> listDeFuncionario;
	List<Pessoa> listDeCliente;
	int cont = 0;

	public Invoker() {
		list = new ArrayList<>();
		listDeFuncionario = new ArrayList<>();
		listDeCliente = new ArrayList<>();

	}

	public void add(Command c) {
		list.add(c);
	}

	public void imprimirTodos() {
		System.out.println("--------------------------");
		for (Command e : list) {
			System.out.println(e.getPessoa().getNome());
			System.out.println("--------------------------");
		}
	}

	public void addFuncionario(Pessoa funcionario) {
		listDeFuncionario.add(funcionario);
	}

	public void addCliente(Pessoa cliente) {
		listDeCliente.add(cliente);

	}

	protected void imprimirFuncionarios() {
		System.out.println("--------------------------");
		for (Pessoa f : listDeFuncionario) {
			System.out.println("Nome : " + f.getNome());
			System.out.println("CPF : " + ((PessoaFisica) f).getCpf());
			System.out.println("Idade : " + ((PessoaFisica) f).calcularIdade());
			System.out.println("Funcao : " + ((PessoaFisica) f).getFuncao());
			System.out.println("--------------------------");

		}
	}

	public void imprimirClientes() {
		System.out.println("--------------------------");
		for (Pessoa c : listDeCliente) {

			System.out.println("Nome : " + c.getNome());
			System.out.println("Idade : " + c.calcularIdade());
			System.out.println("Sexo : " + ((Cliente) c).getTipo());
			System.out.println("--------------------------");
		}
	}

	public void Acao() {
		for (Command e : list) {
			e.execute();

		}
	}

}
