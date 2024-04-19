import math

#Gauss-Legendre
# a]b f(x) dx = (b - a)/ 2 * -1]1 f((b-a)/2 * z + (b + a)/2)dz

def function_value(x, a, b):
    z = ((b - a)/2)*x + ((b + a)/2)
    return z*z*z + 2 *z