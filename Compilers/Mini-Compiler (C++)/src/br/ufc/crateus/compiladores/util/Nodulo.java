package br.ufc.crateus.compiladores.util;
import br.ufc.crateus.compiladores.analisador_lexico.*;
public class Nodulo {
    public Token raiz;   //raiz
    public Nodulo esq;   //folha esquerda
    public Nodulo dir;   //folha direita
    
    public Nodulo(Token raiz){
        esq = null;
        this.raiz = raiz;
        dir = null;
    }
    
    public Nodulo(Token raiz, Nodulo esquerda, Nodulo direita){
        esq = esquerda;
        this.raiz = raiz;
        dir = direita;
    }
}
