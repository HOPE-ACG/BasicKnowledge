package tengxun;

import java.util.Arrays;

public class FindKthLargest {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,1,5,6,4};
        diAndCon(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void diAndCon(int left, int right, int[] nums) {
        if(left < right) {
            int m = (left + right) / 2;
            diAndCon(left, m, nums);
            diAndCon(m + 1, right, nums);
            sort2(left, right, nums);
        }
    }

    public static void sort2(int left, int right, int[] nums) {
        int[] tmp = new int[nums.length];
        int mi = (left + right) / 2;
        int m = (left + right) / 2 + 1;
        int l = left;
        int count = left;
        while(l <= mi && m <= right) {
            if(nums[l] < nums[m]) tmp[count++] = nums[l++];
            else tmp[count++] = nums[m++];
        }
        while(l <= mi) tmp[count++] = nums[l++];
        while(m <= right) tmp[count++] = nums[m++];
        System.arraycopy(tmp, left, nums, left, right - left + 1);
    }
}
