package examination.leetcode;

public class LongestPalindromicChildString {

    public static void main(String[] args) {
        String result = longestPalindrome("abcdefghiefghswjjwshgfegklmn");
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        for(int i = s.length(); i > 1; i--){
            int start = 0;
            while(start + i <= s.length()){
                String child = s.substring(start, start + i);
                if(judge(child)){
                    return child;
                }
                start++;
            }
        }
        return s.substring(0, 1);
    }

    public static boolean judge(String target) {
        int left = 0;
        int right = target.length() - 1;
        while(left < right){
            if(target.charAt(left) != target.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        // Stack<String> stack = new Stack<>();
        // String[] tars = target.split("");
        // for(String str : tars) {
        //     stack.push(str);
        // }
        // String retVal = "";
        // while(!stack.empty()){
        //     retVal += stack.pop();
        // }
        // return retVal;
    }
}
