package com.binarytree;

/**
 * @author sanketkumar
 * Question 2: Write the Java code implementation for finding the minimum element in a binary search tree for above tree. 
 * You may write either a recursive or iterative implementation.
 */
public class BinarySearchTree {
	
	public Node insertNewNode(Node node, char data) {
		
		if(node == null) {
			return new Node(data);
		}else {
			if(data < node.data) {
				node.left = insertNewNode(node.left, data);
			}else {
				node.right = insertNewNode(node.right, data);
			}
			
			return node;
		}
	
		
	}
	
	public char findMinValue(Node node) {
		
		Node current = node;
		
		while(current.left != null) {
			current = current.left;
		}
		
		return current.data;
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
        Node root = null;
        root = tree.insertNewNode(root, 'A');
        tree.insertNewNode(root, 'B');
		tree.insertNewNode(root, 'C');
		tree.insertNewNode(root, 'D');
		tree.insertNewNode(root, 'E');
		tree.insertNewNode(root, 'F');
		tree.insertNewNode(root, 'G');
		tree.insertNewNode(root, 'H');
		tree.insertNewNode(root, 'I');
		tree.insertNewNode(root, 'J');
		tree.insertNewNode(root, 'K');
       
        System.out.println("The minimum value in the binary search tree is ==> " + tree.findMinValue(root));
    }
	
	class Node {
		 
	    char data;
	    Node left, right;
	 
	    Node(char d) {
	        data = d;
	        left = right = null;
	    }
	}
}
