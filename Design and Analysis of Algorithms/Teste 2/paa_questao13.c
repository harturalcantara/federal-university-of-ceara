

/*
PROPRIEDADE GULOSA

ESCOLHA GULOSA:
    
 1 - Faça a tarefa em um certo dia que contém a maior multa.
 2 - Deixe para fazer a tarefa no dia da dead line (no dia que tem que entregar), e faça aquela que contém a maior multa.
 3 - SE outra tarefa for alocada no mesmo dia em que esta alocada uma dead line 'j', então aloque para trás desse indice 'j' onde tiver uma posicao vaga.
 4 - SE todas as deads lines antes 'j' estiverem lotadas, "lascou" voce tem que pagar a pagar multa (pois não há outro jeito), mas lembre-se de que voce ainda precisa fazer 
   esta tarefa, então faça esta tarefa por ultimo, pois como voce já pagou a multa dela ele perde sua prioriedade(lembra-se que vc tem que fazer ela ainda, pois
   voce recebeu essa tarefa, apesar de ter pago uma multa por ela).

  PROVA: Rennan Aprovou
    [Por absurdo]
   Sejam 'i' uma tarefa que contém a maior multa, e 'j' tarefa que contém menor multa.
   escolha o j por absurdo, se vc escolhe a 'J' q tem a menor multa, e SE vc tiver 1 dia para fazer somente uma tarefa(por exemplo) e existem duas tarefas i e j, 
   SE vc pegar 'j', vc paga a multa de i que é a multa mais car, é um absurdo. (pois supomos que dessa forma pagariamos a menor multa, logo a prpripriedade guloso acima é válida) 
*/




