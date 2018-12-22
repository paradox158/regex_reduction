package com.regex.base;

/**
 * @author komar
 * @version 1.0
 */
public class Node {
    private String  value;
//    protected

    private Node leftChild;
    private Node rightChild;

    Node(String value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    private void CreateLevel(int string_position)
    {
        leftChild = new Node(value.substring(0, string_position));
        rightChild = new Node(value.substring(string_position + 1));
        value = value.substring(string_position, string_position + 1);

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
