package util;

import stack.StackInArray;

/*
* Some methods about stack
* */
public class AboutStack {

    public static boolean isOperator(char operator){
        return operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '(' || operator == ')';
    }

    public static boolean judge(String current, String previous){
        if(previous.contentEquals("+")||previous.contentEquals("-")){
            return !current.contentEquals("*") && !current.contentEquals("/");
        }
        return true;
    }

    public static int caculatePoland(String polandExpression){
        //Analyse expression and caculate
        StackInArray stack = new StackInArray(15);
        char ch;
        int result = 0;
        for(int i=0;i<polandExpression.length();i++){
            ch = polandExpression.charAt(i);
            if(isOperator(ch)){
                result = caculate(stack.pop(), stack.pop(), ""+ch);
                stack.push(""+result);
            }else {
                stack.push(""+ch);
            }
        }
        return result;
    }

    public static int caculate(String num1, String num2, String symbol){
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        switch (symbol){
            case "+":
                return n1+n2;
            case "-":
                return n2-n1;
            case "*":
                return n1*n2;
            case "/":
                return n2/n1;
            default:
                throw new RuntimeException("wrong operator");
        }
    }
}
