package examination.tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TX {

    public static void main(String[] args) {

        // write code here
        List<Character> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String compress = s.nextLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for(int i = 0; i < compress.length(); i++){
            if(compress.charAt(i) != ']'){
                stack.push(compress.charAt(i));
            }else{
                while(!stack.empty()){
                    char ch = stack.pop();
                    if(ch != '['){
                        temp.push(ch);
                    }else{
                        break;
                    }
                }
                while(!temp.empty()){
                    char part = temp.pop();
                    if(part != '|'){
                        list.add(part);
                    }
                }
                int num = list.get(0) - '0';
                list.remove(0);
                for(int j = 0; j < num; j++){
                    for(char c : list){
                        stack.push(c);
                    }
                }
                list.clear();
            }
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        String result = "";
        for(int i = list.size() - 1; i > -1; i--){
            result += list.get(i);
        }

        System.out.println(result);
    }
}
