package binarytree;

/**
 * Sorting by big peak heap or small peak heap
 *
 * @author ACHENGE
 */
public class HeapSort {

    /**
     * Need to be sorted
     */
    private final int[] nums;

    /**
     * Distributed value to {@code nums} by constructor
     * @param nums sorted array
     */
    public HeapSort(int[] nums) {
        this.nums = nums;
    }

    /**
     * First build a big-peak-head form, and then exchange elements.Put biggest
     * element into the end of array
     */
    public void bigPeakHeap(){
        int length = nums.length;
        for(int index = length / 2 - 1;index >= 0;index--){
            bigPeakHeapSort(length, index);
        }
        int temp;
        while(length > 1){
            temp = nums[length - 1];
            nums[length - 1] = nums[0];
            nums[0] = temp;
            length--;
            bigPeakHeapSort(length, 0);
        }
        //System.out.println(Arrays.toString(nums));
    }

    /**
     * Sorting via big peak heap
     * @param length the length of sorted elements
     * @param pos big peak position
     */
    private void bigPeakHeapSort(int length, int pos){
        int temp = nums[pos];
        for(int i = 2 * pos + 1;i < length;i = 2 * i + 1){
            if(i + 1 < length && nums[i + 1] > nums[i]){
                i++;
            }
            if(nums[pos] < nums[i]){
                nums[pos] = nums[i];
                pos = i;
            }else {
                break;
            }
            nums[i] = temp; //finally making elements exchange,more fast!!
        }
    }
}
