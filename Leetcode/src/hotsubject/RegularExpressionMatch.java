package hotsubject;

import java.util.Stack;

public class RegularExpressionMatch {

    public static void main(String[] args) {
        boolean res = new RegularExpressionMatch().isMatch("abb", "bbb*");
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> pp = new Stack<>();
        int s_len = s.length();
        int p_len = p.length();
        int min = Math.min(s_len, p_len);
        for(int i = 0; i < min; i++) {
            ss.push(s.charAt(i));
            pp.push(p.charAt(i));
        }
        if(s_len > min) {
            for(int i = min; i < s_len; i++) {
                ss.push(s.charAt(i));
            }
        }else {
            for(int i = min; i < p_len; i++) {
                pp.push(p.charAt(i));
            }
        }
        char record = ' ';
        while(!pp.empty() && !ss.empty()) {
            char cur_p = pp.pop();
            char cur_s = ss.pop();
            if(cur_p == '*') {
                char next_p = pp.empty()?' ':pp.pop();
                if(next_p == ' ') return false;
                if(next_p != '.') {
                    if(next_p != cur_s) {
                        ss.push(cur_s);
                        continue;
                    }
                    while(cur_s == next_p && !ss.empty()) cur_s = ss.pop();
                    if(cur_s != next_p) ss.push(cur_s);
                    record = next_p;
                }else {
                    char next2_p = pp.empty()?' ':pp.pop();
                    while(cur_s != next2_p && !ss.empty()) cur_s = ss.pop();
                    if(cur_s == next2_p) ss.push(cur_s);
                    pp.push(next2_p);
                    record = ' ';
                }
            }else {
                if(cur_p == record) continue;
                if(cur_p != '.' && cur_p != cur_s) return false;
            }
        }
        if(!ss.empty()) return false;
        while(!pp.empty()) {
            char ch = pp.pop();
            if(ch == '*') {
                pp.pop();
                continue;
            }
            if(ch == record) continue;
            return false;
        }
        return true;
    }
}
