package algoritmodijkstra;

import java.util.Scanner;

public class AlgoritmoDijkstra {
    
    int minDistance(int dist[], Boolean sptSet[], int V) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
   
    void printSolution(int dist[], int n) 
    { 
        int V = n;
        System.out.println("Vertice   Distancia ate o inicio"); 
        for (int i = 0; i < V; i++){ 
            System.out.println(i+"         "+dist[i]);
        }
    } 
  
 
    void dijkstra(int graph[][], int src, int V) 
    { 
        int dist[] = new int[V]; // arr. dist[i] segura a menor distancia de  
                                 // src para i 
        
        // sptSet [i] será verdadeiro se o vértice i for incluído no menor
        // caminho da árvore ou menor distância de src para i é finalizado
        Boolean sptSet[] = new Boolean[V]; 
  
        // Inicio todas as distancia para infinito e sptSet[] false 
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // Distancia do vertice fonte de si mesmo eh sempre zero 
        dist[src] = 0; 
  
        // encontre o caminho mais curto para todos os vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            // Escolha o vértice de distância mínima do conjunto de vértices
            // ainda não processado. u é sempre igual a src na primeiro
            // iteração.
            int u = minDistance(dist, sptSet, V); 
            
            // Marcar o vértice escolhido como processado 
            sptSet[u] = true; 
  
            // Atualiza o valor de dist dos vértices adjacentes do
            // escolheu vértice.
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 

        printSolution(dist, V); 
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
        
        AlgoritmoDijkstra x = new AlgoritmoDijkstra();
        x.dijkstra(A, 0, V);
    }
    
}
