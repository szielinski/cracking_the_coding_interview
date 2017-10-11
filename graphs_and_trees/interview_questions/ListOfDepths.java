/*
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 */

import java.util.*;

public class ListOfDepths {

    static LinkedList<Node>[] listOfDepths(Node root){
        LinkedList<Node>[] levels = new LinkedList[6];
        if(root == null) return levels;

        int currentLevel = 0;
        Queue<Node> nextLevelQueue = new ArrayDeque<>();
        nextLevelQueue.add(root);

        while(!nextLevelQueue.isEmpty()){
            Queue<Node> currentLevelQueue = nextLevelQueue;
            nextLevelQueue = new ArrayDeque<>();
            levels[currentLevel] = new LinkedList<>();
            while(!currentLevelQueue.isEmpty()){
                Node n = currentLevelQueue.remove();
                levels[currentLevel].add(n);
                if(n.leftChild != null) nextLevelQueue.add(n.leftChild);
                if(n.rightChild != null) nextLevelQueue.add(n.rightChild);
            }
            currentLevel++;
        }
        return levels;
    }

    public static void main(String[] args){
        Node binaryTree = new Node(0);
        binaryTree.leftChild = new Node(1);
        binaryTree.rightChild = new Node(2);
        binaryTree.leftChild.leftChild = new Node(3);
        binaryTree.leftChild.rightChild = new Node(4);
        binaryTree.rightChild.rightChild = new Node(5);
        binaryTree.leftChild.leftChild.leftChild = new Node(6);
        binaryTree.leftChild.leftChild.leftChild.leftChild = new Node(7);

        LinkedList<Node>[] levels = listOfDepths(binaryTree);
        for(int i=0; i< levels.length; i++){
            System.out.print("Level " + i + ": ");
            if(levels[i] == null) {
                System.out.println("null");
                return;
            }
            for(Node n : levels[i]){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    Node leftChild;
    Node rightChild;
    int data;

    Node(int data){
        this.data = data;
    }

    public String toString(){
        return Integer.toString(data);
    }
}