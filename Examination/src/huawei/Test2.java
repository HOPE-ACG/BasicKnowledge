package huawei;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String value = s.nextLine();
        String time = s.nextLine();
        String dead = s.nextLine();
        String[] values = value.split(" ");
        String[] times = time.split(" ");
        String[] deads = dead.split(" ");
        int[] v = new int[n];
        int[] t = new int[n];
        int[] d = new int[n];
        for(int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(values[i]);
            t[i] = Integer.parseInt(times[i]);
            d[i] = Integer.parseInt(deads[i]);
        }
        int val =  dp(n, 0, 0, 0, v, t, d);
        System.out.println(val);
    }

    public static int dp(int n, int p, int ti, int va, int[] v, int[] t, int[] d) {

        int val = va;
        for(int i = p; i < n; i++) {
            int curTi = ti;
            int curVa = va;
            if(ti + t[i] <= d[i]) {
                curVa += v[i];
                curTi += t[i];
            }
            val = Math.max(dp(n, i + 1, curTi, curVa, v, t, d), val);
        }
        return val;
    }
}
