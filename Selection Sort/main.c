#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void selectiontionSort(int arr[], int n){
    int i , j, minimo;

    for(i=0;i<n;i++){

        minimo = i;

        for(j=i+1;j<n;j++){
                if(arr[j] < arr[minimo])
                minimo = j;
        }
        troca(&arr[minimo], &arr[i]);
    }
    for (i=0; i < n; i++)
       printf("%d ", arr[i]);
    printf("\n");
}

void troca(int *xp, int *yp){
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
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
                    selectiontionSort(a, 8);
                    Sleep(5000);
                    break;

            case 2: system("cls");
                    printf("O array B tem o tamanho [5] e eh composto por: 8,6,2,5,1.\n");
                    selectiontionSort(b, 5);
                    Sleep(5000);
                    break;

            case 3: system("cls");
                    printf("O array C tem o tamanho [10] e eh composto por: 10,9,8,7,6,5,4,3,2,1.\n");
                    selectiontionSort(c, 10);
                    Sleep(5000);
                    break;
        }
    }while(escolha != 4);

}
