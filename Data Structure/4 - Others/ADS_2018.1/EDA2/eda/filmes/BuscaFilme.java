package br.ufc.crateus.eda.filmes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BuscaFilme {
	/*
	private TST<String> dicionario;

	public BuscaFilme(String arquivo) {
		dicionario = construirDicionario(arquivo);
	}

	public TST<String> construirDicionario(String arquivo) {
		TST<String> dicionario = new TST<>();
		String palavraRE = "^([^(]+)";
		Pattern palavraPT = Pattern.compile(palavraRE);
		Matcher matcher;
		String linha;
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			while ((linha = br.readLine()) != null) {
				matcher = palavraPT.matcher(linha);
				if (matcher.find() && !dicionario.contains(matcher.group(1))) {
					str = StringUtils.stripAccents(matcher.group(1).toLowerCase().trim());
					dicionario.put(str.replaceAll("[^a-z0-9 ]", "?"), "");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(dicionario.keys());
		return dicionario;
	}

	public void buscar(String string) {
		Iterable<String> res1 = dicionario.keysWithPrefix(string);
		//Iterable<String> res2 = dicionario.keysThatMatch(string+".......");
		String res3 = dicionario.longestPrefixOf(string);
		System.out.println(" -- keys with prefix " + string + ":");
		System.out.println(res1);
		System.out.println(" -- keys that match " + string + " + 7 curingas:");
		System.out.println(res2);
		System.out.println(" -- longets key with prefix " + string + ":");
		System.out.println(res3);
	}

	public static void main(String[] args) {
		BuscaFilme busca = new BuscaFilme(args[1]);
		busca.buscar(args[0]);
		*/
	}