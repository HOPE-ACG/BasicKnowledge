package lookup;

/**
 * Flexible index,changing according to searching zone
 *
 * @author ACHENGE
 */
public class Interpolation {

    /**
     * Target array that must be in order
     */
    private final int[] nums;

    /**
     * Constructor with parameter of array
     *
     * @param nums the array that target exists in
     */
    public Interpolation(int[] nums){ this.nums = nums; }

    /**
     * The method that is used to find target in array
     *
     * @param target the value that need to be seeked
     * @param left left index of searching zone
     * @param right right index of searching zone
     *
     * @return the target's index in array
     */
    public int algorithm(int target, int left, int right){
        System.out.println("Interpolation");
        if(left > right || target > nums[nums.length-1] || target < nums[0]){ return -1; }
        if(target == nums[left]){ return left; }
        if(target == nums[right]){ return right; }
        //more efficient for elements distributing in balance
        int index = left + (right - left) * ((target - nums[left]) / (nums[right] - nums[left]));
        if(index < left || index > right){ return -1; }
        if(target > nums[index]){
            return algorithm(target, index + 1, right);
        }else if(target < nums[index]){
            return algorithm(target, left, index - 1);
        }else {
            return index;
        }
    }

}
