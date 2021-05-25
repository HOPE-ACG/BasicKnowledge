package dynamic;

import java.util.Arrays;

public class Dijkstra {

    /**
     * infinity
     */
    static int n = 65536;

    /**
     * all destinations
     */
    static int[][] map = new int[][]{
            {0 , 12, n, n, n, 16, 14},
            {12, 0, 10, n, n, 7, n},
            {n, 10, 0, 3, 5, 6, n},
            {n, n, 3, 0, 4, n, n},
            {n, n, 5, 4, 0, 6, 8},
            {16, 7, 6, n, 2, 0, 1},
            {14, n, n, n, 8, 1, 0}
    };

    /**
     * start place
     */
    static char start = 'A';

    /**
     * destinations
     */
    static char[] destination = new char[]{'B', 'C', 'D', 'E', 'F', 'G'};

    /**
     * distance between two places
     */
    static int[] dis = new int[]{12, n, n, n, 16, 14};

    /**
     * final optimization distance
     */
    static int[] finals = new int[dis.length];

    /**
     * the place that between two places in the shortest distance
     */
    static char[] precursor = new char[]{'A', 'A', 'A', 'A', 'A', 'A'};

    public static void main(String[] args) {

        int count = 0;
        while(count < dis.length){
            algo();
            count++;
        }
        System.out.println(Arrays.toString(finals));
        System.out.println(Arrays.toString(precursor));
    }

    public static void algo(){

        int index = 0;
        int shortest = n;
        for(int i = 0;i < dis.length;i++){
            if(dis[i] != 0 && dis[i] < shortest){
                shortest = dis[i];
                index = i;
            }
        }
        finals[index] = shortest;
        remove(index);
        for(int i = 0;i < dis.length;i++){
            if(dis[i] != 0){
                if(map[start - 65][index + 1] + map[index + 1][i + 1] < dis[i]){
                    dis[i] = map[start - 65][index + 1] + map[index + 1][i + 1];
                    map[start - 65][i + 1] = map[start - 65][index + 1] + map[index + 1][i + 1];
                    precursor[i] = (char)(index + 66);
                }
            }
        }
    }

    public static void remove(int index){

        dis[index] = 0;
        destination[index] = 0;
    }
}
