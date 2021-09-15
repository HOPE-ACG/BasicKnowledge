package ali;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Set<Integer>> map = new TreeMap<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Set<Integer> pxs = map.keySet();
            for(int px : pxs) {
                int ax = Math.abs(px - x);
                if(ax > k) continue;
                int ay;
                Set<Integer> pys = map.get(px);
                for(int py : pys) {
                    ay = Math.abs(py - y);
                    if(ay > k) continue;
                    if(Math.max(ax, ay) == k) count++;
                }
            }
            Set<Integer> pys = map.getOrDefault(x, new TreeSet<>());
            pys.add(y);
            map.put(x, pys);
        }
        System.out.println(count);
    }
}
