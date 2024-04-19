import Function


def _li_(list_x, i, x):
    prod = 1
    for j in range(len(list_x)):
        if i != j:
            prod = prod * ((x - list_x[j]) / (list_x[i] - list_x[j]))
    return prod


def _lagrange_(list_x, x):
    sum = 0
    for i in range(len(list_x)):
        sum = sum + Function.function_value(list_x[i]) * _li_(list_x, i, x)
    return sum


def lagrange_(list_x, x):
    return _lagrange_(list_x, x)
