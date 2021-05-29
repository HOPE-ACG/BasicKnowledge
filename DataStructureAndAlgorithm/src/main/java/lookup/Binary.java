package lookup;

/**
 * Search target in the middle of searching zone
 *
 * @author ACHENGE
 */
public class Binary {

    /**
     * Target array that must be in order
     */
    private final int[] nums;

    /**
     * Constructor with parameter of array
     *
     * @param nums the array that target exists in
     */
    public Binary(int[] nums){ this.nums = nums; }

    /**
     * The method that is used to find target in array
     *
     * @param target the value that need to be seeked
     * @param left   left index of searching zone
     * @param right  right index of searching zone
     * @return the target's index in array
     */
    public int algorithm(int target, int left, int right) {

        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }
        while (left < right) {
            if (target == nums[left]) {
                return left;
            }
            if (target == nums[right]) {
                return right;
            }
            int index = (left + right) / 2;
            if (target > nums[index]) {
                left = index + 1;
            } else if (target < nums[index]) {
                right = index - 1;
            } else {
                return index;
            }
        }
        return -1;
    }

    /**
     * By recursion of binary search, find out target's position
     *
     * @param target the value that need to be seeked
     * @param left   left index of searching zone
     * @param right  right index of searching zone
     * @return the target's index in array
     */
    public int algorithm_recursion(int target, int left, int right) {

        if (target < nums[left] || target > nums[right]) {
            return -1;
        }
        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        } else if(right - left < 2) {
            return -1;
        }

        int index = (left + right) / 2;
        if (target > nums[index]) {
            return algorithm_recursion(target, index, right);
        } else if (target < nums[index]) {
            return algorithm_recursion(target, left, index);
        } else {
            return index;
        }
    }
}
