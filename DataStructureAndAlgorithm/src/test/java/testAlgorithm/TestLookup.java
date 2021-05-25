package testAlgorithm;

import lookup.Binary;
import lookup.Fibonacci;
import lookup.Interpolation;
import lookup.Linear;
import sequence.Hill;
import sequence.Insert;
import sequence.Merge;
import sequence.Quick;

import java.util.Arrays;

public class TestLookup {

    public void testLinear(){
        int[] nums = {5, 35, 1, 2, 56, 21, 14, 8};
        Quick quick = new Quick(nums);
        quick.algorithm(0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        Linear linear = new Linear(nums);
        int index = linear.algorithm(-21);
        System.out.println("index="+index);
    }

    public void testBinary(){
        int[] nums = {5, 35, 1, 2, 56, 21, 14, 8};
        Merge merge = new Merge(nums);
        merge.sort();
        System.out.println(Arrays.toString(nums));
        Binary binary = new Binary(nums);
        int index = binary.algorithm(5, 0, nums.length-1);
        System.out.println("index="+index);
    }

    public void testInterpolation(){
        int[] nums = {5, 35, 1, 2, 56, 21, 14, 8};
        Hill hill = new Hill(nums);
        hill.algorithm_opt();
        System.out.println(Arrays.toString(nums));
        Interpolation interpolation = new Interpolation(nums);
        int index = interpolation.algorithm(5, 0, nums.length-1);
        System.out.print("index="+index);
    }

    public void testFibonacci(){
        int[] nums = {5, 35, 1, 2, 56, 21, 14, 8};
        Insert insert = new Insert(nums);
        insert.algorithm();
        System.out.println(Arrays.toString(nums));
        Fibonacci fibonacci = new Fibonacci(nums);
        int index = fibonacci.algorithm(-21);
        System.out.print("index="+index);
    }

}
