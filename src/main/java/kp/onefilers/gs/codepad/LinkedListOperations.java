package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.StringJoiner;

public class LinkedListOperations implements ProgramRunnerApp.ProgramRunner {
    private static Node root;

    public static void main(String[] args) {
        new LinkedListOperations().runProgram();
    }

    @Override
    public void runProgram() {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        print();
        reverse();
        print();
    }

    private static void reverse() {
        if (root == null || root.next == null) {
            return;
        }

        Node nextRoot = root.next, forward = null;
        root.next = null;

        while(nextRoot != null) {
            forward = nextRoot.next;
            nextRoot.next = root;
            root = nextRoot;
            nextRoot = forward;
        }
    }

    private static void add(Integer data) {
        Node newN = new Node(root,data);
        root = newN;
    }

    private static void print() {
        Node temp = root;
        StringJoiner sj = new StringJoiner(",");
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        System.out.println(sj.toString());
    }

    private static class Node {
        Node next;
        Integer data;

        Node(Node next, Integer data) {
            this.next = next;
            this.data = data;
        }
    }
}
