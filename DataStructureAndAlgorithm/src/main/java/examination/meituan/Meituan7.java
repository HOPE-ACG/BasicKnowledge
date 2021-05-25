package examination.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Meituan7 {

    private static int[] nums;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }
        dp = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
        }
        /*int min = 0;
        for(int k = 0; k < n; k++){
            calc(k, 0, n - 1);
        }
        System.out.println(min);*/
        System.out.println(calc(-1, 0, n - 1));
    }

    public static int calc(int root, int left, int right){

        if(left > right){
            return 0;
        }
        if(root != -1 && dp[left][right][root] != -1){
            return dp[left][right][root];
        }

        int cost = Integer.MAX_VALUE;
        int leftCost;
        int rightCost;
        for(int k = left; k <= right; k++){
            leftCost = calc(k, left, k - 1);
            rightCost = calc(k, k + 1, right);
            cost = Math.min(cost, leftCost + rightCost + nums[k] * (root != -1 ? nums[root] : 0));
        }
        if(root != -1){
            dp[left][right][root] = cost;
        }
        return cost;


        /*if(right == left){
            return nums[left];
        }
        int cur;
        int l;
        int lMin = 0;
        for(int i = left; i < root; i++){
            l = calc(i, left, root - 1, nums);
            if(left == root - 1){
                cur = l * nums[root];
            }else {
                cur = l + nums[i] * nums[root];
            }
            if(i == left){
                lMin = cur;
            }else {
                lMin = Math.min(lMin, cur);
            }
        }
        int r;
        int rMin = 0;
        for(int j = root + 1; j <= right; j++){
            r = calc(j, root + 1, right, nums);
            if(right == root + 1){
                cur = r * nums[root];
            }else {
                cur = r + nums[j] * nums[root];
            }
            if(j == root + 1){
                rMin = cur;
            }else {
                rMin = Math.min(rMin, cur);
            }
        }
        return lMin + rMin;*/
    }
}
