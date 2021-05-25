package examination.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] params = scanner.nextLine().split(" ");
            String[] weight = scanner.nextLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int a = Integer.parseInt(params[2]);
            int b = Integer.parseInt(params[3]);
            int[] w = new int[m];
            for(int i = 0;i < m;i++){
                w[i] = Integer.parseInt(weight[i]);
            }
            Arrays.sort(w);
            int temp;
            if(a == b){
                if(w[0] == w[m - 1]){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                continue;
            }
            if(a > b){
                temp = a ;
                a = b;
                b = temp;
            }
            if(w[0] == 1){
                if(a != 1){
                    System.out.println("NO");
                    continue;
                }
            }
            if(a > w[0] || b < w[ m - 1]){
                System.out.println("NO");
                continue;
            }
            if(n == m){
                if(a == w[0] && b == w[m - 1]){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else if(n - m < 2){
                if(b == w[m - 1] || a == w[0]){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                if(b < w[0] || a > w[m - 1]){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
        }
    }

    public static void algo(int[] w, int left, int right){

        int l = left;
        int r = right;
        int temp;
        while(l < r){
            int midVal = w[(left + right) / 2];
            while(w[l] < midVal){
                l++;
            }
            while(w[r] > midVal){
                r--;
            }
            if(l >= r){
                break;
            }
            temp = w[l];
            w[l] = w[r];
            w[r] = temp;
            if(w[l] == midVal){
                r--;
            }
            if(w[r] == midVal){
                l++;
            }
        }
        if(l == r){
            l++;
            r--;
        }
        if(l < right){
            algo(w, l, right);
        }
        if(r > left){
            algo(w, left, r);
        }
    }
}

