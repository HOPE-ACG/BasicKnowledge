package pdd;

public class MaxSubArray {

    public static void main(String[] args) {

    }

    /**
     * dynamic programming version
     * @param nums inputted array
     * @return maximum of sum of sub array
     */
    private static int maxSubArray2(int[] nums) {

        return 0;
    }

    /**
     * design it by self
     * @param nums inputted array
     * @return maximum of sum of sub array
     */
    private static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] > 0) break;
            result = Math.max(result, nums[i++]);
        }
        int j = i;
        while(j < nums.length) {
            if(nums[j] > 0) {
                int curMax = 0;
                int sum = 0;
                for(int k = j; k < nums.length; k++) {
                    sum += nums[k];
                    if(nums[k] > 0) {
                        curMax = Math.max(curMax, sum);
                    }
                }
                result = Math.max(result, curMax);
            }
            j++;
        }
        return result;
    }
}
