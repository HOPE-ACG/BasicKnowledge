package hotsubject;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        int max = new LongestValidParentheses().longestValidParentheses("(()(((()");
        System.out.println(max);
        int max2 = new LongestValidParentheses().longestValidParentheses2("(()(((()");
        System.out.println(max2);
    }

    public int longestValidParentheses(String s) {

        int n = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if(cur == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses2(String s) {

        int n = s.length();
        if(n <= 1) return 0;
        int max = 0;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            if(cur == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2?dp[i - 2]:0) + 2;
                }else {
                    if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1]
                                + ((i - dp[i - 1]) > 1?dp[i - dp[i - 1] - 2]:0)
                                + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
