package examination.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HuaWei {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        List<Character> temp = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            if(i == input.length() - 1 && input.charAt(i) == ')'){
                stack.remove(0);
                while(!stack.empty()){
                    System.out.print(stack.pop());
                }
                break;
            }else if(input.charAt(i) != ')'){
                stack.push(input.charAt(i));
            }else {
                while(true){
                    Character character = stack.pop();
                    if(character != '('){
                        temp.add(character);
                    }else {
                        break;
                    }
                }
                for(Character ch : temp){
                    stack.push(ch);
                }
                temp.clear();
            }
        }
    }
}
