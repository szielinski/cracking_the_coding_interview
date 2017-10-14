/*
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */

import java.util.*;
import java.math.*;

public class ValidateBST {

    // left subtree <= root < right subtree
    static boolean isBST(Node root){
        if(root == null) return true;
        return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }

    static boolean isBST(int min, int max, Node n){
        if(n == null) return true;
        if(n.data < min || n.data > max) return false;
        // return isBST(min, Math.min(n.data, max), n.leftChild) && isBST(Math.max(n.data, min)+1, max, n.rightChild);
        return isBST(min, n.data, n.leftChild) && isBST(n.data+1, max, n.rightChild);
    }

    public static void main(String[] args){
        Node binaryTree = new Node(12);
        binaryTree.leftChild = new Node(8);
        binaryTree.rightChild = new Node(14);
        binaryTree.rightChild.leftChild = new Node(14);
        binaryTree.rightChild.leftChild.leftChild = new Node(14);
        binaryTree.leftChild.leftChild = new Node(5);
        binaryTree.leftChild.rightChild = new Node(10);
        System.out.println(isBST(binaryTree));

        binaryTree.rightChild.leftChild = new Node(13);
        System.out.println(isBST(binaryTree));

        binaryTree.leftChild.rightChild = new Node(12); //edge case only allowed when duplication is allowed
        System.out.println(isBST(binaryTree));

        binaryTree.rightChild.leftChild = new Node(12);
        System.out.println(isBST(binaryTree));

        binaryTree.rightChild.leftChild = new Node(14);
        binaryTree.rightChild.rightChild = new Node(14);
        System.out.println(isBST(binaryTree));

        binaryTree.rightChild.rightChild = new Node(15);
        binaryTree.leftChild.rightChild = new Node(13);
        System.out.println(isBST(binaryTree));
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