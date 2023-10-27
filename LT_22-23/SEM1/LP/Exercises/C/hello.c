// struct per una matrice
struct matrix
{
    int rows;
    int cols;
    double **data;
};

// typedef per una matrice
typedef struct matrix *matrice;

// funzione per la creazione di una matrice
matrice create_matrix(int rows, int cols)
{
    matrice m = malloc(sizeof(struct matrix));
    m->rows = rows;
    m->cols = cols;
    m->data = malloc(rows * sizeof(double *));
    for (int i = 0; i < rows; i++)
    {
        m->data[i] = malloc(cols * sizeof(double));
    }
    return m;
}
