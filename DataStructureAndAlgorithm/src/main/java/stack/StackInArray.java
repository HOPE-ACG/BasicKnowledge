package stack;

import java.util.EmptyStackException;

public class StackInArray {
    /*
    * Implement stack model by array
    * @para top point stack's top
    * @para cities simulate stack to save elements
    * */
    private int top = -1;
    private final int maxSize;
    private final String[] eles;

    public int getTop() {
        return top;
    }

    public String[] getEles() {
        return eles;
    }

    public StackInArray(int size){
        maxSize = size;
        eles = new String[maxSize];
    }

    //Stack is full
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //Stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    //push element
    public void push(String ele){
        if(isFull()){
            throw new RuntimeException("Stack has been full");
        }
        top += 1;
        eles[top] = ele;
    }

    //pop element
    public String pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        String retVal = eles[top];
        top -= 1;
        return retVal;
    }

    //all elements
    public void all(){
        int temp = top;
        while(temp!=-1){
            System.out.printf("city"+(temp+1)+":%s;", eles[temp]);
            temp--;
        }
        System.out.println();
    }
}
