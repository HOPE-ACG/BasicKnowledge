package hotsubject;

import java.util.ArrayDeque;

public class LargestRectangleArea {

    public static void main(String[] args) {

        int[] heights = new int[]{2,1,5,6,2,3};
        int max = largestRectangleArea(heights);
        System.out.println(max);
    }

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        if(n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        circle(deque, 0, 1, heights, right);
        while(!deque.isEmpty()) {
            right[deque.pollLast()] = n-1;
        }
        circle(deque, n-1, -1, heights, left);
        while(!deque.isEmpty()) {
            left[deque.pollLast()] = 0;
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, heights[i]*(right[i]-left[i]+1));
        }
        return max;
    }

    public static void circle(ArrayDeque<Integer> deque, int start, int add, int[] heights, int[] array) {

        for(int i = start; i < heights.length && i >= 0;) {
            int cur = heights[i];
            if(deque.isEmpty()) {
                deque.addLast(i);
                i += add;
            }else {
                if(heights[deque.getLast()] <= cur) {
                    deque.addLast(i);
                    i += add;
                } else {
                    array[deque.pollLast()] = i-add;
                }
            }
        }
    }
}
