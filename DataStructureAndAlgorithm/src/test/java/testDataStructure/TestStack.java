package testDataStructure;

import stack.SimpleCalculator;
import stack.StackInArray;

public class TestStack {

    public void test(){
        StackInArray stack = new StackInArray(5);
        stack.push("TJ");stack.push("Bj");stack.push("Cs");stack.push("Wx");stack.push("Nt");
        stack.all();
        stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();
        stack.all();
    }

    public void testCalculator(){
       String expression = "10*3+12/2-22/2";
       int result = SimpleCalculator.analyse(expression);
       System.out.println(result);
    }
}
