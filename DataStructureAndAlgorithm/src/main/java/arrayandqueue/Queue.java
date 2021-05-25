package arrayandqueue;

public class Queue {

    private int capacity = 5;
    private int front = -1;
    private int rear = -1;
    private final int[] array;

    public  Queue(){
        array = new int[capacity];
    }

    public Queue(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
    }

    //add element to array
    public void addElements(int element){
        if(rear==capacity-1){
            System.out.println("数组已满");
        }else {
            array[rear+1] = element;
            rear += 1;
        }
    }

    //take out element from array
    public int takeoutElement(){
        if(front==rear){
            System.out.println("数组中没有元素");
            return -100;
        }else {
            int element = array[front+1];
            front += 1;
            return element;
        }
    }

    //present all elements of array
    public void presentAllElements(){
        for(int ele : array){
            System.out.printf("%d\t",ele);
        }
    }

}
