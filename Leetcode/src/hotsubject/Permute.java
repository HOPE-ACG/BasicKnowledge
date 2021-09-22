package hotsubject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    public static void main(String[] args) {

        new Permute().reverse(" welcome to CVTE");
        List<List<Integer>> permute = new Permute().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int e : nums) list.add(e);
        int size = list.size();
        recursion(size, 0, list, result);
        return result;
    }

    public void recursion(int n, int pos, List<Integer> list, List<List<Integer>> result) {

        if(pos == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < n; i++) {
            Collections.swap(list, pos, i);
            recursion(n, pos + 1, list, result);
            Collections.swap(list, pos, i);
        }
    }

    /**
     * reverse the word in this String
     * such as "I love" => "love I"
     * @param word input parameter
     */
    public void reverse(String word) {

        String[] words = word.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
