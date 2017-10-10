import java.util.Stack;
import java.util.Arrays;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> sortedStack = new Stack<>();

        while(!stack.isEmpty()){
            int item = stack.pop();
            while(!sortedStack.isEmpty() && item < sortedStack.peek()){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(item);
        }
        return sortedStack;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(2,8,3,4,10,9,5,7,2));
        System.out.println(sortStack(stack));
    }
}
