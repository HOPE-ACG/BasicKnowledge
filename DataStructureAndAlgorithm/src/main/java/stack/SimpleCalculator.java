package stack;

/*
* Analyse expression,calculate out result
* @para stackOfNumber store number's part of expression
* @para stackOfSymbol store symbol's part of expression
* */

public class SimpleCalculator {

    private static final StackInArray stackOfNumber = new StackInArray(8);
    private static final StackInArray stackOfSymbol = new StackInArray(5);

    public static int analyse(String expression){
        int length = expression.length();
        int result = 0;
        String[] eles_sym = stackOfSymbol.getEles();
        for(int i=0;i<length;i++){
            char ch =  expression.charAt(i);
            if(isOperator(ch)){
                if(stackOfSymbol.isEmpty()){
                    stackOfSymbol.push(""+ch);
                    continue;
                }
                if(judge(""+ch, eles_sym[stackOfSymbol.getTop()])){
                    String ele1 =  stackOfNumber.pop();
                    String ele2 =  stackOfNumber.pop();
                    result = calculate(ele1, ele2, stackOfSymbol.pop());
                    stackOfNumber.push(""+result);
                    stackOfSymbol.push(""+ch);
                    continue;
                }
                stackOfSymbol.push(""+ch);
                continue;
            }
            //judge whether number more than 9
            String number = ""+ch;
            if(i+1<length){
                char ch_backOne = expression.charAt(i+1);
                if(!isOperator(ch_backOne)){
                    number = ""+ch+ch_backOne;
                    i++;
                }
            }
            stackOfNumber.push(number);
        }
        //calculate out final result
        while(!stackOfSymbol.isEmpty()){
            String ele1 = stackOfNumber.pop();
            String ele2 = stackOfNumber.pop();
            String ele3 = stackOfSymbol.pop();
            result = calculate(ele1, ele2, ele3);
            stackOfNumber.push(""+result);
        }

        return result;
    }

    public static boolean isOperator(char operator){
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    public static boolean judge(String current, String previous){
       if(previous.contentEquals("+")||previous.contentEquals("-")){
           return !current.contentEquals("*") && !current.contentEquals("/");
       }
       return true;
    }

    public static int calculate(String num1, String num2, String symbol){
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
