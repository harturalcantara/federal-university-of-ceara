/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author hartu
 */
public class SistemasUtils {
    
    int m = 2;
    int n = 2;
    public double [][] mat;
    
    public SistemasUtils() {}
        
    public SistemasUtils(int coluna,int linha) {
            this.m = coluna;
            this.n = linha;
            mat = new double[coluna][linha];
    }
    
    public static SistemasUtils geraMatriz(SistemasUtils matriz, double elementos) {
        SistemasUtils A = matriz;
        for(int i = 0; i < A.getM(); i++ ) {
                for(int j = 0; j < A.getN(); j++) {
                    A.mat[i][j] = elementos;
                }
        }
        return  A;
    }
	
    public void mostraMatriz(SistemasUtils m){
        for(int i = 0; i < m.mat.length; i++) {
            for(int j = 0; j < m.mat.length; j++) {
                System.out.print(m.mat[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    public int getM() {
            return m;
    }
    public int getN() {
            return n;
    }
}
