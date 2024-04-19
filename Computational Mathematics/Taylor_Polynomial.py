import Function, Numerical_Differentiation, math


def _calculate_ci(a, x, k, e):
    if k == 1:
        return Numerical_Differentiation.derivative_first_h2(a, e) * (
               math.pow((x - a), k))
    if k == 2:
        return Numerical_Differentiation.derivative_second_h2(a,e) * (
               math.pow((x - a), k))


def taylor_polynomial(a, x, k, e):
    if k > 2: return
    result = 0
    i = 1
    while i <= k:
        result = result + (1/math.factorial(i))*_calculate_ci(a, x, i, e)
        i = i + 1
    return Function.function_value(a + e) + result
