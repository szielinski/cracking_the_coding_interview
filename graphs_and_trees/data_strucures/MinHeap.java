import java.util.Arrays;

class MinHeap {
    int[] heap = new int[20];

    int size = 0;

    public void insert(int number){
        if(size == heap.length - 1) expand();

        int pos = ++size;
        
        for(;pos > 1 && number < heap[pos/2]; pos = pos/2)
            heap[pos] = heap[pos/2];

        heap[pos] = number;
    }

    public void expand(){
        heap = Arrays.copyOf(heap, heap.length*2);
    }

    public int getMin(){
        return heap[1];
    }

    public int removeMin(){
       int item = heap[1];

       heap[1] = heap[size];
       size--;
       
       int currentPos = 1;
       while(currentPos*2<=size && heap[currentPos] > heap[currentPos*2] || currentPos*2+1<=size && heap[currentPos] > heap[currentPos*2+1]){
           if(heap[currentPos*2] < heap[currentPos*2+1]){
               int tmp = heap[currentPos*2];
               heap[currentPos*2] = heap[currentPos];
               heap[currentPos] = tmp;
               currentPos = currentPos*2;
           } else {
               int tmp = heap[currentPos*2+1];
               heap[currentPos*2+1] = heap[currentPos];
               heap[currentPos] = tmp;
               currentPos = currentPos*2+1;
           }
       }
       return item;
    }

    public static void main(String[] args){
        MinHeap heap = new MinHeap();

        for(int i=20;i>0;i--){
            heap.insert(i);
            System.out.println(heap.getMin());
        }
        for(int i=20;i>0;i--){
            System.out.println(heap.removeMin());
        }
    }
}
