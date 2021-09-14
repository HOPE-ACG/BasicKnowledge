package meituan;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();*/

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') continue;
            for(int j = i + 1; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                System.out.println(substring);
                int i1 = Integer.parseInt(substring);
                if(i1 % 22 == 0) {
                    count++;
                    System.out.println("===="+i1);
                }
            }
        }
        System.out.println(count);
    }
}
