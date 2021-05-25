package dfsandbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Building map by using adjoining matrix data structure
 *
 * @author ACHENGE
 */
public class AdjoiningMatrixMap {

    /**
     * save all vertexes of map
     */
    private final List<Character> vertexes = new ArrayList<>();

    public List<Character> getVertexes() {
        return vertexes;
    }

    /**
     * save distance between two vertexes
     */
    private final int[][] path = new int[26][26];

    public int[][] getPath() {
        return path;
    }

    /**
     * Insert vertex into vertexes list
     * @param vertex being inserted vertex
     */
    public void insertVertex(Character vertex) {

        vertexes.add(vertex);
    }

    /**
     * Assign value to path between two vertex.
     * ASCII :
     *      A --> 65;
     *      a --> 97;
     *      0 --> 48;
     * @param vertex1 anyone vertex between two vertexes
     * @param vertex2 anyone vertex between two vertexes
     * @param dis the distance
     */
    public void insertDistance(Character vertex1, Character vertex2, int dis) {

        path[vertex1 - 65][vertex2 - 65] = dis;
        path[vertex2 - 65][vertex1 - 65] = dis;
    }

    /**
     * Acquire count of vertexes
     * @return count of vertexes
     */
    public int getVertexesCount() {

        return vertexes.size();
    }

    /**
     * Acquire count of path
     * @return count of path
     */
    public int getPathCount() {

        int paths = 0;
        for(int i = 0; i < path.length - 1; i++) {
            for(int j = i + 1; j < path[0].length; j++) {
                if(path[i][j] != 0) {
                    paths++;
                }
            }
        }
        return paths;
    }

    /**
     * Show whole map
     */
    public void showMap() {

        System.out.print("\t\t");
        for(Character ch : vertexes) {
            System.out.print(ch + "\t\t");
        }
        System.out.println();
        for(Character ch : vertexes) {
            System.out.print(ch + "\t\t");
            for(Character c : vertexes) {
                System.out.print(path[ch - 65][c - 65] + "\t\t");
            }
            System.out.println();
        }
    }
}
