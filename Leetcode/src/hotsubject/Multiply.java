package hotsubject;

public class Multiply {

    public static void main(String[] args) {

        String multiply = new Multiply().multiply("123", "456");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int add = 0;
        int[] res = new int[l1 + l2];
        for(int i = 0; i < l1; i++) {
            int nums1 = num1.charAt(l1 - 1 - i) - '0';
            for(int j = 0; j < l2; j++) {
                int nums2 = num2.charAt(l2 - 1 -j) - '0';
                res[i + j] += (nums1 * nums2 + add);
            }
        }
        for(int i = 0; i < res.length - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        if(res[res.length - 1] != 0) sb.append(res[res.length - 1]);
        for(int i = res.length - 2; i >= 0; i--) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
