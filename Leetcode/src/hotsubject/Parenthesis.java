package hotsubject;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static void main(String[] args) {
//        List<String> parent = new Parenthesis().generateParenthesis(10);
        List<String> parent = new Parenthesis().generateParenthesis2(3);
        System.out.println(parent);
    }

    public List<String> generateParenthesis2(int n) {
        List<List<String>> ll = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        if(n == 0) {
            return l1;
        }
        l1.add("");
        ll.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("()");
        ll.add(l2);
        for(int i = 2; i < n + 1; i++) {
            List<String> l = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                List<String> left = ll.get(j);
                List<String> right = ll.get(i - j - 1);
                for(String s1: left) {
                    for(String s2: right) {
                        l.add("(" + s1 + ")" + s2);
                    }
                }
            }
            ll.add(l);
        }

        return ll.get(n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> brackets = new ArrayList<>();
        if(n == 0) {
            return brackets;
        }
        recursion("", n, n, brackets);

        return brackets;
    }

    public void recursion(String cur, int left, int right, List<String> brackets) {

        if(left == 0 && right == 0) {
            brackets.add(cur);
            return;
        }
        if(left > right) {
            return;
        }
        if(left > 0) {
            recursion(cur + "(", left - 1, right, brackets);
        }
        if(right > 0) {
            recursion(cur + ")", left, right - 1, brackets);
        }
    }
}
