package hotsubject;

import java.util.*;

public class MaxVolumeContainer {

    public static void main(String[] args) {
        //int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        //int area = new MaxVolumeContainer().maxArea(height);
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);l2.add(2);
        Set l11 = (Set) l1;
        
        System.out.println(l1 == l2);
        //System.out.println(area);
    }

    public int maxArea(int[] height) {
        Map<Integer, List<Integer>> heights_seqs = new TreeMap<>();
        int n = height.length;
        for(int i = 1; i <= n; i++) {
            List<Integer> l =
                    heights_seqs.getOrDefault(height[i - 1], new ArrayList<>());
            l.add(i);
            heights_seqs.put(height[i - 1], l);
        }
        Set<Integer> heights = heights_seqs.keySet();
        int maxArea = 0;
        int maxDis = 0;
        int left;
        int right;
        for(Integer h : heights) {
            List<Integer> seqs = heights_seqs.get(h);
            for(Integer seq : seqs) {
                left = right = seq;
                for(int i = 1; i < seq; i++) {
                    if(height[i - 1] >= h) {
                        left = i;
                        break;
                    }
                }
                for(int j = n; j > seq; j--) {
                    if(height[j - 1] >= h) {
                        right = j;
                        break;
                    }
                }
                maxDis = Math.max(Math.max(right - seq, seq - left), maxDis);
            }
            maxArea = Math.max(h * maxDis, maxArea);
            maxDis = 0;
        }

        return maxArea;
    }
}
