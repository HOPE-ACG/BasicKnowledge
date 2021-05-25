package examination.huawei;

import java.util.Scanner;

public class HighestScore {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int n = s.nextInt();
            int m = s.nextInt();
            int[] scores = new int[n];
            for(int i = 0; i < n; i++){
                int score = s.nextInt();
                scores[i] = score;
            }
            for(int i = 0; i < m; i++){
                String str = s.next();
                char c = str.charAt(0);
                int a = s.nextInt();
                int b = s.nextInt();
                answer(scores, c, a, b);
            }
        }
    }

    public static void answer(int[] scores, char c, int a, int b){

        switch (c){
            case 'Q' :
                if(a > b){
                    int temp = b;
                    b = a;
                    a = temp;
                }
                int highest = scores[a - 1];
                for(int i = a ; i < b; i++){
                    highest = Math.max(highest, scores[i]);
                }
                System.out.println(highest);
                break;
            case 'U' :
                scores[a - 1] = b;
                break;
        }
    }
}
