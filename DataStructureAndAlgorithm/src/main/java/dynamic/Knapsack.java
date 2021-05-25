package dynamic;

/**
 * Solve 0-1 knapsack problem
 *
 * @author ACHENGE
 */
public class Knapsack {

    /**
     * knapsack's capacity
     */
    private int capacity = 8;

    /**
     * foods' count
     */
    private int count = 4;

    /**
     * every goods' weight
     */
    private int[] bulk;

    /**
     * every goods' value
     */
    private int[] value;

    /**
     * when put over the last i goods into knapsack, the max value of
     * knapsack that has j capacity
     */
    private int[][] maxValue = new int[count + 1][capacity + 1];

    /**
     * constructor without parameter
     */
    public Knapsack() {}

    /**
     * assign value to {@para capacity},  {@para count},  {@para bulk}
     * and {@para value}
     * @param capacity knapsack's capacity
     * @param count food's number
     * @param bulk  every food's bulk
     * @param value every food's value
     */
    public Knapsack(int capacity, int count, int[] bulk, int[] value) {
        this.capacity = capacity;
        this.count = count;
        this.bulk = bulk;
        this.value = value;
        this.maxValue = new int[count + 1][capacity + 1];
    }

    public void assignment(){

        for(int col = 1;col <= capacity;col++){ // all values are value[1] in second column
            if(bulk[0] > col){
                maxValue[1][col] = 0;
            }else {
                maxValue[1][col] = value[0];
            }
        }
        int[][] path = algorithm();
        for (int[] ints : maxValue) {
            for (int col = 0; col < maxValue[0].length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
        System.out.println("optimal solution:"+maxValue[count][capacity]);
        for(int i = count, j = capacity;j > 0 && i > 0;i--){
            if(path[i][j] == 1){
                System.out.printf("putting no.%d foods into knapsack\n", i);
                j -= bulk[i - 1];
            }
        }
    }

    /**
     * foods assignment
     */
    private int[][] algorithm(){

        int[][] path = new int[count + 1][capacity + 1];
        for(int i = 2;i <= count;i++){ //traverse all foods
            for(int j = 1;j <= capacity;j++){ //traverse capacity from 1 to max
                if(bulk[i - 1] > j){
                    maxValue[i][j] = maxValue[i - 1][j];
                }else {
                    if(maxValue[i - 1][j] < value[i - 1] + maxValue[i - 1][j - bulk[i - 1]]){
                        maxValue[i][j] = value[i - 1] + maxValue[i - 1][j - bulk[i - 1]];
                        path[i][j] = 1;
                    }else {
                        maxValue[i][j] = maxValue[i - 1][j];
                    }
                    /*maxValue[i][j] = Math.max(
                            maxValue[i - 1][j],
                            value[i - 1] + maxValue[i - 1][j - bulk[i - 1]]
                    );*/
                }
            }
        }
        return path;
    }
}
