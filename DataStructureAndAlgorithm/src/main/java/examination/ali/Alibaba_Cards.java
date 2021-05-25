package examination.ali;

import java.util.Scanner;

public class Alibaba_Cards {

    private static long mod = (int)(Math.pow(10, 9)) + 7;
    //Select n cards, sum is k
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // t groups test data
        int n, m, k;
        for(int i = 0;i < t;i++){
            n = s.nextInt();
            m = s.nextInt();
            k = s.nextInt();
            if(n * m < k){
                System.out.println(0);
                continue;
            }
            System.out.println(algorithm(n, m, k) % mod);
        }
    }

    private static int algorithm(int n, int m, int k){

        if(n == 1) {
            if(k <= m && k > 0){
                return 1;
            }else {
                return 0;
            }
        }
        if(k < 0 && n > 0 || k > n * m || k == 1 && n > 1){
            return 0;
        }
        int[][] dp = new int[n + 1][k + 1];
        for(int no = 1;no <= m;no++){
            if(k - no > 0){
                dp[n][k - no] = algorithm(n - 1, m, k - no);
            }
        }
        int result = 0;
        for(int i = 1;i <= m;i++){
            if(k - i > 0){
                result += dp[n][k - i];
            }
        }
        return result;
    }
}
