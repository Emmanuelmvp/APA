package heapsort;

public class HeapSort {

    public void buildMaxHeap(int arr[]){
        int n = arr.length;
        
        for(int i = n/ 2 - 1;i >= 0; i--){
            maxHeapify(arr, n, i);
        }
        
        for(int i = n-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            maxHeapify(arr, i, 0);
        }
        
    }
    
    void maxHeapify(int arr[],int n, int i){
        int maior = i; 
        int l = 2*i + 1; //esquerda
        int r = 2*i + 2; // direito
        
        if(l < n && arr[l] > arr[maior]){
            maior = l;
        }
        
        if(r < n && arr[r] > arr[maior]){
            maior = r;
        }
        
        if(maior != i){
            int trocar = arr[i];
            arr[i] = arr[maior];
            arr[maior] = trocar; 
            
            maxHeapify(arr, n, maior);
        }
    }
    
    static void printArray(int arr[]){
        int n = arr.length;
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+ " ");
            }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
      int arr[] = {17,16,20,11,37,51,81,77,2};
      
      HeapSort h = new HeapSort();
      h.buildMaxHeap(arr);
      
      System.out.println("O array final é:");
      printArray(arr);
    }
    
}
