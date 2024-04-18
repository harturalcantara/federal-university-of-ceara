http://www.cs.utoronto.ca/~brudno/csc373w09/midterm-solutions.pdf
https://web.cs.dal.ca/~whidden/CS3110/assignments/a5_solution.pdf
https://www.coursehero.com/file/p3bpsej/Problem-2-25-points-A-server-has-n-customer-waiting-to-be-served-The-service/


//(prioriedade)
https://web.cs.wpi.edu/~cs2223/d08/Exams/Exam2/


/*
Solução 1:
/ * Vou usar uma fila de prioridades PQ para armazenar os clientes, usando seus
valor da duração como sua chave. * /
                                               Instrução #Iterações Total
{
  StartHeap (PQ) O (1)
  Para cada i: = 1 para n fazer {O (1) * n = O (n)
      Inserir cliente i com duração chave [i] em PQ O (log (n)) * n = O (nlog (n))
  }
  tempo: = 0 O (1)
  Para cada i: = 1 para n fazer {O (1) * n = O (n)
     nextcustomer: = ExtractMin (PQ) O (log (n)) * n = O (nlog (n))
     start-of-service [nextcustomer]: = tempo O (1) * n = O (n)
     tempo: = tempo + duração [próximo cliente] O (1) * n = O (n)
  }
}      
                                                                        -----------
                               T (n) = 2 * O (1) + 4 * O (n) + 2 * O (nlog (n)) = O (nlog (n))
Solução 2:
/ * Uma solução alternativa pode ser construída similarmente pela classificação dos clientes
em ordem crescente pelo tempo de duração, usando uma ordenação O (nlog (n))
algoritmo, como o mergesort. Cuidados devem ser tomados para manter o controle do original
número do cliente, de modo que o início do serviço de saída [i] corresponda
ao tutor original i. Para isso, vou usar um array
name_duration_array [1 ... n] que armazena em cada uma de suas células um
objeto (par) que consiste em duas partes: (1) o número do cliente, e 
(2) seu tempo de duração.

                                               Instrução #Iterações Total
{
  Para cada i: = 1 para n fazer {O (1) * n = O (n)
      name_duration_array [i]: = (i, duração [i]) O (1) * n = O (n)
  }
  Use o mergesort para classificar name_duration_array [1 ... n] O (nlog (n))
  em ordem crescente de acordo com o segundo componente 
  do par em cada célula (ou seja, duração)

  tempo: = 0 O (1)
  Para cada k: = 1 para n fazer {O (1) * n = O (n)
     Seja o nome_duration_array [k] = (i, duração [i]) O (1) * n = O (n)
     start-of-service [i]: = hora O (1) * n = O (n)
     tempo: = tempo + duração [i] O (1) * n = O (n)
  }
}      
                                                                        -----------
                                   T (n) = O (1) + 6 * O (n) + * O (nlog (n)) = O (nlog (n))
*/