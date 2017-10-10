import java.util.EmptyStackException;

public class StackOfPlates<T> {

    private static class SingleStack<T> {
        private static class Node<T> {
            private T item;
            private Node<T> next;

            public Node(T item){
                this.item = item;
            }
        }
        private Node<T> head;
        private int maxSize;
        private int itemCount = 0;

        public SingleStack(int maxSize){
            this.maxSize = maxSize;
        }

        public void push(T item){
            if(itemCount == maxSize)
                ;//NOP, throw new stack full exception
            Node<T> newNode = new Node<>(item);
            newNode.next = head;
            head = newNode;
            itemCount++;
        }

        public T pop(){
            if(head == null)
                throw new EmptyStackException();
            T t = head.item;
            head = head.next;
            itemCount--;
            return t;
        }

        public boolean isFull(){
            return itemCount == maxSize;
        }

        public boolean isEmpty(){
            return head == null;
        }
    }

    private Node<T> stacks;

    private static class Node<T>{
        private SingleStack<T> head;
        private Node<T> next;

        public Node(T item){
            head = new SingleStack<T>(4);
            head.push(item);
        }
    }

    public StackOfPlates(T item){
        stacks = new Node<>(item);
    }

    public StackOfPlates(){}

    public void push(T item){
        if(stacks == null){
            stacks = new Node<T>(item);
        } else if(stacks.head.isFull()){
            Node<T> newNode = new Node<T>(item);
            newNode.next = stacks;
            stacks = newNode;
        } else {
            stacks.head.push(item);
        }
    }

    public T pop(){
        if(stacks.head == null || stacks.head.isEmpty()){
            throw new EmptyStackException();
        }
        T item = stacks.head.pop();
        if(stacks.head.isEmpty() && stacks.next != null){
            stacks = stacks.next;
        }
        return item;
    }

    public boolean isEmpty(){
        return stacks.head == null;
    }

    public int size(){
        return stacks.head.itemCount;
    }

    public T popAt(int index){
        int count = 0;
        Node<T> stack = stacks;
        Node<T> previousStack = null;
        while(count < index){
            if(stack.next == null)
                throw new IndexOutOfBoundsException();
            previousStack = stack;
            stack = stack.next;
            count++;
        }
        T item = stack.head.pop();
        if(stack.head.isEmpty() && previousStack != null){
            previousStack.next = stack.next;
        }
        return item;
    }

    public static void main(String[] args){
        StackOfPlates<Integer> plates = new StackOfPlates<>();
        StackOfPlates<Integer> morePlates = new StackOfPlates<>();
        for(int i=0; i<100; i++){
            plates.push(i);
            morePlates.push(i);
        }
        System.out.println(morePlates.popAt(5));
        for(int i=0; i<100; i++){
            System.out.println(plates.pop() + " " + plates.size());
        }
        while(!morePlates.isEmpty()){
            System.out.println(morePlates.pop() + " " + morePlates.size());
        }
    }
}
