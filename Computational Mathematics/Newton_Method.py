import Numerical_Differentiation, Function


def newton_method(a, e):
    while True:
        x = a - (Function.function_value(a) / Numerical_Differentiation.derivative_first_h2(a, e))
        if (abs(Function.function_value(x)) < e) or (abs(x - a) < e):
            return x
        a = x