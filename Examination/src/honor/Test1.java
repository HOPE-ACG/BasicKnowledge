package honor;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Test1 {

    public static void main(String[] args) {
        //接受键盘输入
        Scanner s = new Scanner(System.in);
        //接受输入的一行
        String input = s.nextLine();
        //去掉中括号
        String str = input.substring(1, input.length() - 1);
        //创建TreeSet集合，可以自动排序, 保存无重复字符
        TreeSet<Character> chars = new TreeSet<>();
        //创建HashSet集合，保存重复字符
        HashSet<Character> repeat = new HashSet<>();
        //遍历输入的字符串的每个字符
        for(int i = 0; i < str.length(); i++) {
            //获取当前字符
            char c = str.charAt(i);
            //如是空字符，直接进入下一个循环
            if(c == ' ') continue;
            //若TreeSet中无此字符并且HashSet中也无此字符，保存到TreeSet
            if(!repeat.contains(c) && !chars.contains(c)) {
                chars.add(c);
            }else {
                //否则移除TreeSet中当前字符，若没有此字符，则不操作
                chars.remove(c);
                //HashSet集合保存重复字符，若有此字符，则覆盖
                repeat.add(c);
            }
        }
        //将保存的无重复字符保存到StringBuilder容器，字符已自动排序
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            sb.append(c);
        }
        //直接输出容器中的字符串
        System.out.println(sb.toString());
    }
}
