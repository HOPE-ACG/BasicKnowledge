package examination.meituan;

import java.util.Scanner;

public class MeiTuan {

    private static int[] grades;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = s.nextInt();
        }
//        System.out.println(Arrays.toString(grades));
        algorithm(grades, 0, n - 1); //sort array
//        System.out.println(Arrays.toString(grades));
        if(n < 2 * x || n > 2 * y){
            System.out.println(-1);
            return;
        }
        if(n == 2 * x){
            System.out.println(grades[x - 1]);
            return;
        }
        if(n == 2 * y){
            System.out.println(grades[y - 1]);
            return;
        }
        int lose = x;
        int win = n - x;
        while(lose > x && win < y){
            win++;
            lose--;
        }
        System.out.println(grades[lose - 1]);
    }


    public static void algorithm(int[] grades, int left, int right){
        int l = left;
        int r = right;
        int midVal = grades[(l + r) / 2];
        int temp;
        while(l < r){
            while(grades[l] < midVal){
                l++;
            }
            while(grades[r] > midVal){
                r--;
            }
            if(l >= r){
                break;
            }
            temp = grades[l];
            grades[l] = grades[r];
            grades[r] = temp;
            if(grades[l] == midVal){
                r--;
            }
            if(grades[r] == midVal){
                l++;
            }
        }
        if(l == r){
            l++;
            r--;
        }
        if(l < right){
            algorithm(grades, l, right);
        }
        if(r > left){
            algorithm(grades, left, r);
        }
    }
}
