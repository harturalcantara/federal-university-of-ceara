package br.ufc.crateus.compiladores.analisador_sematico;

import java.util.LinkedList;

import br.ufc.crateus.compiladores.analisador_lexico.Token;
import br.ufc.crateus.compiladores.exception.NovaException;
import br.ufc.crateus.compiladores.util.Nodulo;


public class AnalisadorSemantico {

	private LinkedList<Token> variaveisCharList = new LinkedList<>(); // guarda variáveis STRING
	private LinkedList<Token> variaveisIntList = new LinkedList<>(); // guarda variáveis INT
	private LinkedList<Token> variaveisRealList = new LinkedList<>(); // guarda variáveis FLOAT
    private LinkedList<String> stringExpressoesList  = new LinkedList<>(); //guarda expressões (aritméticas/relacionais)

	private String expressaoAtual = ""; //guarda código de três endereços
    private int cont = 1; //usado nas variáveis temporárias: TMP# + 'cont'
	public AnalisadorSemantico(LinkedList<Token> out_VariaveisSList, LinkedList<Token> out_VariaveisIList,
			LinkedList<Token> out_VariaveisRList) throws NovaException { // construtor

		this.variaveisCharList = out_VariaveisSList;
		this.variaveisIntList = out_VariaveisIList;
		this.variaveisRealList = out_VariaveisRList;

		SEMANTICS_CHECK_ERRO6(variaveisCharList, variaveisRealList);
		SEMANTICS_CHECK_ERRO6(variaveisCharList, variaveisIntList);
		SEMANTICS_CHECK_ERRO6(variaveisCharList, variaveisCharList);
		SEMANTICS_CHECK_ERRO6(variaveisRealList, variaveisIntList);
		SEMANTICS_CHECK_ERRO6(variaveisRealList, variaveisRealList);
		SEMANTICS_CHECK_ERRO6(variaveisIntList, variaveisIntList);
		// observa se as variáveis quebram o ERRO 6, ou seja, se são duplicadas
	}
    public LinkedList<String> SEMANTICS(Nodulo out_exp) throws NovaException{ //retorna código de tres endereços
        String temp = "";
        
        stringExpressoesList.clear();
        if(out_exp.raiz.getId().equals("=")){ //verifica se a expressao é aritmética (TRUE) ou relacional (FALSE)
            temp = temp.concat(out_exp.esq.raiz.getLexema() + " " + out_exp.raiz.getId());
            if(!temFolhas(out_exp.dir)){ //verifica se a folha direita da arvore não tem filhos, indicando uma atribuição simples. Ex: y := 1;
                if(out_exp.dir.raiz.getId().equals("NUMERICO")){
                    temp = temp.concat(" " + out_exp.dir.raiz.getValor());
                }else{
                    temp = temp.concat(" " + out_exp.dir.raiz.getLexema());
                }
                stringExpressoesList.add(temp);
                temp = "";
            }else{ //caso a folha direita da arvore tenha filhos, indica uma atribuição complexa. Ex: y = 1 + (x * 2);
                PercorreArvore(out_exp.dir);
                temp = temp.concat(" TMP#" + Integer.toString(cont - 1));
                stringExpressoesList.add(temp);
                temp = "";
            }
        }else{
            PercorreArvore(out_exp.dir);
                stringExpressoesList.add("Não Faça Para está Variavel TMP#" + Integer.toString(cont - 1) + " O GOTO");
            }
        return stringExpressoesList;
    }
    

	public void SEMANTICS_CHECK_ALL(Token tokenAtual) throws NovaException { // usado para observar erros de semântica
																				// na expressão toda
		boolean variavel_declarada = false;

		for (int i = 0; i < variaveisIntList.size(); i++) {
			if (tokenAtual.getLexema().equals(variaveisIntList.get(i).getLexema())) {
				throw new NovaException("ERRO 3: Tipos incompatíveis, a variavel '" + tokenAtual.getLexema()
						+ "' nao e STRING, linha: " + tokenAtual.getPos());
			}
		}

		for (int i = 0; i < variaveisRealList.size(); i++) {
			if (tokenAtual.getLexema().equals(variaveisRealList.get(i).getLexema())) {
				throw new NovaException("ERRO 3: Tipos incompatíveis, a variavel '" + tokenAtual.getLexema()
						+ "' nao e STRING, linha: " + tokenAtual.getPos());
			}
		}

		for (int i = 0; i < variaveisCharList.size(); i++) {
			if (tokenAtual.getLexema().equals(variaveisCharList.get(i).getLexema())) {
				variavel_declarada = true;
			}
		}

		if (variavel_declarada == false) {
			throw new NovaException("ERRO 4: Variavel '" + tokenAtual.getLexema() + "' nao foi declarada, linha: "
					+ tokenAtual.getPos());
		}
	}

	public void SEMANTICS_CHECK_ERRO3_ERRO4(Token tokenAtual, boolean ehExpressao) throws NovaException { // usado para
																											// observar
																											// ERRO 3 e
																											// 4;
		boolean variavelExiste1 = false;
		boolean variavelExiste2 = false;
		boolean variavelExiste3 = false;

		for (int i = 0; i < variaveisIntList.size(); i++) {
			if (tokenAtual.getLexema().equals(variaveisIntList.get(i).getLexema())) {
				variavelExiste1 = true;
				i = variaveisIntList.size();
			}
		}

		for (int i = 0; i < variaveisCharList.size(); i++) {
			if (tokenAtual.getLexema().equals(variaveisCharList.get(i).getLexema())) {
				variavelExiste2 = true;
				i = variaveisCharList.size();
				if (ehExpressao) {
					throw new NovaException("ERRO 3: Tipos incompativeis, a variavel '" + tokenAtual.getLexema()
							+ "' nao e INT ou FLOAT, linha: " + tokenAtual.getPos());
				}
			}
		}

		for (int i = 0; i < variaveisRealList.size(); i++) {
			if (tokenAtual.getLexema().equals(variaveisRealList.get(i).getLexema())) {
				variavelExiste3 = true;
				i = variaveisRealList.size();
			}
		}

		if ((variavelExiste1 || variavelExiste2 || variavelExiste3) == false) {
			throw new NovaException("ERRO 4: Variavel '" + tokenAtual.getLexema() + "' nao foi declarada, linha: "
					+ tokenAtual.getPos());
		}
	}

	private void SEMANTICS_CHECK_ERRO6(LinkedList<Token> l1, LinkedList<Token> l2) throws NovaException { // usado para
																											// observar
																											// ERRO 6
		boolean temp = true; // usado quando as listas forem iguais
		if (l1 == l2) {
			temp = false;
		}

		for (int i = 0; i < l1.size(); i++) {
			for (int j = 0; j < l2.size(); j++) {
				if (l1.get(i).getLexema().equals(l2.get(j).getLexema()) && temp == true) {
					throw new NovaException("ERRO 6: Variavel '" + l1.get(i).getLexema()
							+ "' declarada em duplicidade, linha: " + l1.get(i).getPos());
				} else if (l1.get(i).getLexema().equals(l2.get(j).getLexema()) && temp == false) {
					temp = true;
				}
			}
			if (l1 == l2) {
				temp = false;
			}
		}
	}
    private void PercorreArvore(Nodulo arvore) { //transforma uma arvore em uma lista de código de três endereços
        if(temFolhas(arvore)){
            if(temFolhas(arvore.esq) || temFolhas(arvore.dir)){
                PercorreArvore(arvore.esq);
                PercorreArvore(arvore.dir);
                PercorreArvore(arvore);
            }else{
                if(!arvore.esq.raiz.getId().equals("NUMERICO")){
                    expressaoAtual = expressaoAtual.concat(arvore.esq.raiz.getLexema());
                }else{
                    expressaoAtual = expressaoAtual.concat(Float.toString(arvore.esq.raiz.getValor()));
                }
                
                expressaoAtual = expressaoAtual.concat(" " + arvore.raiz.getId() + " ");
                
                if(!arvore.dir.raiz.getId().equals("NUMERICO")){
                    expressaoAtual = expressaoAtual.concat(arvore.dir.raiz.getLexema());
                }else{
                    expressaoAtual = expressaoAtual.concat(Float.toString(arvore.dir.raiz.getValor()));
                }
                
                arvore.raiz = new Token(expressaoAtual ,"TMP#" + Integer.toString(cont),arvore.raiz.getPos());
                stringExpressoesList.add(arvore.raiz.getLexema() + " = " + expressaoAtual);
                expressaoAtual = "";
                arvore.esq = null;
                arvore.dir = null;
                cont++;
            }
        }
    }
    
    private boolean temFolhas(Nodulo arvore){ //retorna FALSE se a arvore não tem nenhuma folha; TRUE se tem ao menos uma folha 
        return !(arvore.esq == null && arvore.dir == null);
    }

}
