import java.util.EmptyStackException;

public class Stack<T> {
    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item){
            this.item = item;
        }
    }

    private Node<T> head;

    public T pop(){
        if(head == null)
            throw new EmptyStackException();
        T item = head.item;
        head = head.next;
        return item;
    }

    public void push(T item){
        Node<T> newHead = new Node<>(item);
        newHead.next = head;
        head = newHead;
    }

    public T peek() {
        if(head == null)
            throw new EmptyStackException();
        return head.item;
    }

    public boolean isEmpty(){
        return head == null;
    }
}

        

