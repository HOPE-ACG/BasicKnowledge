package examination.meituan;

import java.util.*;

public class AppleTree {

    static int n = 0;
    //static int[][] nodes;
    //static Map<Integer,Integer> dictionary;
    static int[] colors;
    static Map<Integer, List<Integer>> hashMap;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        hashMap = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            int frontNode = s.nextInt();
            int rearNode = s.nextInt();
            List<Integer> frontList = hashMap.getOrDefault(frontNode, new ArrayList<>());
            frontList.add(rearNode);
            hashMap.put(frontNode, frontList);
            List<Integer> rearList = hashMap.getOrDefault(rearNode, new ArrayList<>());
            rearList.add(frontNode);
            hashMap.put(rearNode, rearList);
        }
        modify(1);
        /*this method still means that input data from up to down
        nodes = new int[n][2];
        for(int i = 0; i < n - 1; i++){
            int node1 = s.nextInt();
            int node2 = s.nextInt();
            nodes[node1 - 1][i % 2] = node2;
            nodes[node2 - 1][i % 2] = node1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                if(nodes[i][j] < i + 1){
                    nodes[i][j] = 0;
                }
            }
        }*/
        /*dictionary = new HashMap<>();
        for(int i = 0; i < n; i++){
            int color = s.nextInt();
            dictionary.put(i+1,color);
        }*/
        colors = new int[n];
        for(int i = 0; i < n; i++){
            colors[i] = s.nextInt();
        }
        Map<Integer, Integer> treeMap = new TreeMap<>();
        int q = s.nextInt();
        for(int i = 0; i < q; i++){
            int init = s.nextInt();
            calc(init, treeMap);
            List<Integer> colorCount = new ArrayList<>(treeMap.values());
            Collections.sort(colorCount);
            Integer max = colorCount.get(colorCount.size() - 1);
            for(Map.Entry entry : treeMap.entrySet()){
                if(entry.getValue() == max){
                    System.out.println(entry.getKey());
                    break;
                }
            }
            treeMap.clear();
        }
    }

    public static void calc(int init, Map<Integer, Integer> treeMap){

        int color_num = colors[init - 1];
        treeMap.merge(color_num, 1, Integer::sum);
        //treeMap.put(color_num, treeMap.getOrDefault(color_num, 0) + 1);
        for(int child : hashMap.get(init)) {
            calc(child, treeMap);
        }
    }

    public static void modify(Integer root){

        List<Integer> children = hashMap.get(root);
        if(children.isEmpty()){
            return;
        }
        for(int child : children){
            List<Integer> grandChildren = hashMap.get(child);
            grandChildren.remove(root); //remove object, not via index
            hashMap.put(child, grandChildren);
            modify(child);
        }
    }

/*
20
2 1
1 3
2 4
5 2
3 6
3 7
8 5
9 5
6 10
6 11
8 12
8 13
11 14
15 11
13 16
13 17
14 18
14 19
20 18
8 10 8 12 6 5 10 10 9 20 6 9 6 10 8 9 8 5 7 8
6
1
3
5
2
6
11
*/
}
