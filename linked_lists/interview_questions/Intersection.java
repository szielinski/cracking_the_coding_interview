class Intersection<T> {
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

    public void add(Node<T> item, int size){
        Node<T> n = new Node<>();
        n = item;

        if(head == null){
            head = n;
        } else {
            Node iter = head;
            while(iter.next != null)
                iter = iter.next;
            iter.next = n;
        }
        this.size += size;
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

    public Node<T> getNodeForTest(int i){
        int index = 0;

        Node<T> iter = head;
        while(iter != null && index < i){
            iter = iter.next;
            index++;
        }
        if(iter == null)
            throw new IndexOutOfBoundsException();
        return iter;
    }

    public int size(){
        return size;
    }

    public Node<T> checkForIntersection(Intersection<T> list){
        Node<T> thisIterator = head;
        Node<T> otherIterator = list.head;

        int thisSize = size;
        int otherSize = list.size;
        while(thisSize > otherSize){
            thisSize--;
            thisIterator = thisIterator.next;
        }
        while(otherSize > thisSize){
            otherSize--;
            otherIterator = otherIterator.next;
        }

        while(thisIterator.next != null){ 
            if(thisIterator == otherIterator){
                return thisIterator;
            }
            thisIterator = thisIterator.next;
            otherIterator = otherIterator.next;
        }
        return null;
    }
    
    public static void main(String[] args){
        Intersection<Integer> list = new Intersection<>();
        Intersection<Integer> list2 = new Intersection<>();
        Intersection<Integer> list3 = new Intersection<>();
        Intersection<Integer> list4 = new Intersection<>();

        for(int i=0; i<10; i++){
            list.add(i);
        }

        for(int i=0; i<4; i++){
            list2.add(i);
        }

        for(int i=0; i<5; i++){
            list3.add(i);
        }

        for(int i=0; i<8; i++){
            list4.add(i);
        }

        list2.add(list.getNodeForTest(5), 5);
        list3.add(list.getNodeForTest(8), 2);

        System.out.println(list.checkForIntersection(list2) + " " + list.checkForIntersection(list2).item);
        System.out.println(list.checkForIntersection(list3) + " " + list.checkForIntersection(list3).item);
        System.out.println(list.checkForIntersection(list4));
    }
}


