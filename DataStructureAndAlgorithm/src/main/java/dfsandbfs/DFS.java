package dfsandbfs;

import java.util.List;

/**
 * Depth First Search for matrix form and linked list form
 */
public class DFS {

    /**
     * Find all vertexes of Adjoining Matrix Map via Depth First Search
     * @param map Adjoining Matrix Map
     */
    public static void MatrixDFS(AdjoiningMatrixMap map) {

        List<Character> vertexes = map.getVertexes();
        int[][] path = map.getPath();
        boolean[] isVisited = new boolean[26];
        StringBuilder stringBuilder = new StringBuilder();
        for(Character vertex : vertexes) {
            if(!isVisited[vertex - 65]) {
                isVisited[vertex - 65] = true;
                stringBuilder.append(vertex);
                stringBuilder.append("\t-->\t");
                algorithmForMatrix(vertex, path, isVisited, stringBuilder);
            }
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.lastIndexOf("-->")));
    }

    /**
     * Utilize this method to do vertexes recursion
     * @param initialVertex first vertex of recursion
     * @param path all paths of Adjoining Matrix Map
     * @param isVisited mark all vertexed whether being accessed
     */
    private static void algorithmForMatrix(Character initialVertex, int[][] path, boolean[] isVisited, StringBuilder stringBuilder) {

        for(int i = 0; i < path[0].length; i++) {
            if(path[initialVertex - 65][i] != 0) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    stringBuilder.append((char)(65 + i));
                    stringBuilder.append("\t-->\t");
                    algorithmForMatrix((char)(65 + i), path, isVisited, stringBuilder);
                }
            }
        }
    }

    public static void linkedlistDFS() {


    }
}