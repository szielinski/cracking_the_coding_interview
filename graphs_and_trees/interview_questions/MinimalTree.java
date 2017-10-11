import java.util.*;

public class MinimalTree {
    public static void main(String[] args){
        int[] sortedData = new int[]{ 1, 3, 4 , 6, 7, 8, 10, 13, 14 };
        BinarySearchTree bst = new BinarySearchTree(sortedData);   
        System.out.println(bst);
    }
}

class BinarySearchTree {
    Node root;

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data){
            this.data = data;
        }
    }

    //data sorted in increasing order
    BinarySearchTree(int[] sortedData){
        root = populateFromSortedArray(sortedData);
    }
    
    private static Node populateFromSortedArray(int[] sortedData){
        if(sortedData.length == 0)
            return null;
        int midIndex = sortedData.length/2;
        Node n = new Node(sortedData[midIndex]);
        n.leftChild = populateFromSortedArray(Arrays.copyOfRange(sortedData, 0, midIndex));
        if(midIndex+1 <= sortedData.length)
            n.rightChild = populateFromSortedArray(Arrays.copyOfRange(sortedData, midIndex+1, sortedData.length));
        return n;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Queue<Node> currentLevelQueue = new ArrayDeque<>();
        Queue<Node> nextLevelQueue = new ArrayDeque<>();
        nextLevelQueue.add(root);
        while(!nextLevelQueue.isEmpty()){
            currentLevelQueue = nextLevelQueue;
            nextLevelQueue = new ArrayDeque<>();
            while(!currentLevelQueue.isEmpty()){
                Node n = currentLevelQueue.remove();
                sb.append(n.data).append(" ");
                if(n.leftChild != null)
                    nextLevelQueue.add(n.leftChild);
                if(n.rightChild != null)
                    nextLevelQueue.add(n.rightChild);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}