def gaussian_eliminition(matriz_extend, row, column):
    matriz = matriz_extend

    for k in range(row):
        for i in range(k + 1, row):
            a = matriz[i][k]
            for j in range(column):
                matriz[i][j] = matriz[i][j] - (a / matriz[k][k]) * matriz[k][j]

    return matriz


def resolve_linear_system(matriz_extend, row, column):
    matriz = gaussian_eliminition(matriz_extend, row, column);
    soluction = {}

    for i in range(row - 1, -1, -1):
        result = 0
        for j in range(i, column - 1):
            if soluction.__contains__(i):
                    result = result - matriz[i][j] * soluction[j]
            else:
                    soluction[i] = 0
        result = (result + matriz[i][column - 1]) / matriz[i][i]
        if result == -0.0: result = 0.0
        soluction[i] = round(result,2)

    return soluction


def _max_row(matriz_extend, row, row_current, column, column_current):
    matriz = matriz_extend
    max_row = 0
    max_value = matriz_extend[row_current][column_current]

    for i in range(row_current, row):
        if matriz[i][column_current] >= max_value:
            max_row = i

    for j in range(column):
        swap = matriz[max_row][j]
        matriz[max_row][j] = matriz[row_current][j]
        matriz[row_current][j] = swap
    
    return matriz


def gaussian_eliminition_partial_pivoting(matriz_extend, row, column):
    matriz = matriz_extend

    for k in range(row):
        matriz = _max_row(matriz, row, k, column, k)
        for i in range(k + 1, row):
            m = float(matriz[i][k]) / matriz[k][k]
            for j in range(column):
                matriz[i][j] = matriz[i][j] - (m * matriz[k][j])

    return matriz

def decomposition_lu(matrix_extend, row, column):
    U = matrix_extend
    L = {}

    for i in range(row):
        L[i] = {}
        for j in range(column):
            if i == j: L[i][j] = 1
            else: L[i][j] = 0

    for k in range(row):
        for i in range(k + 1, row):
            a = U[i][k] / U[k][k]
            L[i][k] = round(a, 2)
            for j in range(column):
                U[i][j] = round(U[i][j] - a * U[k][j], 2)

    return [L, U]

def decomposition_lu_pivot(matrix_extend, row, column):
    U = matrix_extend
    L = {}

    for i in range(row):
        L[i] = {}
        for j in range(column):
            if i == j: L[i][j] = 1
            else: L[i][j] = 0

    for k in range(row):
        U = _max_row(U, row, k, column, k)
        for i in range(k + 1, row):
            m = float(U[i][k]) / U[k][k]
            L[i][k] = round(m , 2)
            for j in range(column):
                U[i][j] = U[i][j] - (m * U[k][j])

    return [L, U]

def print_matrix_set(matrix):
    for i in matrix:
        for j in matrix[i]: print(matrix[i][j], ' ', end='')
        print()

def print_matrix_list(matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[i])): print(matrix[i][j], ' ', end='')
        print()

matrix = [[1,1,1,10],[0,1,1,6],[0,0,1,2]]
print(resolve_linear_system(matrix, 3, 4))

matrix = [[1,4,-2],[3,-2,5],[2,3,1]]
b = decomposition_lu_pivot(matrix, 3, 3)
print_matrix_set(b[0])
print_matrix_list(b[1])


