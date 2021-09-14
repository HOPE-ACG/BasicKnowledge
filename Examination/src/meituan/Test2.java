package meituan;

import java.util.*;

/*
5 5 3
1 2
2 3
3 4
4 5
1 4
2 5
1 2
3 4
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] nmq = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nmq[0]);
        int m = Integer.parseInt(nmq[1]);
        int q = Integer.parseInt(nmq[2]);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            String[] uv = scanner.nextLine().split(" ");
            Integer u = Integer.parseInt(uv[0]);
            Integer v = Integer.parseInt(uv[1]);
            Set<Integer> setu = map.getOrDefault(u, new HashSet<>());
            setu.add(v);
            map.put(u, setu);
            Set<Integer> setv = map.getOrDefault(v, new HashSet<>());
            setv.add(u);
            map.put(v, setv);
        }
        for(int i = 0; i < q; i++) {
            String[] xy = scanner.nextLine().split(" ");
            Integer x = Integer.parseInt(xy[0]);
            Integer y = Integer.parseInt(xy[1]);
            Set<Integer> integersx = map.get(x);
            Map<Integer, Set<Integer>> temp = new HashMap<>();
            for (Integer next : integersx) {
                if (next.equals(y)) {
                    integersx.remove(y);
                    integersx.add(x);
                } else {
                    Set<Integer> integers = map.get(next);
                    temp.put(next, integers);
                }
            }
            Set<Integer> integersy = map.get(y);
            for (Integer next : integersy) {
                if (next.equals(x)) {
                    integersy.remove(x);
                    integersy.add(y);
                } else {
                    Set<Integer> integers = map.get(next);
                    if (!temp.containsKey(next)) temp.put(next, integers);
                }
            }
            boolean flag1 = false;
            boolean flag2 = false;
            Set<Integer> integers = temp.keySet();
            for (Integer next1 : integers) {
                Set<Integer> integers1 = temp.get(next1);
                Iterator<Integer> iterator = integers1.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    if (next.equals(x)) {
                        iterator.remove();
                        flag1 = true;
                    } else if (next.equals(y)) {
                        iterator.remove();
                        flag2 = true;
                    }
                    if (flag1) {
                        integers1.add(y);
                        flag1 = false;
                    }
                    if (flag2) {
                        integers1.add(x);
                        flag2 = false;
                    }
                }
                map.put(next1, integers);
            }
            map.put(y, integersx);
            map.put(x, integersy);
            System.out.println(map);
        }
        for(int i = 1; i <= n; i++) {
            int size = map.get(i).size();
            System.out.printf("%d ", size);
        }
    }
}
