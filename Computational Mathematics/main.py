import Lagrange_Polynomial, Numerical_Differentiation, False_Position, Newton_Method, Trapezoid_Method, Function, Simpson_Method, Taylor_Polynomial, Gauss_Legendre, math

##Parametros
# 1 parametro -> lista de pontos da funcao
# 2 parametro -> possivelmente o valor de x quando calcula os l(i)
#print('Metodo Lagrange: ', Lagrange_Polynomial.lagrange_([2, 2.5, 4], 3))

#print(Taylor_Polynomial.taylor_polynomial(0, 1, 2, 0.001))

#print('Metodo da posicao falsa: ', False_Position.false_position(0, 1, 0.001, 0.001))

''' Metodo de Newton
### Parametros de entrada
Funcao deve ser estabalecida na Function.py
1 parametro -> Chute inicial
2 parametro -> Error inferior (condicao de parada)
'''
#print(Newton_Method.newton_method(3, 0.01)) #Okay


''' Metodo do Trapezio simples
Funcao deve ser estabalecida na Function.py
1 parametro -> limite inferior
2 parametro -> limite superior
'''
print('Trapezio simples = ', Trapezoid_Method.trapezoid_method_simple(0, 2)) #Okay

''' Metodo do Trapezio Composto
Funcao deve ser estabalecida na Function.py
1 parametro -> limite inferior
2 parametro -> limite superior
3 parametro -> numero de subintervalos
'''
#print('Trapezio composto = ', Trapezoid_Method.trapezoid_method_compost(0, 2, 1))

''' Method of Simpson Simple
Funcao deve ser estabalecida na Function.py
1 parametro -> limite inferior
2 parametro -> limite superior

'''
#print('Simpson simples = ',Simpson_Method.simpson_method(0, 2))

print(Simpson_Method.simpson_method_compost(0,1, 6))


#print(Numerical_Differentiation.derivative_first_h2(3, 0.00000001))





#print(Gauss_Legendre.gauss_legendre_order_2(2,6))