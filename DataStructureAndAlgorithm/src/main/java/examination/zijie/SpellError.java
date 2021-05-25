package examination.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellError {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while(n > 0) {
            String word = s.next();
            List<Character> words = new ArrayList<>();
            for(int i = 0; i < word.length(); i++){
                words.add(word.charAt(i));
            }
            for(int i = 0; i < word.length();){
                if(words.get(i) == words.get(i + 1) && words.get(i + 1) == words.get(i + 2)){
                    words.remove(i + 2);
                }
                if(words.get(i) == words.get(i + 1) && words.get(i + 2) == words.get(i + 3)){
                    words.remove(i + 3);
                    i += 2;
                    continue;
                }
                i++;
            }
            StringBuffer sb = new StringBuffer();
            for(Character c : words){
                sb.append(c);
            }
            System.out.println(sb.toString());
            n--;
        }
    }
}
