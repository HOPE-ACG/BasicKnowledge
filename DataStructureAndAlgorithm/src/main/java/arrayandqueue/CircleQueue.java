package arrayandqueue;

public class CircleQueue {

    private int front = 0;
    private int rear = 0;
    private int capacity = 5;
    private final int[] array;

    public CircleQueue(){
        array = new int[capacity];
    }

    public CircleQueue(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
    }

    //添加元素
    public void add(int element){
        if((rear+1)%capacity==front){
            System.out.println("队列已满");
        }else {
            array[rear]=element;
            rear=(rear+1)%capacity;
        }
    }

    //取出元素
    public int takeout(){
        int result;
        if(front==rear){
            System.out.println("队列为空");
            return -100;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
        }else {
            result=array[front];
            front=(front+1)%capacity;
        }
        return result;
    }

    //查看所有元素
    public void presentAllElements(){
        //队列中有效数据个数
        int validData = (rear-front+capacity)%capacity;
        //遍历
        int i = front;
        for(;i<front+validData;i++){
            System.out.printf("%d\t",array[i%capacity]);
        }
    }

}
