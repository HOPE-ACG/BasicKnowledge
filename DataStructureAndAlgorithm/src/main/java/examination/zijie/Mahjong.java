package examination.zijie;

import java.util.*;

public class Mahjong {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String pai = s.nextLine();
        String[] pais = pai.split(" ");
        int[] hand = new int[pais.length];
        for(int i = 0; i < pais.length; i++){
            hand[i] = Integer.parseInt(pais[i]);
        }
        Map<Integer, Integer> statistic = new TreeMap<>();
        for(Integer p : hand){
            Integer count = statistic.getOrDefault(p, 0) + 1;
            statistic.put(p, count);
        }
        int[] result = new int[9];
        int index = 0;
        for(int i = 1; i < 10; i++){
            Map<Integer, Integer> clone = new TreeMap<>(statistic);
            Integer count = clone.getOrDefault(i, 0) + 1;
            if(count < 5){
                clone.put(i, count);
                if(judge(clone)){
                    result[index++] = i;
                }
            }
        }
        Arrays.sort(result);
        if(result[8] == 0){
            System.out.print(0);
        }else{
            for(int r : result){
                if(r != 0){
                    System.out.print(r+" ");
                }
            }
        }
    }

    public static boolean judge(Map<Integer, Integer> statistic){

        Set<Integer> key = statistic.keySet();
        for(Integer k : key){
            Integer v = statistic.get(k);
            if(v >= 2){
                Map<Integer, Integer> clone = new TreeMap<>(statistic);
                Integer val = clone.get(k);
                clone.put(k, val - 2);
                if(cal(clone)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cal(Map<Integer, Integer> map){

        Set<Integer> key = map.keySet();
        for(Integer k : key){
            while(map.get(k) != 0){
                Integer v = map.get(k);
                if(v == 3){
                    map.put(k, 0);
                }else if(v == 4){
                    map.put(k, 1);
                }else {
                    Integer val = map.get(k + 1);
                    if(val != null && val > 0){
                        map.put(k + 1, val - 1);
                    }else {
                        return false;
                    }
                    Integer value = map.get(k + 2);
                    if(value != null && value > 0){
                        map.put(k + 2, value - 1);
                    }else {
                        return false;
                    }
                    map.put(k, v - 1);
                }
            }
        }
        return true;
    }
}
