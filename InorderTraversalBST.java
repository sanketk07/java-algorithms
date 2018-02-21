package com.binarytree;

/**
 * @author sanketkumar
 * Question 3: Insert the following items into an empty binary search tree in order: 
	{30, 40, 23, 58, 48, 26, 11, 13}
 * 
 */
class TNode {

    int key;
    TNode leftTNode;
    TNode rightTNode;

    public TNode(int data) {
        this.key = data;
        leftTNode = rightTNode = null;
    }
}

class BinaryST {

    static TNode root;

    // Initialize root to be null at start
    BinaryST() {
        root = null;
    }

    public TNode insertBinaryST(TNode root, int key) {

        if (root == null) {

            root = new TNode(key);
            return root;
        }
        if (key < root.key) {

            root.leftTNode = insertBinaryST(root.leftTNode, key);

        } else if (key > root.key) {

            root.rightTNode = insertBinaryST(root.rightTNode, key);
        }

        return root;
    }

    public void inorderBinarySTTraversal(TNode root) {

        if (root != null) {

            inorderBinarySTTraversal(root.leftTNode);
            System.out.print(root.key + " ");
            inorderBinarySTTraversal(root.rightTNode);

        }

    }

    void inorder() {
        inorderBinarySTTraversal(root);
    }

    void insert(int key) {
        root = insertBinaryST(root, key);
    }
}

public class InorderTraversalBST {

    public static void main(String args[]) {
        BinaryST bst = new BinaryST();

        bst.insert(30);
        bst.insert(40);
        bst.insert(23);
        bst.insert(58);
        bst.insert(48);
        bst.insert(26);
        bst.insert(11);
        bst.insert(13);

        System.out.println("Inorder traversal of Binary Search Tree ==> ");
        bst.inorder();

    }
}
