package tengxun;

import java.util.Scanner;

public class Cup {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int k = s.nextInt();
        for(int i = 0; i < k; i ++) {
            int f = s.nextInt();
            int se = s.nextInt();
            if(x == f || x == se) x = x==f?se:f;
        }
        System.out.println(x);
    }
}
