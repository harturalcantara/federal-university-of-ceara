import math, Function


def false_position(a, b, e1, e2):
    if (b - a) < e1: return [a, b]
    if abs(Function.function_value(a)) < e2: return a
    if abs(Function.function_value(b)) < e2: return b

    while True:
        x = ((a * Function.function_value(b)) - (b * Function.function_value(a))) / \
            (Function.function_value(b) - Function.function_value(a))
        if abs(Function.function_value(x)) < e2: return x
        if Function.function_value(a) * Function.function_value(x) > 0: a = x
        else: b = x
        if(b - a) < e1: return [a, b]
