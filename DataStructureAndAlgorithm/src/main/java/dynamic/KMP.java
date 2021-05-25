package dynamic;

/**
 * Knuth-Morris-Pratt algorithm,matching with given string
 *
 * @author ACHENGE
 */
public class KMP {

    public static void main(String[] args) {
        if(algorithm("BBC ABCDAB ABCDABCDABDE", "ABCDABCDAB")){
            System.out.println("Matching");
        }else {
            System.out.println("Error");
        }
    }

    /**
     * matching same string in source string
     * @param src source string
     * @param target being matched string
     * @return include target string or not
     */
    public static boolean algorithm(String src, String target){

        int l = target.length();
        int[] next = new int[l]; // matching table of part of string
        next[0] = 0;
        String start, end;
        int k = 2;
        while(k <= l){
            next[k - 1] = 0;
            for(int i = 1;i < k;i++){
                start = target.substring(0, i);
                end = target.substring(k - i, k);
                if(start.contentEquals(end)){
                    next[k - 1] = start.length();
                }
            }
            k++;
        }
        //System.out.println(Arrays.toString(next));
        int m = 0;
        int n = 0;
        while(n < src.length()){
            if(m >= target.length()){
                break;
            }else if(target.charAt(m) == src.charAt(n)){
                m++;
                n++;
            }else if(m != 0){
                n =  n - m + (m - next[m - 1]);
                m = 0;
            }else {
                n++;
            }
        }
        return m == target.length();
    }
}
