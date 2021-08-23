package hotsubject;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringOfNoRepeating {

    public static void main(String[] args) {
        int length = new LongestSubstringOfNoRepeating().lengthOfLongestSubstring("bpfbhmipx");
        System.out.println(length);
        List<Character> l = new ArrayList<>();
        String a = "abcde";
        l.add(a.charAt(1));l.add(a.charAt(3));
        System.out.println(l);
        l.remove((Character)a.charAt(1));
        System.out.println(l);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }else if(s.length() == 1) {
            return 1;
        }
        String[] words = s.split("");
        int max = 0;
        List<String> pass = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(pass.contains(words[i])) {
                max = Math.max(max, pass.size());
                int fromIndex =i - pass.size();
                int loc = s.indexOf(words[i], fromIndex) + 1;
                for(int j = fromIndex; j < loc; j++) {
                    pass.remove(words[j]);
                }
            }
            pass.add(words[i]);
        }
        max = Math.max(max, pass.size());
        return max;
    }
}
