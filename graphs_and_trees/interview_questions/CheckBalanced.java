/*
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */

import java.util.*;
import java.math.*;

public class CheckBalanced {

    static int treeDepth(Node root) {
        if(root == null) return -1;

        int leftDepth = treeDepth(root.leftChild);
        if(leftDepth == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightDepth = treeDepth(root.rightChild);
        if(rightDepth == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftDepth - rightDepth;
        if(Math.abs(heightDiff) > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(leftDepth, rightDepth) + 1;
    }

    static boolean isBalanced(Node root){
        return treeDepth(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        Node binaryTree = new Node(0);
        binaryTree.leftChild = new Node(1);
        binaryTree.rightChild = new Node(2);
        binaryTree.leftChild.leftChild = new Node(3);
        binaryTree.leftChild.rightChild = new Node(4);
        System.out.println(isBalanced(binaryTree));

        binaryTree = new Node(0);
        binaryTree.leftChild = new Node(1);
        binaryTree.rightChild = new Node(2);
        binaryTree.leftChild.leftChild = new Node(3);
        binaryTree.leftChild.rightChild = new Node(4);
        binaryTree.leftChild.leftChild.rightChild = new Node(4);
        System.out.println(isBalanced(binaryTree));

        binaryTree = new Node(0);
        System.out.println(isBalanced(binaryTree));
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