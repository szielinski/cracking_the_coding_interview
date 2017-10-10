import java.util.EmptyStackException;

public class QueueViaStacks<T> {
    static class MyQueue<T>{
        Stack<T> stack;
        Stack<T> queue;

        public MyQueue(){
            stack = new Stack<>();
            queue = new Stack<>();
        }

        public void add(T item){
            stack.push(item);
        }
        public T remove(){
            if(!queue.isEmpty())
                return queue.pop();
            while(!stack.isEmpty())
                queue.push(stack.pop());
            return queue.pop();
        }

        public boolean isEmpty(){
            return queue.isEmpty() && stack.isEmpty();
        }
    }

    static class Stack<T>{
        static class Node<T>{
            T item;
            Node<T> next;

            public Node(T item){
                this.item = item;
            }
            public Node(){}
        }
        private Node<T> stack;

        public Stack(){
            stack = new Node<>();
        }

        public Stack(T item){
            stack = new Node<>(item);
        }

        public T pop(){
            if(stack == null)
                throw new EmptyStackException();
            T item = stack.item;
            stack = stack.next;
            return item;
        }

        public void push(T item){
            Node<T> newNode = new Node<>(item);
            if(stack != null && stack.item != null){
                newNode.next = stack;
            }
            stack = newNode;
        }

        public boolean isEmpty(){
            return stack == null;
        }
    }

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();

        int counter = 0;
        for(int i=0; i<100; i++)
            queue.add(counter++);
        System.out.println("removing 50 elements");
        for(int i=0; i<50; i++)
            System.out.println(queue.remove());
        System.out.println("adding 50 elements");
        for(int i=0; i<50; i++)
            queue.add(counter++);
        System.out.println("removing all remaining elements");
        while(!queue.isEmpty())
            System.out.println(queue.remove());
    }
}
