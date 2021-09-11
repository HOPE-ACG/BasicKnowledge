package hotsubject;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        List<List<Integer>> lists = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        quickSort(0, candidates.length - 1, candidates);
        for(int i : candidates) System.out.printf("%d\t", i);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] > target) break;
            if(candidates[i] == target) {
                l.add(candidates[i]);
                List<Integer> ch = new ArrayList<>(l);
                result.add(ch);
                break;
            }
            l.add(candidates[i]);
            recursion(l, target, candidates, i, candidates[i]);
            l.remove(l.size() - 1);
        }
        return result;
    }

    public void recursion(List<Integer> l, int target, int[] candidates, int curPos, int sum) {

        for(int i = curPos; i < candidates.length; i++) {
            sum += candidates[i];
            if(sum > target) break;
            if(sum == target) {
                List<Integer> ch = new ArrayList<>(l);
                ch.add(candidates[i]);
                result.add(ch);
                break;
            }
            l.add(candidates[i]);
            recursion(l, target, candidates, i, sum);
            l.remove(l.size() - 1);
            sum -= candidates[i];
        }
    }

    public void quickSort(int left, int right, int[] can) {

        int l = left;
        int r = right;
        int base = can[(l + r) /2];
        while(l < r) {
            while(can[l] < base) l++;
            while(can[r] > base) r--;
            if(l >=r ) break;
            int tem = can[l];
            can[l] = can[r];
            can[r] = tem;
            if(can[r] == base) l++;
            if(can[l] == base) r--;
        }
        if(l == r) {
            l++;
            r--;
        }
        if(l < right) quickSort(l, right, can);
        if(r > left) quickSort(left, r, can);
    }
}
