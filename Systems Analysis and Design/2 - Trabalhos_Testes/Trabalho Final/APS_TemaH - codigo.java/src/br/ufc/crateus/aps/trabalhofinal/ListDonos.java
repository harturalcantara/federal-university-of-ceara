package br.ufc.crateus.aps.trabalhofinal;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.pessoas.Dono;


public class ListDonos {

	private List<Dono> donos = new ArrayList<>();

	public void addDonos(Dono d) {
		donos.add(d);
	}

	@Override
	public String toString() {
		return "ListDonos [donos=" + donos;
	}

	public void imprimir() {
		System.out.print("Dono(s) : ");
		for (Dono e : donos) {

			System.out.print(e.getNome() + ",");

		}
		System.out.println();

	}

}
