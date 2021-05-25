package testAlgorithm;

import sequence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSorted {

    public void testBubble(){ //7s/6s
        //int[] nums = {5,35,1,2,56,21,14,8};
        int[] nums = new int[80000];
        for(int i=0;i<nums.length/2;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        for(int i=nums.length/2;i<nums.length;i++){
            nums[i] = 6399;
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Bubble bubble = new Bubble(nums);
        bubble.algorithm();
        System.out.println(format.format(new Date()));
    }

    public void testSelected(){ //2s
        //int[] nums = {5,35,1,2,56,21,14,8};
        int[] nums = new int[80000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Selected selected = new Selected(nums);
        selected.algorithm();
        System.out.println(format.format(new Date()));
    }

    public void testInsert(){  //0.7s
        //int[] nums = {5,35,1,2,56,21,14,8};
        int[] nums = new int[80000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Insert insert = new Insert(nums);
        insert.algorithm();
        System.out.println(format.format(new Date()));
    }

    public void testHillExchange(){  //7s
        //int[] nums = {5,35,1,2,56,21,14,8};
        int[] nums = new int[80000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Hill hill = new Hill(nums);
        hill.algorithm();
        System.out.println(format.format(new Date()));
    }

    public void testHillMoving(){ //0.02s
        //int[] nums = {5,35,1,2,56,21,14,8};
        int[] nums = new int[80000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Hill hill = new Hill(nums);
        hill.algorithm_opt();
        System.out.println(format.format(new Date()));
    }

    public void testQuick(){ //0.02s
        //int[] nums = {5,35,1,2,56,21,14,8};
        int[] nums = new int[80000000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*8000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Quick speed = new Quick(nums);
        speed.algorithm(0, nums.length-1);
        //System.out.println(Arrays.toString(speed.getNums()));
        System.out.println(format.format(new Date()));
    }

    public void testMerge() { //0.011s  830ms
        //int[] nums = {5, 35, 1, 2, 56, 21, 14, 8};
        int[] nums = new int[8000000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Merge merge = new Merge(nums);
        merge.sort();
        System.out.print(format.format(new Date()));
    }

    public void testRadix(){ //0.03s  1.046s
        //int[] nums = {5, 35, 1, 2, 56, 21, 14, 8};
        int[] nums = new int[8000000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        Radix radix = new Radix(nums);
        radix.algorithm();
        System.out.print(format.format(new Date()));
    }
}
