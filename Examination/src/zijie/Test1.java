package zijie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int maxtime = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum = x + y;
            maxtime = Math.max(maxtime, sum);
            map.put(x, y);
            /*for(int b = x; b <= x + y; b++) {
                int task = map.getOrDefault(b, 0) + 1;
                map.put(b, task);
            }*/
        }
        int[] res = new int[maxtime + 1];
        int max = 0;
        Set<Integer> keys = map.keySet();
        for(int k : keys) {
            int task = map.get(k);
            for(int l = k; l < k + task; l++){
                res[l] = res[l] + 1;
            }
        }
        for(int r : res) {
            max = Math.max(max, r);
        }
        System.out.println(max);
    }
}
