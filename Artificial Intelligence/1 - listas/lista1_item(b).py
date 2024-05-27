''' Indicadores de passagem '''

#Exercicio1

# n = int(input("Digite o valor de n: "))
# i = 0
# impar = 1
# lista = []
# if n > 0:
#     while i < n: 
#         x = int(input("Digite um valor: "))
#         lista.insert(i, x)
#         print(lista[i])
#         i = i + 1
#     i = 0
#     total = 0
#     while i < n:
#         if lista[i] % 2 == 0:
#             total += 1
#         i = i + 1
#     if total == n:
#         print("Sim! Todos os elementos da sequencia sao pares! ")
#     else:
#         print("Nao! A um elemento impar na lista! ")

### Exercicio2

# def isprimo(numero):
#     if numero != 0 & numero != 1:
#         if numero > 3:
#             for i in range(2, numero):
#                 if numero % i == 0:
#                     return False
#         return True
#     return False

# print("E primo" if isprimo(7) else "Nao e primo")

### Exercicio3 - Dado um numero inteiro n > 1, verificar se n tem dois digitos adjacentes iguais.

# n_salvo = n = int(input("Digite um numero: "))

# anterior = n % 10
# n = n // 10;
# adj_iguais = False;
# pos = 0

# while n > 0 and not adj_iguais:
#     atual = n % 10
#     if atual == anterior:
#         adj_iguais = True
#     else:
#         pos += 1
#     anterior = atual
#     n = n // 10

# if adj_iguais:
#     print(n_salvo, "tem dois digitos", atual, "adjacentes")
# else:
#     print(n_salvo, "nao tem digitos iguais adjacentes")


### Exercicio4 - 

# def is_arithmetic(l):
#     delta = l[1] - l[0]
#     for index in range(len(l) - 1):
#         if not (l[index + 1] - l[index] == delta):
#              return False
#     return True

# print(is_arithmetic([5, 7, 9, 11]))
# print(is_arithmetic([5, 8, 9, 11]))

''' Repeticoes encaixadas '''

### EXERCICIO_1

# n = int(input("Digite um numero (>1): "))
# fator = 2 # primeiro fator
# while n != 1:
#     # conta a multiplicidade de fator em n
#     mult = 0;
#     while n%fator == 0:
#         n = n / fator;
#         mult = mult + 1;
#     # imprime a multiplicade do fator
#     if mult != 0:
#         print("fator %d multiplicidade %d" %(fator, mult))
#     fator = fator + 1

### Exercico2 - Dados um numero inteiro n > 0 e uma sequencia com n numeros inteiros maiores
### do que zero, determinar o maximo divisor comum entre eles.

# def main():
#     n = int(input("Digite o tamanho da sequencia (>0): "))
#     mdc_atual = int(input("Digite o 1 numero: "))
#     i = 1
#     while i < n:
#         num = int(input("Digite o %d numero: " %(i+1)))
#         i = i + 1
#         mdc_atual = mdc(mdc_atual,num)
#     print("O mdc eh", mdc_atual)

# def mdc(a,b):
#     mdc = a;
#     while a%mdc != 0 or b%mdc != 0:
#         mdc -= 1
#     return mdc

# main()

### Exercicio3 - Dados um numero inteiro n, n > 0, e uma sequencia com n numeros 
### inteiros maiores do que zero, determinar o fatorial de cada numero da sequencia.

# def main():
#     n = int(input("Digite o tamanho da sequencia (>0): "))
#     i = 0
#     while i < n:
#         num = int(input("Digite o %d numero: " %(i+1)))
#         i = i + 1
#         print ("%d ! = %d" %(num,fatorial(num)))

# def fatorial(k):
#     k_fat = 1
#     i = 2
#     while i <= k:
#         k_fat *= i
#         i += 1
#     return k_fat
# main()

### Exercicio4

# def main():
#     num = int(input("Digite um numero (0 para terminar): "))
#     cont = 0
#     while num != 0:
#         primo = True
#         i = 2
#         while i < num and primo:
#             if num % i == 0:  
#                 primo = False 
#             i += 1
#         if primo:
#             cont += 1
#         num = int(input("Digite um numero (0 para terminar): "))
#     print ("Achei %d primos na sequencia"%(cont))
# main()

### EXERCICIO_5

# n = int(input())
# for i in range(0,n):
#     a = input().split()
#     x,y=a
#     x= int(x)
#     y=int(y)
#     soma = 0
#     j = 1
#     while j <= y:
#         if x % 2 != 0:
#             soma = soma + x
            
#             x = x + 1
#             j = j + 1
#         if x % 2 == 0:
#             x = x + 1
#     print(soma)


### Exercicio6 - Escreva um programa que leia um natural n >0 e imprima todas as tabuadas de 1 ate n.

# num = int(input("Digite um numero (>0): "))
# for i in range(1, num+1):
#    print(num,'x',i,'=',num*i)



''' Numeros reais '''

### Exercicio1

# n = int(input("Digite n: "))
# # Solucao 1: calcula a soma da esquerda para a direita
# H_0aN = 0
# for x in range (1, n+1):
#     H_0aN += 1 / x
# #    print ("Termo %d: 1 / %d = %.10f   H(%d) = %.10f"%(x, x, 1/x, x, H_0aN))

# # Solucao 2: calcula a soma da direita para a esquerda
# H_Na0 = 0
# for x in range(n, 0, -1):
#     H_Na0 += 1 / x
# #    print ("Termo %d: 1 / %d = %.10f   H(%d) = %.10f"%(x, x, 1/x, x, H_Na0))

# print("De 0 a N temos: %.30f\nDe N a 0 temos: %.30f"%(H_0aN, H_Na0))
# print("Esses valores sao iguais? ", H_0aN == H_Na0)

### Exercicio2

# def cosseno():
#   global x
#   x = float(input("Digite um valor x para cos(x):"))
#   termo = 1.
#   soma = termo
#   i = 1.
#   while i<=(n-1):
#     termo = ((x*x)/((2*i)*(2*i-1)))*termo*-1
#     soma = soma + termo
#     i += 1
#   return soma
# import math  
# n = 10  
# print('o calculo feito pela funcao criada eh', cosseno())
# print('o calculo feito pela calculadora eh', math.cos(x))

### Exercicio3

# def mysin(x, order):
#     a = x
#     s = a
#     for i in range(1, order):
#         a *= -1 * x**2 / ((2 * i) * (2 * i + 1))
#         s += a
#     return s

### Exercicio4

# x_pos = x = float(input("Digite x: "))
# y = float(input("Digite y: "))
# if x < 0:
#     x_pos = -x
# dentro = True
# if x_pos >= 5 or y >= 8 or y <= 0:
#     dentro = False
# elif 0 <= x_pos <= 3 and 1 <= y <= 2:
#     dentro = False
# elif 1 <= x_pos <= 4 and 4 <= y <= 7:
#     if not (2 < x < 3 or 5 < y < 6):
#         dentro = False
# if dentro:
#     print("dentro")
# else:
#     print("fora")

### EXERCICIO_5

# x   = float(input("Digite x: "))
# eps = float(input("Digite epsilon: "))
# soma = 1
# fat = 1
# k,tabs = 1,1
# while tabs >= eps:
#     pot = x**k
#     fat *= k
#     t = pot/fat
#     tabs = t
#     if tabs < 0:
#         tabs = -tabs
#     soma += t
#     k += 1
 
# print("e**(%5.3f) = %7.5f"%(x,soma))

### EXERCICIO_6

# x   = float(input("Digite x: "))
# eps = float(input("Digite eps: "))
# print(x**(1/2))
# rant = x
# erro = eps
# while erro >= eps:
#     r = (rant + x/rant)/2
#     erro = r - rant
#     if erro < 0:
#         erro = -erro
#     rant = r
# print(r)

''' Funcoes'''

### Exercicio1

# m = int(input("Digite m: "))
# n = int(input("Digite n: "))
# k = m
# k_fat = 1
# cont = 1
# while cont < k:
#     cont += 1       
#     k_fat *= cont 
# m_fatorial = k_fat
# k = n
# k_fat = 1
# cont = 1
# while cont < k:
#     cont += 1       
#     k_fat *= cont   
# n_fatorial = k_fat
# k = m-n
# k_fat = 1
# cont = 1
# while cont < k:
#     cont += 1       
#     k_fat *= cont 
# mn_fatorial = k_fat

# print("Comb(",m,",",n,"): ", m_fatorial/(mn_fatorial * n_fatorial))

### Exercicio2

# def main():
#     print("0! =", fatorial(0))
#     print("1! =", fatorial(1))


# def fatorial(k):
#     k_fat = 1
#     cont = 1
#     while cont < k:
#         cont += 1  
#         k_fat *= cont
#     return k_fat
# main()

### Exercicio3

# def fatorial(k):
#     k_fat = 1
#     cont = 1
#     while cont < k:
#         cont += 1      
#         k_fat *= cont
#     return k_fat
# def combinacao(m, n):
#     return fatorial(m)/(fatorial(n)*fatorial(m-n))
# print("Combinacao(4,2) =", combinacao(4,2))

### Exercicio4

# def main():
#     n = int(input("Digite n: "))
#     cont = 0
#     while cont <= n:
#         print("Coeficiente de x^%d y^%d: %d"%(n-cont, cont, combinacao(n, cont)))
#         cont += 1

# def fatorial(k):
#     k_fat = 1
#     cont = 1
#     while cont < k:
#         cont += 1
#         k_fat *= cont
#     return k_fat

# def combinacao(m, n):
#     return fatorial(m)/(fatorial(n)*fatorial(m-n))

# main()




















