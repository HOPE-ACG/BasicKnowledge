package examination.meituan;

import java.util.Scanner;

public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] sequence = new int[n];
        for(int i = 0;i < n;i++){
            sequence[i] = s.nextInt();
        }
        int[] tempArray = new int[n];
        algorithm(sequence, tempArray, 0, n - 1);
//        System.out.println(Arrays.toString(sequence));
        int count = 0;
        for(int i = 0;i < n;i++){
            if(sequence[i] != i + 1){
                count += Math.abs(sequence[i] - (i + 1));
            }
        }
        System.out.print(count);
    }

    public static void algorithm(int[] sequence, int[] temp, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            algorithm(sequence, temp, left, mid);
            algorithm(sequence, temp, mid + 1, right);
            sort(sequence, temp, left, mid, right);
        }
    }

    public static void sort(int[] sequence, int[] temp, int left, int mid, int right){
        int l = left;
        int m = mid + 1;
        int index = 0;
        while(l <= mid && m <= right){
            if(sequence[l] <= sequence[m]){
                temp[index++] = sequence[l++];
            }else {
                temp[index++] = sequence[m++];
            }
        }
        while(l <= mid){
            temp[index++] = sequence[l++];
        }
        while(m <= right){
            temp[index++] = sequence[m++];
        }
        System.arraycopy(temp, 0, sequence, left, index);
    }
}