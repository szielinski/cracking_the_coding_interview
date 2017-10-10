public class HashTable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int SCALING_FACTOR = 2;
    private static final double DEFAULT_LOAD_FACTOR = .6d;

    private T[] table;
    private int size;

    public HashTable(){
        table = (T[]) (new Object[DEFAULT_CAPACITY]);
        size = 0;
    }

    private int hash(T e, int tableSize){
        int hashCode = e.hashCode();
        if (hashCode < 0)
            hashCode *= -1;
        return hashCode % tableSize;
    }

    private void resize(){
        int newSize = table.length*SCALING_FACTOR;
        T[] largerArray = (T[]) (new Object[newSize]);
        for(T e: table){
            if(e != null)
                largerArray[hash(e,newSize)] = e; //todo: hash collision resolution
        }
        table = largerArray;
    }

    public void add(T e){
        if(size >= table.length * DEFAULT_LOAD_FACTOR)
            resize();
        table[hash(e,table.length)] = e;
        size++;
    }

    public T get(T e){
        return table[hash(e, table.length)];
    }

    public int size(){
        return size;
    }

    public void display(){
        for(int i=0; i<table.length; i++)
           System.out.println("["+i+"]="+table[i]);
    }

    public static void main(String[] args){
        HashTable<String> testTable = new HashTable<>();
        for(int i=0; i<100; i++){
            testTable.add("prefix string " + i);
        }
        testTable.display();
        //for(int i=testTable.size()-1; i>=0; i--){
        //    System.out.println("["+i+"]="+testTable.get(i));
        //}
    }
}

