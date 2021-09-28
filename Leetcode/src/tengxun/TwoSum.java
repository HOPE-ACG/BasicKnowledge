package tengxun;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 2, 4};
        int[] res = twoSum.twoSum(nums, 6);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(twoSum.twoSum2(nums, 6)));
    }

    public int[] twoSum(int[] nums, int target) {

        int[] clone = nums.clone();
        Arrays.sort(clone);
        for(int i = 0; i < nums.length - 1; i++) {
            int tar = target - nums[i];
            int sym = binaryFind(tar, 0, nums.length - 1, clone);
            if(sym != -1) {
                for(int j = 0; j < nums.length; j++) {
                    if(nums[j] == tar && j != i) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{0};
    }

    public int binaryFind(int tar, int l, int r, int[] clone) {

        int m = (l + r) / 2;
        if(l <= r) {
            if(clone[m] > tar) return binaryFind(tar, l, m - 1, clone);
            else if(clone[m] < tar) return binaryFind(tar, m + 1, r, clone);
            else return m;
        }
        return -1;
    }

    /**
     * very simple, more profound
     * @param nums original array
     * @param target sum
     * @return two subscript
     */
    public int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
