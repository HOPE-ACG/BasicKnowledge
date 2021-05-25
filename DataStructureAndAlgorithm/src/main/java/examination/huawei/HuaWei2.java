package examination.huawei;

import java.util.Scanner;

/**
 * Testing Dataset, all:140 counts
 * 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
 * 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 60 50 40 30 20 10 9 9 70 60 50 40 30 25 20 20 15 30 30 30
 * 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
 * 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
 */
public class HuaWei2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] speeds = new int[n];
        for(int i = 0; i < n; i++){
            speeds[i] = s.nextInt();
        }
        System.out.print(speeds[0] + ".");
        boolean count_cyc = true;
        int cycle_pos = 1;
        boolean aeb_init = false;
        boolean aeb_start = false;
        int count = 0;
        int count_end = 0;
        int aeb_pos_start = -1;
        int aeb_pos_end = -1;
        for(int i = 1; i < n; i++){

            //judge whether start AEB
            if(!aeb_init && speeds[i] <= speeds[i - 1] - 9){
                aeb_init = true;
                aeb_pos_start = i;
            }else if(aeb_init && speeds[i] > speeds[i - 1] - 9){
                aeb_init = false;
                if(aeb_start){
                    aeb_start = false;
                    count_end = 4;
                }
                count = 0;
            }else if(!aeb_start && aeb_init){
                count++;
            }

            //input data by AEB
            if(!aeb_start && count == 3){
                aeb_start = true;
                count_cyc = false;
                for(int j = aeb_pos_start - 4; j <= i; j++){
                    if(j >= 1 && j > aeb_pos_end){
                        System.out.print(speeds[j] + ".");
                    }
                }
            }else if(aeb_start){
                System.out.print(speeds[i] + ".");
            }else if(count_end > 0){
                System.out.print(speeds[i] + ".");
                aeb_pos_end = i;
                count_end--;
                if(count_end == 0){
                    count_cyc = true;
                    cycle_pos = 0;
                }
            }

            //input data by circle
            if(count_cyc){
                cycle_pos++;
            }
            if(cycle_pos % 60 == 0){
                System.out.print(speeds[i] + ".");
            }
        }

    }
}
