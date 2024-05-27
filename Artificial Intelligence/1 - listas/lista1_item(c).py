'''Lista: estrutura sequencial indexada'''

#EXERCIO_1 - OK

# n = int(input("Digite o valor de n: "))
# i = 0
# impar = 1
# lista = []
# if n > 0:
#     while i < n: 
#         x = int(input("Digite um valor: "))
#         print(x in lista)
#         lista.insert(i, x)
#         print(x in lista)
#         print(lista[i])
#         i = i + 1
# print(lista)
# lista.sort(reverse=True)
# print(lista)

#EXERCIO_2 - OK

# n = int(input("Digite o valor de n: "))
# i = 0
# impar = 1
# lista = []
# if n > 0:
#     while i < n: 
#         x = int(input("Digite um valor: "))
#         if (x in lista) != True:
#             print("entrei")
#             lista.insert(i, x)
#             i = i + 1
#         else: 
#             i = i + 1
# print(lista)

#EXERCIO_3 - OK

# def remove_repetidos(lista):
#     l = []
#     for i in lista:
#         if i not in l:
#             l.append(i)
#     l.sort()
#     return l

# lista1 = [1, 1, 2, 1, 3, 4, 3, 6, 7, 6, 7, 8, 10 ,9]
# lista2 = [11, 21, 32, 41, 32, 44, 34, 26, 74, 16, 17, 318, 10 ,9]
# print (remove_repetidos(lista1+lista2))

#EXERCIO_4

# from sys import maxint 
# def maxSum(a,size): 
#     max_so_far = -maxint - 1
#     max_ending_here = 0
#     for i in range(0, size): 
#         max_ending_here = max_ending_here + a[i] 
#         if (max_so_far < max_ending_here): 
#             max_so_far = max_ending_here 
#         if max_ending_here < 0: 
#             max_ending_here = 0   
#     return max_so_far 
   
# # Driver function to check the above function  
# a = [-13, -3, -25, -20, -99, -16, -23, -12, 2, -22, -15, -4, -7] 
# b = [5,   -2,   -2,   -7,   3,   14,  10,  -3,   9,   -6,   4,   1]
# print maxSum(b,len(b)) 


''' Funcoes com listas '''


#EXERCIO_1
# def pertence(item, lista):
#     if item in lista:
#         return True
#     return False

#EXERCIO_2

# def remove_repetidos(lista):
#      l = []
#      for i in lista:
#          if pertence(i,l) == False:
#              l.append(i)
#      l.sort()
#      return l

# lista1 = [1, 1, 2, 1, 3, 4, 3, 6, 7, 6, 7, 8, 10 ,9]
# lista2 = [11, 21, 32, 41, 32, 44, 34, 26, 74, 16, 17, 318, 10 ,9]
# print (remove_repetidos(lista1+lista2))

#EXERCIO_3
# def indice(item, lista):
#     i = 0
#     while i < len(lista):
#         if lista[i] is item:
#             return i
#         i = i + 1

#EXERCIO_4

# def recursiveCount(lst,key):
#     if lst == []: #base case
#         return 0
#     if lst[0] == key:
#         return 1 + recursiveCount(lst[1:],key)
#     else:
#         return 0 + recursiveCount(lst[1:],key)

# print recursiveCount(['a','b','a'],'a')


#EXERCIO_5

# def soma(list1): 
#     maxi = 0
#     for x in list1: 
#         sum = 0 
#         for y in x: 
#             sum+= y      
#         maxi = max(sum, maxi)  
#     return maxi    
# list1 = [[1, 2, 3], [4, 5, 6], [10, 11, 12], [7, 8, 9]] 
# print soma(list1) 




#EXERCIO_6 - OK

# from sys import maxint 
# def maxSum(a,size): 
#     max_so_far = -maxint - 1
#     max_ending_here = 0
#     for i in range(0, size): 
#         max_ending_here = max_ending_here + a[i] 
#         if (max_so_far < max_ending_here): 
#             max_so_far = max_ending_here 
#         if max_ending_here < 0: 
#             max_ending_here = 0   
#     return max_so_far 
   
# # Driver function to check the above function  
# a = [-13, -3, -25, -20, -99, -16, -23, -12, 2, -22, -15, -4, -7] 
# b = [5,   -2,   -2,   -7,   3,   14,  10,  -3,   9,   -6,   4,   1]
# print maxSum(b,len(b)) 