package lookup;

/**
 * Search target from beginning to end, sequence must be in order
 *
 * @author ACHENGE
 */
public class Linear {
    /**
     * Target array that must be in order
     */
    private final int[] nums;

    /**
     * Constructor with parameter of array
     *
     * @param nums the array that target exists in
     */
    public Linear(int[] nums) { this.nums = nums; }

    /**
     * The method that is used to find target in array
     *
     * @param target the value that need to be seeked
     *
     * @return the target's index in array
     */
    public int algorithm(int target){
        if(target > nums[nums.length-1] || target < nums[0]){
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

}
