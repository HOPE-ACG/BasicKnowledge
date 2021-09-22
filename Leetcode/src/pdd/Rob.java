package pdd;

public class Rob {

    public static void main(String[] args) {

        int cash = new Rob().rob(new int[]{1, 2, 3, 1});
        System.out.println(cash);
        System.out.println(Integer.MIN_VALUE);
    }

    public int rob(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int[] cash = new int[nums.length + 1];
        cash[1] = nums[0];
        cash[2] = Math.max(nums[0], nums[1]);
        return recursion(3, nums, cash, n);
    }

    private int recursion(int pos, int[] nums, int[] cash, int n) {

        if(pos > n) return cash[n];
        cash[pos] = Math.max(cash[pos - 1], cash[pos - 2] + nums[pos - 1]);
        return recursion(pos + 1, nums, cash, n);
    }
}
