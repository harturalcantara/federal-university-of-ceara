import Function


def simpson_method(a, b):
    return ((b - a) / 6) * (Function.function_value(a) + 4 * Function.function_value((a + b) / 2) +
                            Function.function_value(b))


def simpson_method_compost(a, b, num_interval):
    if num_interval == 0: return
    h = (b - a) / num_interval
    add_even = 0
    add_odd = 0

    i = 1
    while i < num_interval:
        if i % 2 == 0:
            add_even = add_even + Function.function_value(h * i)
        else:
            add_odd = add_odd + Function.function_value(h * i)
        i = i + 1

    return (h / 3) * (Function.function_value(a) + Function.function_value(b) +
                      4 * add_odd + 2 * add_even)
