package br.ufc.crateus.lab10;

import java.util.HashMap;
import java.util.Map;

public class TestaMapa {

	public static void main(String[] args) {
		Conta c1 = new ContaCorrente(2 , 200.0);
		c1.deposita(10000);
		
		Conta c2 = new ContaCorrente(2 , 200.0);
		c2.deposita(3000);
		
		//cria mapa
		Map<String , Conta> mapaDeContas = new HashMap<>();
		
		//adiciona duas chaves e seus valores
		mapaDeContas.put("diretor", c1);
		mapaDeContas.put("gerente", c2);
		
		//qual a conta do diretor?
		Conta contaDoDiretor = mapaDeContas.get("diretor");
		System.out.println(contaDoDiretor.getSaldo());

	}

}
