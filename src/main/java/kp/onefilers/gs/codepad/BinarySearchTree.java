package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class BinarySearchTree<T extends Comparable<T>> implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new BinarySearchTree().runProgram();
    }

    Node<T> root = null;

    @Override
    public void runProgram() {
        String strInput = KpLearnUtils.readInput("Insert tree data separated by space:");
        String[] strInputArr = strInput.split(" ");

        for (String str : strInputArr) {
            T data = (T)(str);
            addNode(data);
        }

        inOrder();
    }

    public void addNode(T data) {
        root = addNode(root, data);
    }

    private Node<T> addNode(Node<T> node, T data) {
        if (node == null) {
            return new Node<T>(data);
        }

        int c = node.data.compareTo(data);
        if (c == 0) {
            return node;
        } else if (c > 0) {
            node.left = addNode(node.left, data);
        } else if (c < 0) {
            node.right = addNode(node.right, data);
        }

        return node;
    }

    public void display() {
        display(root);
    }

    private void display(Node<T> node) {

    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(":"+node.data+":");
        inOrder(node.right);
    }

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            super();
            this.data = data;
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this(data);
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}
