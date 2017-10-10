class SinglyLinkedList<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
    }

    private Node<T> head;
    private int size = 0;

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
    
    public static void main(String[] args){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for(int i=0; i<10; i++){
            list.add(i);
        }

        list.remove(5);
        list.remove(0);
        list.remove(10);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}


