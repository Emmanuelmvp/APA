#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
//#define entrada "P-n16-k8.txt";

int main() {

	int i = 0, j = 0, k = 0, n, qtveiculo, qtcapacidade, ** peso, ** matrix_adj;
	const char* dimension[100], * pesos[500], * edge_weight[500], * veiculos[100], * capacidade[100];

	/*********************************
	Leitura do Arquivo
	*********************************/
	//FILE* arquivo = fopen(entrada,"r");
	FILE* arquivo = fopen("P-n16-k8.txt", "r");
	if (arquivo == NULL) {
		fprintf(stderr, "Erro ao abrir o arquivo.");
		return 1;
	}
	/********************************
	Pega a dimensão
	********************************/
	while (fscanf(arquivo, "%s", &dimension[i])) {
		if (!strcmp(&dimension[i], "DIMENSION:")) {
			fscanf(arquivo, "%d", &n);
			break;
		}
		i++;
	}
	printf("%s %d\n", &dimension[i], n);

	/********************************
	Pega o número de veículos
	********************************/
	while (fscanf(arquivo, "%s", &veiculos[i])) {
		if (!strcmp(&veiculos[i], "VEHICLES:")) {
			fscanf(arquivo, "%d", &qtveiculo);
			break;
		}
		i++;
	}
	printf("%s %d\n", &veiculos[i], qtveiculo);

	/********************************
	Pega o número da Capacidade
	********************************/
	while (fscanf(arquivo, "%s", &capacidade[i])) {
		if (!strcmp(&capacidade[i], "CAPACITY:")) {
			fscanf(arquivo, "%d", &qtcapacidade);
			break;
		}
		i++;
	}
	printf("%s %d\n", &capacidade[i], qtcapacidade);




	/*********************************
	Pega os pesos(valor da demanda)
	*********************************/
	peso = (int**)malloc(sizeof(int*) * n + 1);

	while (fscanf(arquivo, "%s", &pesos[i])) {
		if (!strcmp(&pesos[i], "DEMAND_SECTION:")) {
			for (i = 0; i < n; i++) {
				fscanf(arquivo, "%d", &k);
				fscanf(arquivo, "%d", &peso);
				printf("peso %d: %d ", i, peso);
				printf("\n");
			}
			break;
		}
		i++;
	}
	/********************************************
	Alocando memória para a matriz de adjacência
	********************************************/
	matrix_adj = (int**)malloc(sizeof(int*) * n + 1);
	for (i = 0; i <= n; i++) {
		matrix_adj[i] = (int*)malloc(sizeof(int) * n + 1);
	}

	/**************************************
	Pega a matriz de adjacência do arquivo
	**************************************/
	while (fscanf(arquivo, "%s", &edge_weight[i])) {
		if (!strcmp(&edge_weight[i], "EDGE_WEIGHT_SECTION")) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					fscanf(arquivo, "%d", &matrix_adj[i][j]);
					printf("%d ", matrix_adj[i][j]);
				}
				printf("\n");
			}
			break;
		}
		i++;
	}


	return 0;
}
