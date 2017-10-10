import java.util.*;

class RemoveDups {
    public static void removeDupsWithBuffer(List<? extends Object> l){
        HashMap<Object, Integer> counts = new HashMap<>();
        for(Object o : l){
            if(counts.containsKey(o))
                counts.put(o, counts.get(o)+1);
            else
                counts.put(o, 1);
        }
        for(Object key : counts.keySet()){
            int instanceCount = counts.get(key);
            while(instanceCount > 1){
                l.remove(key);
                instanceCount--;
            }
        }
    }

    public static void removeDupsWithoutBuffer(List<? extends Object> l){
        for(int i=0; i<l.size(); i++){
            for(int j=i+1; j<l.size();){
                if(l.get(i) == l.get(j)){
                    l.remove(j);
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(5);

        removeDupsWithoutBuffer(list);

        System.out.println(list);
    }
}
