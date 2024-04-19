import math, Function_Gauss_Legendre

def gauss_legendre_order_2(a, b):
    result = Function_Gauss_Legendre.function_value(math.pow(3, 1/2) / 3, a, b) + \
             Function_Gauss_Legendre.function_value(-math.pow(3, 1/2) / 3, a, b)
    return ((b - a) / 2) * result