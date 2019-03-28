package AlgoritmoPrim;

import java.util.Scanner;

public class AlgoritmoPrim {
    
    // função para achar o vertice com menor peso
    int minKey(int key[], Boolean mstSet[], int V) 
    { 
        
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    
    void printMST(int parent[], int n, int graph[][]) 
    { 
        int V = n;
        int total = 0;
        System.out.println("Aresta \tPeso"); 
        for (int i = 1; i < V; i++){ 
            System.out.println(parent[i]+" - "+ i+"\t"+ graph[i][parent[i]]);
            total = total + graph[i][parent[i]];
        }
        
        System.out.println("Custo minimo total: " + total);
    } 
   
    void primMST(int graph[][], int V) 
    { 
        //guarda a arvore construida 
        int parent[] = new int[V]; 
  
        // pega o menor valor entre os vertices examinados
        int key[] = new int [V]; 
  
        // Vertices ainda não incluidos 
        Boolean mstSet[] = new Boolean[V]; 
  
        // set todos os nos com valor maximo 
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        // Primeiro vertice 
        key[0] = 0;      
        parent[0] = -1;  
  
        // The MST will have V vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            // pega o vertice nao incluido na arvore de menor valor 
            int u = minKey(key, mstSet, V); 
  
            // adciona o vertice a arvore
            mstSet[u] = true; 

            // att o no e   parent do vertice nao incluidos na MST adjacentes aquele que foi selecionado    
            for (int v = 0; v < V; v++) 
  
                // graph[u][v] deve ser > 0 para vertices adjacentes  
                if (graph[u][v]!=0 && mstSet[v] == false && 
                    graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
   
        printMST(parent, V, graph); 
    }

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Informe o nome do arquvo:");
        String nome = ler.nextLine();
        
        String texto = Arquivo.Read(nome);
        
        if(texto.isEmpty()){
            System.out.println("Erro ao ler o arquivo.");
        }else{
            System.out.println(texto);
        }
        String v = texto.split(" ")[0]; // lê o primeiro valor como numero de V
        int V = Integer.parseInt(v); // transforma de string para int
        int soma = 0;
        
        for(int i = 0; i<V;i++){ // calculo para saber quantos numeros
            int n = i;           // vai ter no arquvio
            n = (V-1) - n;       // PS: nessa conta não está incluido o primeiro
            soma= soma + n;      // numero, no caso V
        }
        String a[] = texto.split(" "); // arrestas porem devemos começar do [1]
        int arr[] = new int[soma+1];   // pois V esta incluso aqui
        
        for(int i = 1;i<(soma+1);i++){
            arr[i] = Integer.parseInt(a[i]); // transformo de string para int
        }
        
        //zero a matriz
        int A[][] = new int[V][V];
        for(int i =0; i<V;i++){
            for(int j=0;j<V;j++){
                A[i][j] = 0;
            }
        }
        
        System.out.println();
        int start = 0;
        soma = 1; // um
        for(int i = 0; i<V;i++){            
            for(int j = start; j<V;j++){
                
                if(i==j){
                    A[i][j] = 0;
                    continue;
                }
                A[i][j] = A[j][i] = arr[soma];
                
                soma++;
            }
            start++;
        }
        
        for(int i =0; i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        
        AlgoritmoPrim x = new AlgoritmoPrim();
        x.primMST(A, V);
    }
    
}
