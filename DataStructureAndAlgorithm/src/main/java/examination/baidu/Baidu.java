package examination.baidu;


public class Baidu {
    public static void main(String[] args) {
        int n = 12;
        int m = 3;



        int[][][] dp = new int[n+1][m+1][m+1];

        for(int i = 1; i <= m; i++) {
            dp[i][i][0] = 1;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j++) {
                for(int k = 0; k <= m; k++) {
                    if(k == j || i < j || i < k || dp[i][j][k] == 0) {
                        continue;
                    }
                    for(int cur = 1; cur <= m; cur++) {
                        if(cur == j || cur == k || cur + i > n) {
                            continue;
                        }
                        dp[i + cur][cur][j] += dp[i][j][k];
                        dp[i + cur][cur][j] %= 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for(int j = 1; j <= m; j++) {
            for(int k = 0; k <= m; k++) {
                if(k == j) {
                    continue;
                }
                ans += dp[n][j][k];
                ans %= 1000000007;
            }
        }
        System.out.println(ans);
    }
}