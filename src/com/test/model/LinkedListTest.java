package com.test.model;

import com.test.utils.Constants;

public class LinkedListTest {
    private Node root;

    public static int getCount() {
        return count;
    }

    private static int count = 0;

    public Node getRoot() {
        return root;
    }

    public void setRoot(int val) {
        if(root !=null){
            root.setValue(val);
        }
        else{
            root = new Node(val);
        }
    }

    public void deleteLast() {
        if(isNotEmptyList()){
           Node temp = root;
           while(temp.nextNode.nextNode!=null){
               temp = temp.nextNode;
           }
           temp.nextNode = null;
           count--;
        }
    }

    public void deleteAtPos(int pos) {
        if(isNotEmptyList() && isNotInvalidPos(pos)){
            if(pos==count){
                deleteLast();
            }else{
                Node temp = root;
                Node prevTemp = root;
                int localPos = 1;
                while(temp.nextNode.nextNode !=null && localPos < pos-1){
                    temp = temp.nextNode;
                    localPos++;
                }
                Node nodeToBeDeleted = temp.nextNode;
                temp.nextNode = temp.nextNode.nextNode;
                nodeToBeDeleted.nextNode = null;
                count--;
            }
        }
    }

    private boolean isNotInvalidPos(int pos) {
        if(pos > 0 && pos <= count){
            return true;
        }else{
            System.out.println("Invalid position");
            return false;
        }
    }

    public boolean isNotEmptyList(){
        if(root == null) {
            System.out.println(Constants.EMPTY_LINKED_LIST);
            return false;
        }else{
            return true;
        }
    }
    public void print() {
        if(isNotEmptyList()){
            Node temp = root;
            while (temp.getNextNode() != null) {
                System.out.print(temp.getValue() + " --> ");
                temp = temp.getNextNode();
            }
            System.out.println(temp.getValue());
            System.out.print("Count :: " + getCount());
        }
    }

    public void deleteFirst() {
        if(isNotEmptyList()) {
            root = root.nextNode;
            System.out.print(Constants.FIRST_DELETE);
        }
    }

    public void addFirst(int val) {
        if(isNotEmptyList()){
            Node newNode = new Node(val);
            newNode.nextNode = root;
            root = newNode;
        }else{
            root = new Node(val);
        }
    }

    public void addAtPos(int pos, int val) {
        if(isNotEmptyList() && isNotInvalidPos(pos)){
            if (pos == 1){
                addFirst(val);
            }else if(pos == count){
                addLast(val);
            }else{
                Node temp = root;
                int localPos = 1;
                while(temp.nextNode.nextNode !=null && localPos < pos-1){
                    temp = temp.nextNode;
                    localPos++;
                }
                Node newNode = new Node(val);
                newNode.nextNode = temp.nextNode.nextNode;
                temp.nextNode = newNode;
            }
        }
    }

    public void addLast(int val) {
        if(isNotEmptyList()){
            Node temp = root;
            while(temp.nextNode!=null){
                temp = temp.nextNode;
            }
            temp.nextNode = new Node(val);
        }
    }

    public static class Node {
        private int value;
        private Node nextNode;

        public Node(int value) {
            this.value = value;
            this.nextNode = null;
            count++;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
