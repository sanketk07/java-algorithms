package com.homework5.sanket;

/**
 *
 * @author sanketkumar
 */
public class BTree
{

    public static void main(String args[]) {
    		BTreeMain bTree = new BTreeMain();
    		bTree.start();
    }
}

class BTreeMain {

    public void start() {
        Tree root;
        boolean b;

        root = new Tree();
        b = root.init(3);
        System.out.println(7);
        b = root.printTree();
        System.out.println("\n");
        System.out.println("---------------------------------");
        System.out.println("Tree after inserting the data is: ");
        System.out.println("---------------------------------");
        b = root.insertNewElement(9);
        b = root.insertNewElement(23);
        b = root.insertNewElement(45);
        b = root.insertNewElement(1);
        b = root.insertNewElement(5);
        b = root.insertNewElement(14);
        b = root.insertNewElement(5);
        b = root.insertNewElement(24);
        b = root.insertNewElement(13);
        b = root.insertNewElement(11);
        b = root.insertNewElement(8);
        b = root.insertNewElement(19);
        b = root.insertNewElement(4);
        b = root.insertNewElement(31);
        b = root.insertNewElement(35);
        b = root.insertNewElement(56);

        b = root.printTree();
    }

}

class Tree {

    Tree left;
    Tree right;
    int key;
    boolean hasLeft;
    boolean hasRight;
    Tree isNull;

    public boolean init(int v_key) {
        key = v_key;
        hasLeft = false;
        hasRight = false;
        return true;
    }

    public boolean setRight(Tree rn) {
        right = rn;
        return true;
    }

    public boolean setLeft(Tree ln) {
        left = ln;
        return true;
    }

    public Tree getRight() {
        return right;
    }

    public Tree getLeft() {
        return left;
    }

    public int getKey() {
        return key;
    }

    public boolean setKey(int v_key) {
        key = v_key;
        return true;
    }

    public boolean getHasRight() {
        return hasRight;
    }

    public boolean getHasLeft() {
        return hasLeft;
    }

    public boolean setHasLeft(boolean val) {
        hasLeft = val;
        return true;
    }

    public boolean setHasRight(boolean val) {
        hasRight = val;
        return true;
    }

    public boolean compare(int num1, int num2) {
        boolean b;
        int nti;

        b = false;
        nti = num2 + 1;
        if (num1 < num2) {
            b = false;
        } else if (!(num1 < nti)) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }

    public boolean insertNewElement(int v_key) {
        Tree new_node;
        boolean b;
        boolean cont;
        int keyValue;
        Tree cNode;

        new_node = new Tree();
        b = new_node.init(v_key);
        cNode = this;
        cont = true;
        while (cont) {
            keyValue = cNode.getKey();
            if (v_key < keyValue) {
                if (cNode.getHasLeft()) {
                    cNode = cNode.getLeft();
                } else {
                    cont = false;
                    b = cNode.setHasLeft(true);
                    b = cNode.setLeft(new_node);
                }
            } else {
                if (cNode.getHasRight()) {
                    cNode = cNode.getRight();
                } else {
                    cont = false;
                    b = cNode.setHasRight(true);
                    b = cNode.setRight(new_node);
                }
            }
        }
        return true;
    }

    public boolean printTree() {
        Tree cNode;
        boolean b;

        cNode = this;
        b = this.printRec(cNode);
        return true;
    }

    public boolean printRec(Tree node) {
        boolean b;

        if (node.getHasLeft()) {
            b = this.printRec(node.getLeft());
        } else {
            b = true;
        }
        System.out.println(node.getKey());
        if (node.getHasRight()) {
            b = this.printRec(node.getRight());
        } else {
            b = true;
        }
        return true;
    }
}
