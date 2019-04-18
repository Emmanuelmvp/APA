package algoritmomochila;

import java.util.Scanner;

public class AlgoritmoMochila {
    
    // função pra retornar o maximo entre dois valores 
    static int max(int a, int b) { return (a > b)? a : b; } 
       
     // Retona o valor maximo que pode ser colocado em uma mochila de capacidade P 
    void knapSack(int p, int peso[], int valor[], int n){ 
        int i, w; 
        int K[][] = new int[n+1][p+1]; 
       
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++){ 
            for (w = 0; w <= p; w++){ 
                if (i==0 || w==0) 
                    K[i][w] = 0; 
                else if (peso[i-1] <= w) 
                    K[i][w] = max(valor[i-1] + K[i-1][w-peso[i-1]],  K[i-1][w]); 
                else
                    K[i][w] = K[i-1][w]; 
            } 
        } 
       
        System.out.println("Solução: " + K[n][p]);
        
        int solucao[] = new int[n]; //array contendo itens que estão incluídos na solução
        i = 0;
   
        //extrai quais itens entram na solução
        for (; n>0 ; n--){
            if (K[n][p] <= 0)
                break;
            if (K[n][p] > K[n-1][p]){
                solucao[i] = n;
                ++i;
                p = p - peso[n-1];
            }
        }
        solucao[i] = -1;
   
        System.out.printf ("\nItens: ");
        System.out.printf("%d", solucao[0]);
        //printa os itens que estão na solução
        for (i = 1; (solucao[i] != -1); i++){
            System.out.printf(", ");
            System.out.printf("%d", solucao[i]);
        }
        System.out.printf(".");
   
   
   
   //-------------------------------------------------------------------------
    } 

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
           
        System.out.println("Informe o nome do arquivo:");
        String nome = ler.nextLine();
           
        String texto = Arquivo.Read(nome);
        
        if(texto.isEmpty()){
            System.out.println("Erro ao ler o arquivo.");
        }else{
            System.out.println(texto);
        }
        
        String N = texto.split(" ")[0];
        int n = Integer.parseInt(N); // quatidade de itens
        String P = texto.split(" ")[1];
        int p = Integer.parseInt(P); // peso da mochila
        
        int tamanho = (n+1)*2;
        
        int valor[] = new int[n]; // vetor com os valores 
        int peso[] = new int[n]; // vetor com os pesos
        
        int count_v = 0;
        int count_p = 0;
        
        //System.out.println("O numero de itens é: "+n);
        //System.out.println("O peso total da mochila é: " +p);
        //System.out.println(tamanho);
        
        for(int i=2;i<tamanho;i++){
            if(i%2 == 0){
                String m = texto.split(" ")[i];
                peso[count_p] = Integer.parseInt(m);
                count_p++;
            }else{
                String M = texto.split(" ")[i];
                valor[count_v] = Integer.parseInt(M);
                count_v++;
            }
        }
        
        /*for(int i=0;i<n;i++){
            System.out.print(peso[i] + " ");
        }*/
        
        AlgoritmoMochila x = new AlgoritmoMochila();
        x.knapSack(p, peso, valor, n);
    }
    
}
