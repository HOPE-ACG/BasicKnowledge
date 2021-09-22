package hotsubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(anagrams);
        System.out.println(lists);
    }
    public static List<List<String>> groupAnagrams(String[] anagrams) {

        Map<String, List<String>> map = new HashMap<>();
        for(String w : anagrams) {
            int[] counts = new int[26];
            for(int i = 0; i < w.length(); i++) {
                counts[w.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(counts[i] > 0) {
                    sb.append(counts[i]);
                    sb.append((char)(i + 'a'));
                }
            }
            String combination = sb.toString();
            List<String> l = map.getOrDefault(combination, new ArrayList<>());
            l.add(w);
            map.put(combination, l);
        }
        return new ArrayList<>(map.values());
    }
}
