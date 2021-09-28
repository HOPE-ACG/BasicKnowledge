package honor;
import java.util.HashSet;
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        //接受键盘输入
        Scanner s = new Scanner(System.in);
        //读取一行
        String input = s.nextLine();
        //删除中括号
        String str = input.substring(1, input.length() - 1);
        //HashSet保存重复数据
        HashSet<Integer> repeat = new HashSet<>();
        //另一个HashSet保存遍历数据
        HashSet<Integer> first = new HashSet<>();
        //按空格切分字符串
        String[] strs = str.split(" ");
        //遍历字符串数组
        for(String st : strs) {
            //当前字符串转为整数
            int cur = Integer.parseInt(st);
            if(!first.contains(cur)) {
                //目前位置当前字符没有出现
                first.add(cur);
            }else {
                //当前字符已出现过
                repeat.add(cur);
            }
        }
        //最终结果
        int sum = 0;
        //遍历重复字符，转化为整数型
        for(int i : repeat) {
            sum += i;
        }
        //输出
        System.out.println(sum);
    }
}
