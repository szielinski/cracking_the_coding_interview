import java.util.NoSuchElementException;

public class Queue<T> {
    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item){
            this.item = item;
        }
    }

    private Node<T> front;
    private Node<T> end;

    public void add(T item){
        Node<T> newNode = new Node<T>(item);
        if(front == null){
            front = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
    }


    public T remove(){
        if(front == null)
            throw new NoSuchElementException();
        T item = front.item;
        front = front.next;
        if(front == null)
            end = null;
        return item;
    }

    public T peek(){
        if(front == null)
            throw new NoSuchElementException();
        return front.item;
    }

    public boolean isEmpty(){
        return front == null;
    }
}
