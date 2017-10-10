class DoublyLinkedList<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T item){
        Node<T> n = new Node<>();
        n.item = item;

        if(head == null){
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
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
                if(head != tail){
                    head.next.prev = null;
                } else {
                    tail = null;
                }
                head = head.next;
            } else if (iter == tail){
                tail.prev.next = null;
            } else {
                iter.next.prev = prev;
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


