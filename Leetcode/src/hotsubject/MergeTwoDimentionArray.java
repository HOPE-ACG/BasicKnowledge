package hotsubject;

import java.util.*;

public class MergeTwoDimentionArray {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result = new MergeTwoDimentionArray().merge(intervals);
        int[][] result2 = new MergeTwoDimentionArray().merge2(intervals);
        System.out.println(Arrays.deepToString(result));
        System.out.println(Arrays.deepToString(result2));
    }

    public int[][] merge2(int[][] intervals) {

        if(intervals.length == 0) return intervals;
        //!!!classical
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] ready = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0] > ready[1]) {
                list.add(ready);
                ready = cur;
            }else {
                ready[0] = Math.min(ready[0], cur[0]);
                ready[1] = Math.max(ready[1], cur[1]);
            }
            if(i == intervals.length - 1) {
                list.add(ready);
            }
        }
        int[][] result = new int[list.size() == 0?1:list.size()][2];
        if(intervals.length == 1) {
            result[0] = ready;
        }
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return intervals;
        quick(0, intervals.length - 1, intervals);
        int[] ready = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0] > ready[1]) {
                list.add(ready);
                ready = cur;
            }else {
                ready[0] = Math.min(ready[0], cur[0]);
                ready[1] = Math.max(ready[1], cur[1]);
            }
            if(i == intervals.length - 1) {
                list.add(ready);
            }
        }
        int[][] result = new int[list.size() == 0?1:list.size()][2];
        if(intervals.length == 1) {
            result[0] = ready;
        }
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void quick(int left, int right, int[][] intervals) {

        int l = left;
        int r = right;
        int ref = intervals[(l + r) / 2][0];
        while(l < r) {
            while(intervals[l][0] < ref) l++;
            while(intervals[r][0] > ref) r--;
            if(l >= r) break;
            int[] temp = intervals[l];
            intervals[l] = intervals[r];
            intervals[r] = temp;
            if(intervals[l][0] == ref) r--;
            if(intervals[r][0] == ref) l++;
        }
        if(l == r) {
            l++;
            r--;
        }
        if(l < right) quick(l, right, intervals);
        if(r > left) quick(left, r, intervals);
    }
}
