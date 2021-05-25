package dynamic;

import java.util.Scanner;

/**
 * Calculate out shortest distance between two places
 *
 * @author ACHENGE
 */
public class Floyd {

    //distance between two places
    /*

            A    B    C    D    E    F    G
        A
        B
        C
        D
        E
        F
        G
     */
    private static int[][] dis = {
            {0, 5, 7, 10086, 10086, 10086, 2},
            {5, 0, 10086, 9, 10086, 10086, 3},
            {7, 10086, 0, 10086, 8, 10086, 10086},
            {10086, 9, 10086, 0, 10086, 4, 10086},
            {10086, 10086, 8, 10086, 0, 5, 4},
            {10086, 10086, 10086, 4, 5, 0, 6},
            {2, 3, 10086, 10086, 4, 6, 0}
    };



    public static void main(String[] args) {

        algorithm();
         while(true){
            Scanner s = new Scanner(System.in);
            System.out.print("please input origin:");
            String origin = s.next();
            char or = origin.charAt(0);
            int o = or - 65;
            System.out.print("please input destination:");
            String destination = s.next();
            char de = destination.charAt(0);
            int d = de - 65;
            System.out.println("The shortest distance between "
                    + origin + " and " + destination + " is " + dis[o][d]);
        }
    }

    /**
     * update the shortest distance between two places by triple circle
     */
    public static void algorithm(){

        int n = dis.length;
        for(int k = 0;k < n;k++){
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    if(dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
    }
}
