#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

///INTEGRANTES DA EQUIPE
//Hartur Alcantara
//Alimpio Brito
//João Vitor

///ESTRUTURAS
struct nasc{
    int dia1;
    int mes1;
    int ano1;
};

struct contr{
    int dia2;
    int mes2;
    int ano2;
};

struct dados{
    int mat;
    char nome[50];
    int idade;
    char genero;
    char cpf[15];
    struct nasc nascimento;
    struct contr contratacao;
    char cargo[50];
    float salario;
};


///FUNCAO PARA INICIALIZAR TODOS OS FUNCIONARIOS COM A MATRICULA 0;
void iniciarM(struct dados rh[], int tam){
    int i;
    for(i=0;i<tam;i++){
        rh[i].mat = 0;
    }
}

///FUNCAO INICIAR MATRICULA
int iniciar(struct dados rh[], int tam){
    int i, z = 0;
        for(i=0;i<tam;i++){
           if(rh[i].mat == 1){
               z++;
           }
        }
        return z;
}

///FUNCAO INSERIR FUNCIONARIO - 01 OPCAO;
void InserirF(struct dados rh[], int T){
        //ABRINDO ARQUIVO;
        FILE *arquivo = fopen("arquivo.txt", "r+");
            int i;
            for(i=0;i<T;i++){
                if(rh[i].mat == 0){

                    fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                    //MATRICULA DELE FOI ALTERADA PARA 1;
                    rh[i].mat = 1;
                    //DADOS DOS FUNCIONARIO;
                    printf("\tInsira os dados do Funcionário\n");
                    //NOME;
                    printf("Digite o nome do funcionario: ");
                    fflush(stdin);
                    scanf("%s",&rh[i].nome);
                    //IDADE;
                    printf("Digite a idade do funcionário: ");
                    scanf("%d",&rh[i].idade);
                    //GENERO;
                    printf("Digite o genero do funcionario opções 'M' ou 'm' ou 'F' 'f': ");
                    fflush(stdin);
                    scanf("%c",&rh[i].genero);
                    //CPF
                    printf("O CPF do funcionário: ");
                    fflush(stdin);
                    scanf("%s", &rh[i].cpf);
                    //DATA DE NASCIMENTO
                    printf("Digite a data de nascimento do funcionário: ");
                    scanf("%d/%d/%d",&rh[i].nascimento.dia1 , &rh[i].nascimento.mes1, &rh[i].nascimento.ano1);
                    //DATA DE CONTRATACAO
                    printf("Digite a data de contratação do funcionário: ");
                    scanf("%d/%d/%d",&rh[i].contratacao.dia2, &rh[i].contratacao.mes2, &rh[i].contratacao.ano2);
                    //CARGO
                    printf("O cargo do funcionário: ");
                    fflush(stdin);
                    scanf("%s", &rh[i].cargo);
                    //SALARIO
                    printf("O salário do funcionário: ");
                    scanf("%f", &rh[i].salario);
                    //Menssagem
                    printf("\t\t\tOS DADOS DO FUNCIONARIO FORAM INSERIDOS COM SUCESSO!\n");
                    printf("O funcionario foi incluido na posicao %d\n", i);
                    //GRAVANDO NO ARQUIVO;
                    fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                    break;
                }
            }
        fclose(arquivo);
}

///FUNCAO ALTERAR FUNCIONARIO - 02 OPCAO;
void alterarF(struct dados rh[], int T, char cpf[], int n){
    //ABRINDO ARQUIVO
    FILE *arquivo = fopen("arquivo.txt", "r+");
        int i;
        int j;

        int veri = 0;
        //VERIFICANDO SE EXISTE O CPF QUE ELE DIGITOU;
        for(j=0;j<T;j++){
            if(!strcmp(cpf,rh[j].cpf)){
                veri++;
            }
        }
        //SE SIM FAZ;
        if(veri!=0){
            for(i=0;i<T;i++){
                if(!strcmp(cpf,rh[i].cpf)){
                    printf("\nComparando CPF [%s] com [%s]\n\n", cpf, rh[i].cpf);
                    printf("Alterando a posicao %i\n", i);
                    int op = -1;
                    while(op!=0){
                        printf("\t\t\tAlterar os dados do funcionário\n");
                        printf("\t\t01 - Alterar o Nome\n");
                        printf("\t\t02 - Alterar a Idade\n");
                        printf("\t\t03 - Alterar o Genero\n");
                        printf("\t\t04 - Alterar o CPF\n");
                        printf("\t\t05 - Alterar a data de Nascimento\n");
                        printf("\t\t06 - Alterar a data de Contrato\n");
                        printf("\t\t07 - Alterar o Cargo\n");
                        printf("\t\t08 - Alterar o Salario\n");
                        printf("\t\t00 - Sair\n");
                        printf("\t\tDigite uma das opcoes: ");
                        scanf("%d",&op);
                        printf("\n");
                        //1 NOME;
                        if(op == 1){
                            printf("\t\tO nome desse funcionario: \"%s\" \n", rh[i].nome);
                            printf("\t\tRenomea-lo - Digite o nome do funcionario: ");
                            fflush(stdin);
                            scanf("%s",&rh[i].nome);
                            printf("\n\t\tAlterações feitas com sucesso!\n\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //2-idade
                        else if(op == 2){
                            printf("A idade desse funcionario: \"%d\" \n",rh[i].idade);
                            printf("Renomear - Digite a idade do funcionário: ");
                            scanf("%d",&rh[i].idade);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //3-genero
                        else if(op == 3){
                            printf("O genero desse funcionario: \"%c\" \n",rh[i].genero);
                            printf("Renomear - Digite o genero do funcionario opções 'M' ou 'm' ou 'F' 'f': ");
                            fflush(stdin);
                            scanf("%c",&rh[i].genero);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //4-CPF
                        else if(op == 4){
                            printf("O CPF desse funcionario: \"%s\" \n",rh[i].cpf);
                            printf("Renomear - O CPF do funcionário: ");
                            scanf("%s", &rh[i].cpf);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //5 - NASCIMENTO
                        else if(op == 5){
                            printf("A idade desse Funcionario e: \"%d/%d/%d\"\n",rh[i].nascimento.dia1 , rh[i].nascimento.mes1, rh[i].nascimento.ano1);
                            printf("Renomea-lo - Digite a data de nascimento do funcionário: ");
                            scanf("%d/%d/%d",&rh[i].nascimento.dia1 , &rh[i].nascimento.mes1, &rh[i].nascimento.ano1);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //6 - Contrato
                        else if(op == 6){
                            printf("A CONTRATO desse Funcionario e: \"%d/%d/%d\" \n", rh[i].contratacao.dia2 , rh[i].contratacao.mes2, rh[i].contratacao.ano2);
                            printf("Renomear - Digite a data de contratação do funcionário: ");
                            scanf("%d/%d/%d",&rh[i].contratacao.dia2, &rh[i].contratacao.mes2, &rh[i].contratacao.ano2);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //7-CARGO
                        else if(op == 7){
                            printf("O cargo desse funcionario: \"%s\" ", rh[i].cargo);
                            printf("Renomear - O cargo do funcionário: ");
                            fflush(stdin);
                            scanf("%s", &rh[i].cargo);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //8 - Salario
                        else if(op == 8){
                            printf("O salario desse funcionario e: \"%f\" ", rh[i].salario);
                            printf("Renomear - O salário do funcionário: ");
                            scanf("%f", &rh[i].salario);
                            printf("\nAlterações feitas com sucesso!\n");
                            //SALVA AS ALTEROES NO ARQUIVO;
                            fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                            fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                        }
                        //0 - Sair
                        else if(op == 0){
                            printf("Até mais!");
                            i=T;
                        }
                        //Opcao Invalida
                        else if(op != 0){
                            printf("Opcão invalidada\n");
                        }
                    }//while
                }//if
            }//for;
        }//IF VERI !=0;
        else
            printf("\tNAO EXISTE ESSE CPF NO NOSSO BANCO DE REGISTROS\n");

    fclose(arquivo);
}

///FUNCAO REMOVER FUNCIONARIO - 03 OPCAO;
void removerF(struct dados rh[], int T, char cpf[], int n){
    FILE *arquivo = fopen("arquivo.txt", "r+");
        int i;
        int j;
        int veri = 0;
        //VERIFICANDO CPF;
        for(j=0;j<T;j++){
            if(!strcmp(cpf,rh[j].cpf)){
                veri++;
            }
        }//for 2;
        if(veri!=0){
            for(i=0;i<T;i++){
                    printf("\nComparando %s com %s\n\n", cpf, rh[i].cpf);
                if(!strcmp(cpf , rh[i].cpf)) {
                    printf("\t\t\tREMOVER DADOS DO FUNCIONARIO DO CPF = [%s]\n", rh[i].cpf);
                    //3 - Nome
                    strcpy(rh[i].nome, " ");
                    //4 - Idade
                    rh[i].idade = NULL;
                    //5 - Genero
                    rh[i].genero = NULL;
                    //6 - CPF
                    strcpy(rh[i].cpf , " ");
                    //7 - Nascimento
                    rh[i].nascimento.dia1 = NULL, rh[i].nascimento.mes1= NULL, rh[i].nascimento.ano1 = NULL;
                    //6 - Contrato
                    rh[i].contratacao.dia2 = NULL, rh[i].contratacao.mes2 = NULL, rh[i].contratacao.ano2 = NULL;
                    //7-CARGO
                    strcpy(rh[i].cargo, " ");
                    //8 - Salario
                    rh[i].salario = 0;

                    //MATRICULA REMOVIDA
                    rh[i].mat = 0;

                    printf("\t\t\tRemover o úsuario desse CPF, foram feitas com sucesso!\n");

                    fseek(arquivo,i*sizeof(struct dados), SEEK_SET);
                    fwrite(&rh[i], sizeof(struct dados), 1, arquivo);
                    break;
                }
            }
        }
        else
            printf("\nNAO EXISTE ESSE CPF NO NOSSO BANGO DE REGISTROS\n");
    fclose(arquivo);
}

///FUNCAO BUSCAR POR NOME/CPF/CARGO - 04 OPCAO;
void buscarF_Nome_CPF_Cargo(struct dados rh[], int T, char x[], int N){
        //Buscar por NOME;
        FILE *arquivo = fopen("arquivo.txt", "r");
            fread(rh, sizeof(struct dados), 2, arquivo);
            //BUSCANDO POR NOME;
            if(N == 50){
                int i;
                int j;
                int veri = 0;
                for(j=0;j<T;j++){
                    if(!strcmp(x,rh[j].nome)){
                        veri++;
                    }
                }//FOR;
                if(veri!=0){
                    for(i=0;i<T;i++){
                        if(!strcmp(x , rh[i].nome)){
                            printf("\t>>>>>BUSCAR DADOS DO FUNCIONÁRIO POR NOME = [%s]\n", x);
                            printf("O nome do funcionario: %s \n", rh[i].nome);
                            printf("A idade do funcionário: %d \n", rh[i].idade);
                            printf("O genêro do funcionario opções: %c \n", rh[i].genero);
                            printf("O CPF do funcionário: %s \n", rh[i].cpf);
                            printf("A data de nascimento do funcionário: %d/%d/%d \n", rh[i].nascimento.dia1 , rh[i].nascimento.mes1, rh[i].nascimento.ano1);
                            printf("A data de contratação do funcionário: %d/%d/%d \n", rh[i].contratacao.dia2, rh[i].contratacao.mes2, rh[i].contratacao.ano2);
                            printf("O cargo do funcionário: %s \n", rh[i].cargo);
                            printf("O salário do funcionário: %f \n", rh[i].salario);
                            break;
                        }
                    }
                }//IF
                else
                    printf("\t\t\tESSjE NOME NAO EXISTE NO NOSSO BANCO DE REGISTROS\n");
            }//FECHAMENTO CASO NOME;

            //BUSCAR POR CPF;
            else if(N == 11){
                int i;
                int j;
                int veri = 0;
                for(j=0;j<T;j++){
                    if(!strcmp(x,rh[j].cpf)){
                        veri++;
                    }
                }//for 2;
                if(veri!=0){
                    for(i=0;i<T;i++){
                        if(!strcmp(x , rh[i].cpf)){
                            printf("\t\t\tBUSCAR DADOS DO FUNCIONÁRIO PELO CPF = [%s]\n", x);
                            printf("\tO nome do funcionario: %s \n", rh[i].nome);
                            printf("\tA idade do funcionário: %d \n", rh[i].idade);
                            printf("\tO genêro do funcionario opções: %c \n", rh[i].genero);
                            printf("\tO CPF do funcionário: %s \n", rh[i].cpf);
                            printf("\tA data de nascimento do funcionário: %d/%d/%d \n", rh[i].nascimento.dia1 , rh[i].nascimento.mes1, rh[i].nascimento.ano1);
                            printf("\tA data de contratação do funcionário: %d/%d/%d \n", rh[i].contratacao.dia2, rh[i].contratacao.mes2, rh[i].contratacao.ano2);
                            printf("\tO cargo do funcionário: %s \n", rh[i].cargo);
                            printf("\tO salário do funcionário: %f \n", rh[i].salario);
                            break;
                        }
                    }
                }//if
                else
                    printf("Esse CPF NAO EXISTE NO NOSSO BANCO DE REGISTROS\n");
            }//FECHAMENTO 2 CASO;

            //BUSCAR POR CARGO;
            else if(N == 30){
                int i;
                int j;
                int veri = 0;
                for(j=0;j<T;j++){
                    if(!strcmp(x,rh[j].cargo)){
                        veri++;
                    }
                }//FOR;
                if(veri!=0){
                    for(i=0;i<T;i++){
                        if(!strcmp(x , rh[i].cargo)){
                            printf("\t>>>>>BUSCAR DADOS DO FUNCIONÁRIO POR CARGO = [%s]\n", x);
                            printf("O nome do funcionario: %s \n", rh[i].nome);
                            printf("A idade do funcionário: %d \n", rh[i].idade);
                            printf("O genêro do funcionario opções: %c \n", rh[i].genero);
                            printf("O CPF do funcionário: %s \n", rh[i].cpf);
                            printf("A data de nascimento do funcionário: %d/%d/%d \n", rh[i].nascimento.dia1 , rh[i].nascimento.mes1, rh[i].nascimento.ano1);
                            printf("A data de contratação do funcionário: %d/%d/%d \n", rh[i].contratacao.dia2, rh[i].contratacao.mes2, rh[i].contratacao.ano2);
                            printf("O cargo do funcionário: %s \n", rh[i].cargo);
                            printf("O salário do funcionário: %f \n", rh[i].salario);
                            break;
                        }
                    }
                }//if
                else
                    printf("NAO EXISTE ESSE CARGO NO NOSSO BANCO DE REGISTROS\n");
            }
        fclose(arquivo);
}

///FUNCAO BUSCAR POR INTERVALO DE SALARIOS - 05 OPCAO;
void buscarF_Intervalo_Salario(struct dados rh[], int T, float mini, float max){
    int i;
    for(i=0;i<T;i++){
        if(rh[i].salario>mini && rh[i].salario<max){
            printf("\t\t\t\tO Nome do funcionario[%d]: [%s]\n",i, rh[i].nome);
            printf("\t\t\t\tO CPF do funcionario[%d]: [%s]\n\n",i, rh[i].cpf);
        }
    }
}

///FUNCAO IMPRIMIR O VALOR TOTAL DE PAGAMENTO MENSAL - 06 OPCAO;
void total_pagamento(struct dados rh[], int T){
    int i;
    float somaTotal = 0;
    for(i=0;i<T;i++){
        somaTotal = somaTotal + rh[i].salario;
    }
    printf("Total pagamento mensal dos funcionarios: %f",somaTotal);
}

///FUNCAO IMPRIMIR O NOME E CARGO DE TODOS OS FUNCIONARIOS - 07 OPCAO;
void imprimir_Nome_Cpf_Func(struct dados rh[], int T){
    FILE *arquivo = fopen("arquivo.txt", "r");
        struct dados funci;
        int i = 0;
        printf("\n");
        while(!feof(arquivo)){
            if(!feof(arquivo)){
                fread(&rh[i], sizeof(struct dados), 1, arquivo);
                printf("\t\t\tNo registro [%d] tem - O Nome do Funcionario: %s \n",i, rh[i].nome);
                printf("\t\t\tNo registro [%d] tem - O Cargo do Funcionario: %s \n",i, rh[i].cargo);
                printf("\n");
                i++;
                if(i >= 2){
                    break;
                }
            }
        }
    fclose(arquivo);
}

///FUNCAO IMPRIMIR O FUNCIONARIO COM SALARIOS MAIS ALTO, O MAIS ANTIGO DA EMPRESA E O MAIS VELHO - 8 OPCAO;
void imprimir_Func_SalarioMaior_MaisAntigo_MaisVelho(struct dados rh[], int T){
    int i;

    float maiorS = 0;
    int MaisAntigo;
    int MaisVelho;
    int pMaior;

    //SALARIO MAIS ALTO;
    for(i=0;i<T;i++){
        if(maiorS < rh[i].salario){
            maiorS = rh[i].salario;
            pMaior = i;
        }
    }

    //FUNCIONARIO MAIS ANTIGO;
    MaisAntigo = comparacaoAntigo(rh, 2);
    //FUNCIONARIO MAIS VELHO;
    MaisVelho = comparacaoVelho(rh, 2);

    //IMPRIMIR OS DADOS
    printf("O funcionario com maior Salario da Empresa: [%s]-[%f]\n", rh[pMaior].nome, maiorS);
    printf("O funcionario mais Antigo da Empresa: [%s]\n", rh[MaisAntigo].nome);
    printf("O funcionario mais Velho da Empresa: [%s]\n", rh[MaisVelho].nome);

}

///FUNCOES AUXILIARES DA OPCAO 8;
//VER O FUNCIONARIO CONTRATADO MAIS ANTIGO;
int comparacaoAntigo(struct dados rh[], int T){
    int i;
    int maisantigo = 0;
    for (i=1; i<T; i++){
        if(rh[i].contratacao.ano2 < rh[maisantigo].contratacao.ano2)
        {
            maisantigo = i;
        }
        else if(rh[i].contratacao.ano2 == rh[maisantigo].contratacao.ano2)
        {
            if(rh[i].contratacao.mes2< rh[maisantigo].contratacao.mes2)
                maisantigo = i;
            else if(rh[i].contratacao.mes2==rh[maisantigo].contratacao.mes2)
            {
                if(rh[i].contratacao.dia2 < rh[maisantigo].contratacao.dia2)
                    maisantigo = i;
                else if(rh[i].contratacao.dia2==rh[maisantigo].contratacao.dia2)
                    maisantigo = i;
            }
        }
    }
    return maisantigo;
}
//VER O FUNCIONARIO MAIS VELHO;
int comparacaoVelho(struct dados rh[], int T){
    int i, maisvelha = 0;
    for (i=1; i<T; i++)
    {
        if(rh[i].nascimento.ano1 < rh[maisvelha].nascimento.ano1)
        {
            maisvelha = i;
        }
        else if(rh[i].nascimento.ano1==rh[maisvelha].nascimento.ano1)
        {
            if(rh[i].nascimento.mes1< rh[maisvelha].nascimento.mes1)
                maisvelha = i;
            else if(rh[i].nascimento.mes1==rh[maisvelha].nascimento.mes1)
            {
                if(rh[i].nascimento.dia1 < rh[maisvelha].nascimento.dia1)
                    maisvelha = i;
                else if(rh[i].nascimento.dia1==rh[maisvelha].nascimento.dia1)
                    maisvelha = i;
            }
        }
    }
    return maisvelha;
}

///FUNCAO PRINCIPAL
int main(){
    setlocale(LC_ALL,"portuguese");
    struct dados rh[2];///Futuramente Funcionarios - 100;
    int op = -1;

    ///INICIALIZANDO FUNCIONARIOS;
    iniciarM(rh, 2);

    FILE *arquivo = fopen("arquivo.txt", "a+");
        fseek(arquivo,0,SEEK_SET);
        int i = 0;
        printf("\n");
        while(!feof(arquivo)){
            if(!feof(arquivo)){
                fread(&rh[i], sizeof(struct dados), 1, arquivo);
                printf("\t\t\t\t|Exibição de auxilio|\n\n");
                printf("\t\t\tNo registro [%d] tem - O Nome do Funcionario: %s \n",i, rh[i].nome);
                printf("\t\t\tNo registro [%d] tem - O Cargo do Funcionario: %s \n",i, rh[i].cargo);
                printf("\t\t\tNo registro [%d] tem - O CPF do Funcionario: %s \n",i, rh[i].cpf);
                printf("\n");
                i++;
                if(i >= 2){
                    break;
                }
            }
        }

        ///MENU PRINCIPAL
        while(op != 0){
            printf("\n");
            printf("\t\t\t\t\t\t\t\tRegistros de Funcionários de uma Empresa\n");
            printf("\t\t\t|01| - Inserir funcionário.\n");
            printf("\t\t\t|02| - Alterar funcionário.\n");
            printf("\t\t\t|03| - Remover funcionário.\n");
            printf("\t\t\t|04| - Buscar funcionário por nome, CPF ou cargo: imprime os dados dos funcionários.\n");
            printf("\t\t\t|05| - Buscar funcionário por intervalo de salários: imprime os Nomes e CPFs.\n");
            printf("\t\t\t|06| - Imprimir o valor total de pagamento mensal de funcionários\n");
            printf("\t\t\t|07| - Imprimir os nomes e cargos de todos os funcionários\n");
            printf("\t\t\t|08| - Imprimir o funcionário com salário mais alto, o mais antigo na empresa e o mais velho.\n");
            printf("\t\t\t|00| - Encerrar\n\n");
            printf("\t\t\tDigite uma das opcoes acima: ");
            scanf("%d",&op);
            printf("\n");

            ///OPCAO DO MENU - 01;
            if(op == 1){
                if(iniciar(rh, 2)== 2){
                    printf("\t\t\tNumero maximo de funcionarios atingido! \n");
                }
                else{
                    printf("\t\t\tVocê digitou a opcão - |01| - Inserir Funcionário\n\n");
                        InserirF(rh,2);
                    }
            }///Fechamento do 1

            ///OPCAO DO MENU - 02;
            else if(op == 2){
                char a[11];
                printf("\t\t\tVocê digitou a opcão - |02| - Alterar um FUNCIONARIO\n");
                printf("\tPara alterar os dados digite o CPF do funcionário: ");
                fflush(stdin);
                scanf("%s",&a);
                alterarF(rh, 2, a, 11);
            }///Fechamento do 2

            ///OPCAO DO MENU - 03;
            else if(op == 3){
                char a[11];
                printf("\t\t\tVocê digitou a opcão - |03| - Remover funcionário.\n");
                printf("\tDigite o CPF do funcionário para remove-lo: ");
                fflush(stdin);
                scanf("%s",&a);
                removerF(rh, 2, a, 11);
            }///Fechamento do 3

            ///OPCAO DO MENU - 04;
            else if(op == 4){
                printf("\t\t\tVocê digitou a opcão - |04| - Buscar por Nome/CPF/Cargo do Funcionário.\n");
                int opcao = -1;
                while(opcao != 0){
                    printf("\t\t\t\tMENU\n");
                    printf("\t\t\t1 - Buscar por Nome do Funcionário\n");
                    printf("\t\t\t2 - Buscar por CPF\n");
                    printf("\t\t\t3 - Buscar por Cargo\n");
                    printf("\t\t\t0 - Sair\n");

                    printf("\t\t\tDigite uma das opcões:");
                    scanf("%d",&opcao);

                    if(opcao == 1){
                        char nome[50];
                        printf("\tDigite um nome de um Funcionario: ");
                        fflush(stdin);
                        scanf("%s",&nome);
                        buscarF_Nome_CPF_Cargo(rh, 2, nome, 50);
                    }
                    else if(opcao == 2){
                        char cpf[11];
                        printf("\tDigite o CPF de um Funcionário: ");
                        fflush(stdin);
                        scanf("%s",&cpf);
                        buscarF_Nome_CPF_Cargo(rh, 2, cpf, 11);

                    }
                    else if(opcao == 3){
                        char cargo[30];
                        printf("\tDigite o cargo de um Funcionário: ");
                        fflush(stdin);
                        scanf("%s",&cargo);
                        buscarF_Nome_CPF_Cargo(rh, 2, cargo, 30);
                    }
                    else if(opcao != 0){
                        printf("\t\t\tOpção digitada inválida\n");
                    }
                }//while
            }///Fechamento do 4

            ///OPCAO DO MENU - 05;
            else if(op == 5){
                printf("\t\tVocê digitou a opcão - |05| - Buscar por Funcionário por Intervalos de Salarios.\n");
                float min;
                float max;
                printf("\tDigite os 2 valores de Salarios\n");
                printf("\tDigite o Minimo de Salario: ");
                scanf("%f",&min);
                printf("\tDigite o Maximo de Salario: ");
                scanf("%f",&max);
                buscarF_Intervalo_Salario(rh,2,min,max);

            }///Fechamento do 5

            ///OPCAO DO MENU - 06;
            else if(op == 6){
                printf("\t\t\tVocê digitou a opcão - |06| - Imprimir o valor total de pagamento mensal de funcionários.\n");
                total_pagamento(rh, 2);

            }///Fechamento do 6

            ///OPCAO DO MENU - 07;
            else if(op == 7){
                printf("\t\t\tVocê digitou a opcão - |07| - Imprimir o Nome e CPF de todos os funcionarios.\n");
                imprimir_Nome_Cpf_Func(rh, 2);

            }///Fechamento do 7

            ///OPCAO DO MENU - 08;
            else if(op == 8){
                printf("\t\t\tVocê digitou a opcão - |08| - Imprimir o funcionário com salário mais alto, o funcionário mais antigo na empresa e o funcionário mais velho.\n");
                imprimir_Func_SalarioMaior_MaisAntigo_MaisVelho(rh, 2);

            }///Fechamento do 8

            ///OPCAO DO MENU - 09;
            else if(op == 0){
                printf("\t\t\tAté mais");

            }///Fechamento do 9

            ///OPCAO DO MENU - XY;
            else if(op != 0){
                printf("\t\t\tOpção inválida, digite novamente!\n");
            }

        }///FECHAMENTO DO WHILE;
    fclose(arquivo);//FECHANDO ARQUIVO;
}


