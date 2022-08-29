package br.ufc.crateus.compiladores.app;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.ufc.crateus.compiladores.analisador_lexico.AnalizadorLexico;
import br.ufc.crateus.compiladores.exception.NovaException;

public class Main {
	
	public static void main(String[] args) throws IOException {
            String nome;
        
        do{
            nome = JOptionPane.showInputDialog("Informe o nome do arquivo de texto:");
            if (nome != null){
                nome = nome.concat(".txt");
                try{
                    AnalizadorLexico sc;
                    sc = new AnalizadorLexico();
                    
                    sc.SCANNER(nome); //chamada ao LÉXICO
                }catch (IOException e){
                    JOptionPane.showMessageDialog(null, "Erro na abertura do arquivo, tente novamente!");
                }catch (NovaException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "Compilação encerrada com erros!");
                }
            }
        }while(nome != null);
		 }
}