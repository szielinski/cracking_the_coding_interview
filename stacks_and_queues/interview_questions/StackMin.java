import java.util.EmptyStackException;

public class StackMin<T extends Comparable> {
    private class Node<T> {
        private Node<T> next;
        private T data;
        private int min; //limited to integers, proper compareTo generic implementaion is costly

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> stack;

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if(stack == null){
            stack = newNode; 
            newNode.min = (Integer) data;
        } else {
            newNode.next = stack;
            stack = newNode;
            if(newNode.next.min < (Integer) data){
                newNode.min = newNode.next.min;
            } else {
                newNode.min = (Integer) data;
            }
        }
    }

    public T pop(){
        if(stack == null)
            throw new EmptyStackException();
        Node<T> topNode = stack;
        stack = stack.next;
        return topNode.data;
    }

    public boolean isEmpty(){
        return stack == null;
    }

    public int getMin(){
        return stack.min;
    }

    public static void main(String[] args){
       StackMin<Integer> s = new StackMin<>();
       s.push(5);
       s.push(10);
       s.push(3);
       s.push(10);
       s.push(4);
       for(int i=0; i<5; i++){
           System.out.println(s.getMin());
           s.pop();
       }
    }
}
