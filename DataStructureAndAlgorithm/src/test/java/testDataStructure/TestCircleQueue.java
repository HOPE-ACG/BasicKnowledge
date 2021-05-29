package testDataStructure;

import arrayandqueue.CircleQueue;

import java.util.Scanner;

public class TestCircleQueue {

    public void testQueue() {
        System.out.print("输入创建数组的大小:");
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        CircleQueue queue = new CircleQueue(capacity);
        while(true){
            System.out.print("1:查看所有元素\n2:添加元素\n3:取出元素\n4:退出\n输入选项:");
            int chioce = scanner.nextInt();
            switch (chioce){
                case 1:
                    queue.presentAllElements();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("输入添加的元素:");
                    int element = scanner.nextInt();
                    queue.add(element);
                    break;
                case 3:
                    int element_takeout = queue.takeout();
                    if(element_takeout!=-100){
                        System.out.printf("取出的元素:%d\n", element_takeout);
                    }
                    break;
                case 4:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }
}
