package huawei;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String search = s.nextLine();
        String target = s.nextLine();
        int l = target.length();
        int b = 0;
        Map<String, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < l; i++) {
            char c = target.charAt(i);
            if(c == ' ' || c == ',' || c == '.') {
                String cur = target.substring(b, i).toLowerCase();
                b = i + 1;
                int end = cur.length() - search.length() + 1;
                if(end < 0) continue;
                for(int j = 0; j < end; j++) {
                    if(search.charAt(0) == cur.charAt(j)) {
                        if(cur.startsWith(search, j)) {
                            int eq = (int) (((search.length() * 1.0) / (cur.length() * 1.0)) * 100);
                            if(eq < 50) break;
                            List<Integer> list = map.get(cur);
                            if(list == null) {
                                list = new ArrayList<>();
                                list.add(eq);
                                list.add(1);
                            }else {
                                Integer times = list.get(1);
                                list.remove(1);
                                list.add(times + 1);
                            }
                            map.put(cur, list);
                        }
                    }
                }
            }
        }
        String first = "empty";

        while (map.size() > 0) {
            Set<String> w = map.keySet();
            for(String word : w) {
                if(first.equals("empty")) {
                    first = word;
                }else {
                    List<Integer> be = map.get(first);
                    List<Integer> list = map.get(word);
                    if(list.get(0) > be.get(0)) {
                        first = word;
                    }else if(list.get(0).equals(be.get(0)) && list.get(1) > be.get(1)) {
                        first = word;
                    }
                }
            }
            map.remove(first);
            if(map.isEmpty()){
                System.out.print(first);
            }else {
                System.out.print(first + " ");
            }
            first = "empty";
        }
    }
}
