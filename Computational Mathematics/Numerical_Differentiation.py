import Function


# Error - O(h^2)
def derivative_first_h2(a, h):
    return (Function.function_value(a + h) - Function.function_value(a - h)) / (2 * h)


# Error - O(h^4)
def derivative_first_h4(a, h):
    return (-Function.function_value(a + 2 * h) + 8 * (Function.function_value(a + h)) -
            8 * Function.function_value(a - h) + Function.function_value(a - 2 * h)) / (12 * h)


# Error - O(h^2)
def derivative_second_h2(a, h):
    return (Function.function_value(a) - 2*Function.function_value(a + h) +
            Function.function_value(a + 2*h)) / (h*h)

