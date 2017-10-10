class SinglyLinkedList<T> {
    static class Node<T> {
        T item;
        Node<T> next;
    }

    Node<T> head;
    int size = 0;

    public void add(T item){
        Node<T> n = new Node<>();
        n.item = item;

        if(head == null){
            head = n;
        } else {
            Node iter = head;
            while(iter.next != null)
                iter = iter.next;
            iter.next = n;
        }
        size++;
    }

    public void remove(T item){
        Node<T> iter = head;
        Node<T> prev = head;
        while(iter != null && iter.item != item){
            prev = iter;
            iter = iter.next;
        }
        if(iter != null){
            if(iter == head){
                head = head.next;
            } else {
                prev.next = iter.next;
            }
            size--;
        }
    }

    public T get(int i){
        int index = 0;

        Node<T> iter = head;
        while(iter != null && index < i){
            iter = iter.next;
            index++;
        }
        if(iter == null)
            throw new IndexOutOfBoundsException();
        return iter.item;
    }

    public int size(){
        return size;
    }

    public void partition(int value){
        Node<T> leftPartition = null;
        Node<T> rightPartition = null;

        Node iter = head;
        while(iter != null){
            Node next = iter.next;
            Integer item = (Integer) iter.item; //TODO unsafe cast but expensive to re-code to only work with Integers
            if(item < value){
                if(leftPartition == null){
                    leftPartition = iter;
                    leftPartition.next = null;
                } else {
                    Node leftIter = leftPartition;
                    while(leftIter.next != null)
                        leftIter = leftIter.next;
                    leftIter.next = iter;
                    iter.next = null;
                }
            } else {
                if(rightPartition == null){
                    rightPartition = iter;
                    rightPartition.next =null;
                } else {
                    Node rightIter = rightPartition;
                    while(rightIter.next != null)
                        rightIter = rightIter.next;
                    rightIter.next = iter;
                    iter.next = null;
                }
            }
            iter = next;
        }
        Node leftIter = leftPartition;
        if(leftIter == null)
           head = rightPartition;
        else{
            while(leftIter.next != null){
                leftIter = leftIter.next;
            }
            leftIter.next = rightPartition;
            head = leftPartition;
        }
    }
}
public class Partition {

    public static void main(String[] args){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for(int i=10; i>=0; i--){
            list.add(i);
        }

        list.partition(4);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}


