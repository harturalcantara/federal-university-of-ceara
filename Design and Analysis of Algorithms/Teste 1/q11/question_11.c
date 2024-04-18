int count(float *A, int inicio, int fim, float x)
{
    int i, cont = 0;
    for(i = inicio; i <= fim; i++)
    {
        if(A[i] == x) cont++;
    }
    return cont;
}


float question_11(float *A, int inicio, int fim)
{
    if (inicio > fim) return 0;
    else if (inicio == fim) return A[inicio];
    else
    {
        int meio = (inicio + fim) / 2;

        float x = question_11(A, inicio, meio);
        float y = question_11(A, meio + 1, fim);

        if (x == y) return x;

        if (x > 0)
        {
            if (count(A, inicio, fim, x) > (fim - inicio + 1) / 2) return x;
        }
        if (y > 0)
        {
            if (count(A, inicio, fim, y) > (fim - inicio + 1) / 2) return y;
        }
        return 0;
    }
}
