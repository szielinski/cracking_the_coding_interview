public class ThreeInOne<T> {
    private T[] data;
    private int[] offset = new int[3];
    private int arraySize;

    public ThreeInOne(int size){
        data = (T[]) (new Object[size*3]);
        arraySize = size;
        offset[0] = 0;
        offset[1] = getStartIndex(size, 1);
        offset[2] = getStartIndex(size, 2);
    }

    public void add(int arrayNo, T data){
        if(offset[arrayNo] >= getStartIndex(arraySize, arrayNo+1))
            throw new IndexOutOfBoundsException();
        this.data[offset[arrayNo]] = data;
        offset[arrayNo]++;
    }

    public T get(int index, int arrayNo){
        if(getStartIndex(arraySize, arrayNo) + index >= offset[arrayNo])
            throw new IndexOutOfBoundsException();
        return data[getStartIndex(arraySize, arrayNo) + index];
    }
    
    private int getStartIndex(int size, int arrayNo){
        return size * arrayNo;
    }

    public static void main(String[] args){
        ThreeInOne<String> data = new ThreeInOne<>(6);
        try{
            int j = 0;
            for(Integer i = 0; i<20; i++){
                data.add(j, i.toString());
                j = (j+1)%3;
            }
        } catch(IndexOutOfBoundsException e) {
            for(int j=0; j<3; j++){
                for(int i = 0; i < 6; i++){
                    System.out.println(data.get(i, j));
                }
            }
        }
    }
}

