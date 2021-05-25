package examination.huawei;

import java.util.Scanner;

public class HuaWei3 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = s.nextInt();
        }
        System.out.println(al(n, dis, 0, 0));
    }

    public static int al(int n, int[] dis, int sum, int count){

        if(sum >= n - 1){
            return count;
        }
        int min = -1;
        for(int i = 1; i<= dis[sum]; i++){
            if(i == 1){
                min = al(n, dis, sum + i, count + 1);
            }else {
                min = Math.min(min, al(n, dis, sum + i, count + 1));
            }
        }
        return  min;
    }
}
