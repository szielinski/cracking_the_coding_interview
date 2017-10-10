public class ArrayList<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final int RESIZE_SCALING_FACTOR = 2;
    private T[] array;
    private int size;

    public ArrayList() {
        array = (T[]) (new Object[DEFAULT_SIZE]);
        size = 0;
    }

    public void add(T element){
        ensureCapacity(size+1);
        array[size] = element;
        size++;
    }

    public T get(int index){
        return array[index];
    }

    public int size(){
        return this.size;
    }

    public int getCurrentCapacity(){
        return array.length;
    }

    private void ensureCapacity(int size){
        if(this.array.length != size)
            return;
        resize();
    }

    private void resize(){
        T[] newArray = (T[]) (new Object[array.length*RESIZE_SCALING_FACTOR]);
        for(int i=0; i<array.length; i++)
            newArray[i] = array[i];
        array = newArray;
    }

    public static void main(String[] args){
        ArrayList<Integer> testArray = new ArrayList<>();
        for(int i=0; i<100; i++){
            System.out.println("Pre-add: Current array size " + testArray.size() + ". Current capacity " + testArray.getCurrentCapacity());
            testArray.add(i);
            System.out.println("Current array size " + testArray.size() + ". Current capacity " + testArray.getCurrentCapacity());
        }
        for(int i=testArray.size()-1; i>=0; i--){
            System.out.println(testArray.get(i));
        }
        System.out.println(testArray.get(150));
    }
}

