#include <stdio.h>
#include <stdlib.h>

int main()
{
    int insertionSort[8] = {5,7,10,4,1,3,8,6};
    int i , j, comparador;

    for(i=0;i<8;i++){
        comparador = insertionSort[i];
        j = i-1;
        //printf("comparador: %d e j %d\n", comparador, j);

        while (j>=0 && insertionSort[j] > comparador){
            insertionSort[j+1] = insertionSort[j];
            j = j-1;
        }
        insertionSort[j+1] = comparador;
    }
    for (i=0; i < 8; i++)
       printf("%d ", insertionSort[i]);
    printf("\n");
}
