package eightalgorithm;

import java.util.*;

/**
 * Using prim algorithm to solve problem of repairing road
 *
 * @author ACHENGE
 */
public class RoadConstruction {

    /**
     * all villages that need repairing road to connect with
     */
    private final char[] villages = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    /**
     * the distance between all villages
     */
    private final int[][] map = new int[villages.length][villages.length];

    /**
     * initialize map
     */
    public RoadConstruction() {
        for (int[] villages : map) {
            Arrays.fill(villages, Integer.MAX_VALUE);
        }
        map[0][1] = 5; map[0][2] = 7; map[0][6] = 2;
        map[1][0] = 5; map[1][3] = 9; map[1][6] = 3;
        map[2][0] = 7; map[2][4] = 8;
        map[3][1] = 9; map[3][5] = 4;
        map[4][2] = 8; map[4][5] = 5; map[4][6] = 4;
        map[5][3] = 4; map[5][4] = 5; map[5][6] = 6;
        map[6][0] = 2; map[6][1] = 3; map[6][4] = 4; map[6][5] = 6;
        /*map[0][1] = 12; map[0][5] = 16; map[0][6] = 14;
        map[1][0] = 12; map[1][2] = 10; map[1][5] = 7;
        map[2][1] = 10; map[2][3] = 3; map[2][4] = 5; map[2][5] = 6;
        map[3][2] = 3; map[3][4] = 4;
        map[4][2] = 5; map[4][3] = 4; map[4][5] = 2; map[4][6] = 8;
        map[5][0] = 16; map[5][1] = 7; map[5][2] = 6; map[5][4] = 2; map[5][6] = 9;
        map[6][0] = 14; map[6][4] = 8; map[6][5] = 9;*/
    }

    /**
     * present distance between villages in map
     */
    public void showMap() {
        for (char village : villages) {
            int pos = village - 65;
            for(int i = 0; i < villages.length; i++) {
                System.out.printf("%12d", map[pos][i]);
            }
            System.out.println();
        }
    }

    /**
     * minimum cost spanning tree
     */
    public void mst() {
        boolean[] visited = new boolean[villages.length];
        List<Character> finalVillages = new ArrayList<>();
        char initVillage = villages[3];
        visited[initVillage - 65] = true;
        finalVillages.add(initVillage);
        Map<Character, Map<Character, Integer>> finalPath = new HashMap<>();
        char curVillage = initVillage;
        char addedVillage = initVillage;
        int addedPathWeigh = Integer.MAX_VALUE;
        for(int i = 1; i < villages.length; i++) {
            for (Character finalVillage : finalVillages) {
                for (char village : villages) {
                    if(!visited[village - 65] && map[finalVillage - 65][village - 65] < addedPathWeigh) {
                        curVillage = finalVillage;
                        addedVillage = village;
                        addedPathWeigh = map[finalVillage - 65][village - 65];
                    }
                }
            }
            finalVillages.add(addedVillage);
            Map<Character, Integer> addedFinalPath = finalPath.getOrDefault(curVillage, new HashMap<>());
            addedFinalPath.put(addedVillage, addedPathWeigh);
            finalPath.put(curVillage, addedFinalPath);
            visited[addedVillage - 65] = true;
            addedPathWeigh = Integer.MAX_VALUE;
        }
        Set<Map.Entry<Character, Map<Character, Integer>>> entries = finalPath.entrySet();
        for (Map.Entry<Character, Map<Character, Integer>> next : entries) {
            Character key = next.getKey();
            Map<Character, Integer> value = next.getValue();
            Set<Map.Entry<Character, Integer>> entries1 = value.entrySet();
            for (Map.Entry<Character, Integer> next1 : entries1) {
                Character key1 = next1.getKey();
                Integer value1 = next1.getValue();
                System.out.println(key + " --> " + key1 + " : " + value1 + "\n");
            }
        }
    }
}
