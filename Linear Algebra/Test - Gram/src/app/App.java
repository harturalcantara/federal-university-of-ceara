package app;

import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;
import java.util.ArrayList;
import javax.swing.SpringLayout;

public class App {
    
    
    
    /*
I should do Uk = (Vk - (Uk-1*Vk)*Uk-1 - ... - (U1*Vk)*Uk1)/||Uk|| 
Where ||Uk|| = Length of Uk

Vectors U own to finalArray and the V ones own to array 
*/
public  ArrayList< double[] > gramSchmidt(ArrayList< double[] > array) {
    
    
    ArrayList< double[] > finalArray;
    finalArray = new ArrayList();

    //I set the first vector because it never changes, it's always the first vector of the array receive divided between it's length
    finalArray.add(multiplyScalarPerVector(1/(calculateVectorLength(array.get(0))), array.get(0)));
    //This last line is the one that modifies EVERYTHING in array and it shouldn't

    for(int i=1; i<array .size(); i++)
    {
        double[] newVector = substractVectors(array .get(i), proyection(finalArray.get(i-1),array .get(i)));
        for(int e=i-1;e>0;e--) {
            
            newVector= substractVectors(newVector, proyection(finalArray.get(e-1),array .get(i)));
        
        }
        newVector= multiplyScalarPerVector(1/(calculateVectorLength(newVector)), newVector);
        finalArray.add(newVector);
    }
    return finalArray;
}

//Obtain the (Uk-1*Vk)*Uk-1
public double[] proyection(double[] array1, double[] array2)
{
    double dotProductResult= dotProduct(array1,array2);
    double[] finalVector= multiplyScalarPerVector(dotProductResult, array1);
    return finalVector;
}

//To do Uk-1*Vk //PRTODUTO USUAL DOS VETORES 
public double dotProduct(double[] vector1, double[] vector2)
{
    double result = 0;
    for(int i=0; i<vector1.length; i++)
    {
        result +=vector1[i]*vector2[i];
    }
    return result ;
}

/*MULTIPICAO DE UM VETOR POR UM ESCALAR*/
public double[] multiplyScalarPerVector(double scalar, double[] vector)
{
    double[] newVector = new double[vector.length];
    for(int i=0; i<vector.length; i++)
    {
        newVector[i] = scalar*vector[i];
    }
    return newVector;
}


/*SUBTRACAO DE VETORES.*/
public double[] substractVectors(double[] vector1, double[] vector2)
{
    double[] finalVector= new double[vector1.length];
    for(int i=0; i<vector1.length; i++)
    {
        finalVector[i] = vector1[i] - vector2[i];
    }
    return finalVector;
}

    //Calculate the euclidean distance /*CALCULA O MODULO DO VETOR*/
    public double calculateVectorLength(double[] vector)
    {
        double result = 0;
        for(int i=0; i<vector.length; i++)
        {
            result +=Math.pow(vector[i], 2);
        }
        return Math.sqrt(result );
    }
    
    public static void main(String[] args){
    
        double []vetor = new double[3];
        vetor[0] = 1;
        vetor[1] = 0;
        vetor[2] = 1;
        
        ArrayList< double[] > finalArray;
        finalArray = new ArrayList();
        
        finalArray.add(vetor);
        finalArray.add(vetor);
        finalArray.add(vetor);
        
        App d = new App();
        
        finalArray = d.gramSchmidt(finalArray);
        
        for(double[] x : finalArray){
            for(int i=0; i< x.length;i++)
                System.out.println(x[i]);
            System.out.println("");
        }
    
    }
}
