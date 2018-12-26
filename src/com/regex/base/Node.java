package com.regex.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author komar
 * @version 1.0
 */
public class Node {
    public String  value;
    public Integer position;

    public Node leftChild;
    public Node rightChild;

    public boolean nullable;
    public List<Integer> firstPos;
    public List<Integer> lastPos;

    Node(String value){
        this.value = value;
        leftChild = null;
        rightChild = null;
        position = null;
        firstPos = new ArrayList<>();
        lastPos = new ArrayList<>();
        Separate();
    }

    private void Separate(){
        if (value.charAt(0) == '(' && value.charAt(value.length()-1) == ')'){
            value = value.substring(1, value.length()-2);
        }
        int pos = LowestLevelSearch();
        switch (value.charAt(pos)){
            case '|':
            case '.':
                leftChild = new Node(value.substring(0,pos-1));
            case '*':
                rightChild = new Node(value.substring(pos+1));
                value = value.substring(pos, pos+1);
                break;
            default:
                break;
            }
        }

        protected void FindFunctions(){
            switch (value){
                case "|":
                    nullable = leftChild.nullable || rightChild.nullable;

                    break;
                case "*":
                    nullable = true;

                    break;
                case ".":
                    nullable = leftChild.nullable && rightChild.nullable;

                    break;
                default:
                    nullable = false;

                    break;
            }
        }

    private int LowestLevelSearch(){
        int position = -1;
        int priority = -1;
        int tempPriority;
        List<Integer> symbols = new ArrayList<>();
        int brakets = 0;
        char[] valueArray = value.toCharArray();
        for (int i = 0; i < valueArray.length; i++) {
            switch (valueArray[i]){
                case '(':
                    brakets++;
                    break;
                case ')':
                    brakets--;
                    break;
                case '.':
                    tempPriority = 3;
                    if (tempPriority > priority){
                        priority = tempPriority;
                        position = i;
                    }
                    break;
                case '|':
                    tempPriority = 2;
                    if (tempPriority > priority){
                        priority = tempPriority;
                        position = i;
                    }
                    break;
                case '*':
                    tempPriority = 1;
                    if (tempPriority > priority){
                        priority = tempPriority;
                        position = i;
                    }
                    break;
                default:
                    symbols.add(i);
            }
        }
        return position;
    }


//        String string = "(a(b|c))*c";
//        String[] testString = value.split("");
//        String[] results = new String[2];
//        for (int i = 0, count = 0, countPosition = -1; i < testString.length; i++) {
//            switch (testString[i]){
//                case "(":
//                    count++;
//                    if (countPosition == -1){
//                        countPosition = i;
//                    }
//                    break;
//                case ")":
//                    count--;
//                    if (count == 0){
//                        if(i < testString.length && testString[i+1].equals("*")){
//                            leftChild = new Node(value.substring(countPosition, i+2));
//                            rightChild = new Node(value.substring(i+2));
//                            value =
//                        }
//                        else {
//                            leftChild = new Node(value.substring(countPosition, i+1));
//                            rightChild = new Node(value.substring(i+1));
//                        }
//                    }
//            }
//        }


    public void CreateLevel(int string_position)
    {
        leftChild = new Node(value.substring(0, string_position));
        rightChild = new Node(value.substring(string_position + 1));
        value = value.substring(string_position, string_position + 1);
    }
}
