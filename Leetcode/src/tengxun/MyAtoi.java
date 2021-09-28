package tengxun;

import java.util.Arrays;

public class MyAtoi {

    public static void main(String[] args) {

        int res = myAtoi("-2147483647");
        System.out.println(res);
        int[] nums = new int[]{1, 2, 3};
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        System.out.println(Arrays.toString(tmp));
        int[] ot = new int[]{3, 4};
        System.arraycopy(ot, 0, tmp, 1, 2);
        System.out.println(Arrays.toString(tmp));
    }

    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 48 && c <= 58) {
                sb.append(c);
            }else if((c == '-' || c == '+') && sb.length() == 0) {
                sb.append(c);
            }else if(!Character.isDigit(c) && (c != ' ' || sb.length() != 0)){
                break;
            }
        }
        if(sb.length() == 0) return 0;
        String median = sb.toString();
        int sta = 0;
        char c = median.charAt(0);
        int sym = 1;
        if(c == '+') {
            sta ++;
        }else if(c == '-') {
            sym = -1;
            sta++;
        }
        while(sta < median.length()) {
            if(median.charAt(sta) != '0') {
                break;
            }
            sta ++;
        }
        if(sta != 0) sb.delete(0, sta);
        if(sb.length() == 0) return 0;
        String num = sb.toString();
        if(num.length() < 10) return Integer.parseInt(num) * sym;
        else if(num.length() > 10) {
            if(sym == -1) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }else {
            double n = Double.parseDouble(num) * sym;
            if(n >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(n <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else {
                return (int)n ;
            }
        }
    }
}
