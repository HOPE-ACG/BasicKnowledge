package testAlgorithm;

import dynamic.Knapsack;
import org.junit.Test;

public class DynamicProgrammingTest {

    @Test
    public void testDyPro(){

        int[] buck = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 6};
        Knapsack knapsack = new Knapsack(8, 4, buck, value);
        knapsack.assignment();
    }
}
