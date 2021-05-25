package examination.meituan;

import java.util.Scanner;

public class MeiTuan6 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0;i < t;i++){
            int n = s.nextInt();
            int[] tasty = new int[n];
            int sum = 0;
            for(int j = 0;j < n;j++){
                tasty[j] = s.nextInt();
                sum += tasty[j];
            }
            int max = tasty[0];
            int max_final = tasty[0];
            int min = tasty[0];
            int min_final = tasty[0];
            for(int k = 1;k < n;k++) {
                max = Math.max(max + tasty[k], tasty[k]);
                max_final = Math.max(max_final, max);
                min = Math.min(min + tasty[k], tasty[k]);
                min_final = Math.min(min_final, min);
            }
            System.out.println(Math.max(max_final, sum - min_final));
        }
    }
    /*int[][][] dp = new int[n][n][n];
    for(int k = 0;k < n;k++){
        for(int l = 0;l < n;l++){
            for(int m = 0;m <= l;m++){
                if((k + m + 1) <= n){
                    dp[k][l][m] = k + m + 1;
                }else {
                    dp[k][l][m] = (k + m + 1) % n;
                }
            }
        }
    }*/
}
