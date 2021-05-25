package lookup;

import util.AboutSearchAlgorithm;

import java.util.Arrays;

/**
 * Index locates Golden Segment Point
 *
 * @author ACHENGE
 */
public class Fibonacci {

    /**
     * Target array that must be in order
     */
    private final int[] nums;
    /**
     * Constructor with parameter of array
     *
     * @param nums the array that target exists in
     */
    public Fibonacci(int[] nums){ this.nums = nums;}

    /**
     * preparatory work before searching target location
     *
     * @param target the value that need to be seeked
     * @return the target's index in array
     */
    public int algorithm(int target){
        int[] fibo = AboutSearchAlgorithm.fibonacci(nums.length);
        int k = 0;
        while(k < fibo.length){
            if(nums.length < fibo[k] - 1){
                break;
            }
            k++;
        }
        int[] temp = Arrays.copyOf(nums, fibo[k] - 1);
        for(int index=nums.length;index<temp.length;index++){
            temp[index] = nums[nums.length-1];
        }
        int index =  search(temp, target, 0, temp.length - 1, fibo, k);
        return Math.min(index, nums.length - 1);
    }

    /**
     * The method that is used to find target in array
     *
     * @param array the array where target stay
     * @param target the value need to be seeked
     * @param left left index of searching zone
     * @param right right index of searching zone
     * @param fibo fibonacci array
     * @param fibo_index golden segment point
     *
     * @return the target's index in array
     */
    public int search(int[] array, int target, int left, int right, int[] fibo, int fibo_index){
        System.out.println("Fibonacci");
        if(left > right || target > array[array.length-1] || target < array[0]){ return -1; }
        if(target == array[left]){ return left; }
        if(target == array[right]){ return right; }
        int index = left + (fibo[fibo_index - 2] - 1);
        if(target > array[index]){
            return search(array, target, index + 1, right, fibo, fibo_index - 1);
        }else if(target < array[index]){
            return search(array, target, left, index - 1, fibo, fibo_index - 2);
        }else {
            return index;
        }
    }

}
