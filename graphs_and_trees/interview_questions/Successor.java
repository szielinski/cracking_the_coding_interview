/*
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent.
 */

import java.util.*;
import java.math.*;

public class Successor {

    // left subtree <= root < right subtree
    static Node nextNode(Node n){
        if(n == null) return null;

        if(n.rightChild != null){
            return leftmostChild(n.rightChild);
        }

        Node current = n;
        Node parent = n.parent;
        while(parent != null && current == parent.rightChild){
            current = parent;
            parent = current.parent;
        }
        return parent;
    }

    static Node leftmostChild(Node n){
        while(n.leftChild != null){
            n = n.leftChild;
        }
        return n;
    }

    public static void main(String[] args){
        Node binaryTree = new Node(12, null);
        binaryTree.leftChild = new Node(8, binaryTree);
        binaryTree.rightChild = new Node(14, binaryTree);
        binaryTree.rightChild.leftChild = new Node(13, binaryTree.rightChild);
        binaryTree.leftChild.leftChild = new Node(5, binaryTree.leftChild);
        binaryTree.leftChild.rightChild = new Node(10, binaryTree.leftChild);
        System.out.println(nextNode(binaryTree));
        System.out.println(nextNode(binaryTree.leftChild));
        System.out.println(nextNode(binaryTree.rightChild));
        System.out.println(nextNode(binaryTree.rightChild.leftChild));
        System.out.println(nextNode(binaryTree.leftChild.rightChild));
    }
}

class Node {
    Node leftChild;
    Node rightChild;
    Node parent;
    int data;

    Node(int data, Node parent){
        this.data = data;
        this.parent = parent;
    }

    public String toString(){
        return Integer.toString(data);
    }
}