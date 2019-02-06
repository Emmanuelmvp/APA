#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void troca(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

int particao(int arr[], int menor, int maior){
    int pivo = arr[maior]; // meu pivo
    int i = (menor - 1); // indice do menor elemento
    int j;
    for(j = menor; j <= maior - 1; j++){
        if(arr[j] <= pivo){
            i++;
            troca(&arr[i],&arr[j]);
        }
    }
    troca(&arr[i+1],&arr[maior]);
    return (i+1);
}

void quickSort(int arr[], int menor, int maior){
    if(menor<maior){
        int pi = particao(arr, menor, maior);

        quickSort(arr, menor, pi -1);
        quickSort(arr, pi+1, maior);
    }
}


void printArray(int arr[], int tamanho)
{
    int i;
    for (i=0; i < tamanho; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main()
{
    int a[8] = {5,7,10,4,1,3,8,6};
    int b[5] = {8,6,2,5,1};
    int c[10] = {10,9,8,7,6,5,4,3,2,1};

    int escolha;

    do{
        system("cls");
        printf("Digite 1 um para o array A.\n");
        printf("Digite 2 um para o array B.\n");
        printf("Digite 3 um para o array C.\n");
        printf("Digite 4 para sair.\n");
        scanf("%d", &escolha);

        switch(escolha){

            case 1: system("cls");
                    printf("O array A tem o tamanho [8] e eh composto por: 5,7,10,4,1,3,8,6.\n");
                    quickSort(a, 0, 7);
                    printf("Sorted array: \n");
                    printArray(a, 8);
                    Sleep(10000);
                    break;

            case 2: system("cls");
                    printf("O array B tem o tamanho [5] e eh composto por: 8,6,2,5,1.\n");
                    quickSort(b, 0, 4);
                    printf("Sorted array: \n");
                    printArray(b, 5);
                    Sleep(10000);
                    break;

            case 3: system("cls");
                    printf("O array C tem o tamanho [10] e eh composto por: 10,9,8,7,6,5,4,3,2,1.\n");
                    quickSort(c, 0, 9);
                    printf("Sorted array: \n");
                    printArray(c, 10);
                    Sleep(10000);
                    break;
        }
    }while(escolha != 4);

}

