package examination.meituan;

import java.util.Scanner;

public class MeiTuan5 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int[] score = new int[n];
        for(int i = 0;i < n;i++){
            score[i] = s.nextInt();
        }
        int[] temp = new int[n];
        algo(score, temp, 0, n - 1);
        //System.out.println(Arrays.toString(score));
        if(score[0] == 0) {
            System.out.println(0);
            return;
        }
        int index = x - 1;
        while(score[index] <= 0){
            index--;
        }
        while (score[index++] == score[index]){}
        System.out.println(index);
    }

    public static void algo(int[] score, int[] temp, int left, int right){

        if(left < right){
            int mid = (left + right) / 2;
            algo(score, temp, left, mid);
            algo(score, temp, mid + 1, right);
            sort(score, temp, left, mid, right);
        }
    }

    public static void sort(int[] score, int[] temp, int left, int mid, int right){

        int l = left;
        int m = mid + 1;
        int index = 0;
        while(l <= mid && m <= right){
            if(score[l] >= score[m]){
                temp[index++] = score[l++];
            }else{
                temp[index++] = score[m++];
            }
        }
        while(l <= mid){
            temp[index++] = score[l++];
        }
        while(m <= right){
            temp[index++] = score[m++];
        }
        System.arraycopy(temp, 0, score, left, index);
    }
}
