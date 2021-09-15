package ali;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for(int j = l; j <= r; j++) {
                for(int k = j; k <=r; k++) {
                    min = Math.min(min, j & k);
                }
            }
            System.out.println(min);
        }
    }
}
