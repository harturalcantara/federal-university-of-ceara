/*Função que retorna o tamanho da string s*/
int mstrlen(char *s);

/*Função que concatena uma string src ao final de uma string dest, 
retorna um ponteiro para o início de dest.*/
char *mstrcat(char *dest,  char *src);

/*Função que compara se duas strings s1 e s2 são iguais 
(Ignorando letras maiúsculas e minúsculas), isto é roberto é igual a RoberTo.*/
int mstrcasecmp( char *s1,  char *s2);

/*Função que compara se os primeiros n caracteres de duas strings s1 e s2 são iguais 
(Ignorando letras maiúsculas e minúsculas), isto é roberto é igual a RoberTo.*/
int mstrncasecmp( char *s1,  char *s2, int n);

/*Função que retorna o ponteiro da primeira ocorrência do caracter c na string s*/
char *mindex( char *s, int c);

/*Função que retorna o ponteiro da última ocorrência do caracter c na string s*/
char *mrindex( char *s, int c);

/*Função que copia uma string de src para o destino dest, retornando um ponteiro 
para o final da sequência resultante do dest*/
char *mstpcpy(char *dest,  char *src);

/*Retorna uma cópia da string s em uma memória alocada dinamicamente.*/
char *mstrdup( char *s);

/*Adiciona os primeiros n caracteres da string src na string dest, 
retornando um ponteiro para o início da string dest*/
char *mstrncat(char *dest,  char *src, int n);
