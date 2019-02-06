#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void merge(int arr[], int esq, int meio, int dir){
    int i, j, k;
    int a1 = meio - esq + 1;
    int a2 = dir - meio;

    int E[a1], D[a2];

    for(i=0; i<a1;i++){
        E[i] = arr[esq + i];
    }
    for(j=0; j < a2; j++){
        D[j] = arr[meio + 1 + j];
    }

    i = 0;
    j = 0;
    k = esq;
    while(i<a1 && j < a2){
        if(E[i]<= D[j]){
            arr[k] = E[i];
            i++;
        }
        else{
            arr[k] = D[j];
            j++;
        }
        k++;
    }

    while(i<a1){
        arr[k] = E[i];
        i++;
        k++;
    }

    while(j<a2){
        arr[k] = D[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int esq, int dir){
    if(esq < dir){
        int meio = esq+(dir-esq)/2;

        mergeSort(arr, esq, meio);
        mergeSort(arr, meio+1, dir);

        merge(arr, esq, meio, dir);
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
                    mergeSort(a, 0, 7);
                    printf("Sorted array: \n");
                    printArray(a, 8);
                    Sleep(10000);
                    break;

            case 2: system("cls");
                    printf("O array B tem o tamanho [5] e eh composto por: 8,6,2,5,1.\n");
                    mergeSort(b, 0, 4);
                    printf("Sorted array: \n");
                    printArray(b, 5);
                    Sleep(10000);
                    break;

            case 3: system("cls");
                    printf("O array C tem o tamanho [10] e eh composto por: 10,9,8,7,6,5,4,3,2,1.\n");
                    mergeSort(c, 0, 9);
                    printf("Sorted array: \n");
                    printArray(c, 10);
                    Sleep(10000);
                    break;
        }
    }while(escolha != 4);

}
