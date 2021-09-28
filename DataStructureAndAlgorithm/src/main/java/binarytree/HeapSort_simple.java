package binarytree;

import java.util.Arrays;

/**
 * relatively simple algorithm
 *
 * @author ACHENGE
 */
public class HeapSort_simple {

    public static void main(String[] args) {

        HeapSort_simple heap = new HeapSort_simple();
        int[] nums = new int[]{1, 2, 5, 9, 1, 20, 18};
        System.out.println(heap.bigHeap(nums, 5));
        System.out.println(Arrays.toString(nums));
    }

    public int bigHeap(int[] nums, int k) {
        int size = nums.length - 1;
        buildBigHeap(nums, size);
        for(int i = size; i > 0; i--) {
            swap(nums, 0, i);
            heapSort(nums, 0, i - 1);
        }
        return nums[nums.length - k];
    }

    /**
     * build top heap constructor
     * @param nums target array
     * @param length the length of that is need to be sorted
     */
    public void buildBigHeap(int[] nums, int length) {

        int p = length / 2;
        for(int i = p; i >= 0; i--) {
            heapSort(nums, i, length);
        }
    }

    /**
     * sort algorithm
     * @param nums target array
     * @param p start position
     * @param length the length of that is need to be sorted
     */
    public void heapSort(int[] nums, int p, int length) {
        int l = 2 * p + 1, r = 2 * p + 2, top = p;
        if(l <= length && nums[l] > nums[top]) top = l;
        if(r <= length && nums[r] > nums[top]) top = r;
        if(p != top) {
            swap(nums, p, top);
            heapSort(nums, top, length);
        }
    }

    /**
     * swap two elements int the array
     * @param nums target array
     * @param p1 one position
     * @param p2 the other position
     */
    public void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
