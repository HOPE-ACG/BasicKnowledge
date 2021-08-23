package hotsubject;

import java.util.*;

public class WordsCombinationOfPhoneNumber {


    /**
     * combination's result set
     */
    private List<String> results = new ArrayList<>();

    /**
     * save the number's mapping
     */
    private List<String> words = new ArrayList<>();

    public static void main(String[] args) {
        List<String> strings = new WordsCombinationOfPhoneNumber().letterCombinations("22");
        System.out.println(strings);
        int[] m = new int[8];
        boolean[] s = new boolean[9];
        int a = (55 % 10);
        System.out.println(a);
    }

    public List<String> letterCombinations(String digits) {
        if(digits.trim().length() == 0) {
            return results;
        }
        String[] allDigits = digits.split("");
        for(String digit : allDigits) {
            switch(digit) {
                case "2":
                    words.add("abc");break;
                case "3":
                    words.add("def");break;
                case "4":
                    words.add("ghi");break;
                case "5":
                    words.add("jkl");break;
                case "6":
                    words.add("mno");break;
                case "7":
                    words.add("pqrs");break;
                case "8":
                    words.add("tuv");break;
                case "9":
                    words.add("wxyz");break;
            }
        }
        String word = words.get(0);
        String[] letters = word.split("");
        for(String letter : letters) {
            combination(letter, 1);
        }

        return results;
    }

    public void combination(String letter, int pos) {
        if(pos == words.size()) {
            results.add(letter);
            return;
        }
        String word = words.get(pos);
        String[] letters = word.split("");
        for(String le : letters) {
            combination(letter + le, pos + 1);
        }
    }
}
