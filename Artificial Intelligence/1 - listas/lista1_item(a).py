
### Variaveis, expressoes e funcoes de entrada e saida

#exercicio1
# celsius = float(input("Digite a temperatura em celsius: "))    
# F = (celsius * 1.8) + 32.0
# print(F)

#exercicio2
# Fahrenheit = float(input("Digite a temperatura em Fahrenheit: ")) 
# C = (Fahrenheit - 32.0) * (5.0/9.0)
# print(C)

### Expressoes logicas e operadores relacionais

#exercicio1
#ano = int(input('Digite o ano: '))
#if ano % 100 != 0 and ano % 4 == 0 or ano % 400 == 0:
 #   print("E um ano bissexto")
#else:
 #   print("Nao e bissexto")

#exercicio2

# def main():
#     # dados da Penny
#     nome = "Penny"
#     sexo = "feminino"
#     altura = 167
#     peso   =  52
#     idade  =  25
#     cabelo = "loiro"
#     escolaridade = "medio"
#     compativel = sexo == 'feminino' and altura <= 170 and idade >= 25 and idade < 35
#     print("Candidata", nome, ":", compativel)

### Comando de repeticao: while

# ## exercicio1
# n = int(input("Digite o tam da seq: "))
# conta_par = 0
# cont = 0
# while cont < n:
#     num = int(input("Digite um num da seq: "))
#     cont = cont + 1
#     if num % 2 == 0:
#         conta_par = conta_par + 1
# print(conta_par,   "numeros pares")
# print(n - conta_par, "numeros impares")

# ## exercicio2
# def main():
#     n = int(input("Digite o valor de n: "))
#     k = int(input("Digite o valor de k: "))
#     pot = 1
#     i   = 0
#     while i < k:
#         pot = pot * n
#         i   = i + 1
#     print("A potencia eh", pot)  # print mais simples
#     print("O valor de %d elevado a %d eh %d" %(n, k, pot)) # mais elaborado

# ## exercicio3
# def main():
#     n = int(input("Digite o valor de n: "))
#     fat = 1
#     i = 2
#     while i <= n:
#         fat = fat*i
#         i = i + 1
#     print("O valor de %d! eh =" %n, fat)

# ## exercicio4
# def main():
#     n = int(input("Digite n: "))
#     i = int(input("Digite i: "))
#     j = int(input("Digite j: "))
#     # mutiplos de i e j
#     mult_i = mult_j = 0
#     k = 0
#     while k < n:
#         if mult_i == mult_j:
#             print(mult_i)
#             mult_i = mult_i + i
#             mult_j = mult_j + j
#         elif mult_i < mult_j:
#             print(mult_i)
#             mult_i = mult_i + i
#         else:
#             print(mult_j)
#             mult_j = mult_j + j;
#         k = k + 1

# ##exercicio 5
# def main():
#     n = int(input("Digite n: "))
#     m = int(input("Digite m: "))
#     anterior  = n
#     atual     = m
#     resto = atual % anterior
#     while resto != 0:
#         resto = anterior % atual;
#         anterior = atual;
#         atual = resto;
#     print("MDC(%d,%d)=%d" %(n,m,anterior))



#### Execucao condicional e alternativas: if, if-else e if-elif-else

# #exercico2
# n = int(input("Digite o tam da seq: ")) # atribuição multipla

# cont = conta_par = conta_impar = 0
# while cont < n:
#     num = int(input("Digite um num da seq: "))
#     cont = cont + 1
#     if num % 2 == 0:  # se num é múltiplo de 2, ou seja, é par
#         conta_par = conta_par + 1
#     else:
#         conta_impar = conta_impar + 1

# print(conta_par,   "numeros pares")
# print(conta_impar, "numeros impares")


# #exercico3
# n = int(input("Digite o valor de n (n > 0): "))
# d = int(input("Digite o valor de d (0<=d<=9): "))

# conta_digito = 0
# n_salvo = n
# while n > 0:
#     dig = n % 10
#     n = n // 10
#     if dig == d:
#         conta_digito = conta_digito + 1

# print("O digito", d, "ocorre", conta_digito, "vezes em ", n_salvo)

'''
Exercico4 - Programa que le um inteiro positivo n e imprime uma mensagem
indicando se ele eh ou nao triangular.
'''
# print("Determina se um numero n eh triangular\n")
# n = int(input("Digite o valor de n: "))
# i = 1
# while i * (i+1) * (i+2) < n:
#     i = i + 1
# if i * (i+1) * (i+2) == n:
#     print("%d eh o produto %d*%d*%d" %(n,i,i+1,i+2))
# else:
#     print("%d nao eh triangular" %(n))


'''
Exercico5 - Escreva um programa que leia três números naturais e 
verifica se eles formam os lados de um triângulo retângulo.
'''
# a = float (input("Lado A? "))
# b = float (input("Lado B? "))
# c = float (input("Lado C? "))
# if a <= 0 or b <= 0 or c <= 0:
#     print ("Valor invalido em um dos lados!")
# elif a+b > c and a+c > b and b+c > a:
#     if a**2 == b**2+c**2 or b**2 == a**2 + c**2 or c**2 == a**2 + b**2:
#         print("Triangulo Retangulo")
# else:
#     print("Nao forma um Triangulo!")

# #exercico6 - OK
# n1 = int(input('Digite um número '))
# n2 = int(input('Digite outro '))
# n3 = int(input('Digite outro '))
# lista =[n1,n2, n3]
# print(sorted(lista))

#-------------------------------------------
if __name__ == '__main__':
    main()