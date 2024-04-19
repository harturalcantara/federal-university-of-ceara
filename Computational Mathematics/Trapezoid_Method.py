import Function


def trapezoid_method_simple(a, b):
    return (b - a) * ((Function.function_value(a) + Function.function_value(b)) / 2)


def trapezoid_method_compost(a, b, num_interval):
    if num_interval == 0: return
    result = 0
    h = (b - a) / num_interval
    for i in range(num_interval):
        result = result + (Function.function_value(h*i) + Function.function_value(h*i + h))
    return (h/2) * result
