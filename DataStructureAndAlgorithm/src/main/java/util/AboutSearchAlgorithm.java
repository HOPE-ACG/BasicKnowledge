package util;

/**
 * Some methods about search algorithm
 *
 * @author ACHENGE
 */
public class AboutSearchAlgorithm {

    /**
     * Creating a fibonacci array
     *
     * @param size the size og fibonacci array
     * @return fibonacci array
     */
    public static int[] fibonacci(int size){
        if(size < 3){
            throw new RuntimeException("inputted size is at least 3");
        }
        int[] fibo = new int[size];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int index=2;index<size;index++){
            fibo[index] = fibo[index-1] + fibo[index-2];
        }
        return fibo;
    }
}
