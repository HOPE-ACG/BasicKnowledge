package testDataStructure;

import dfsandbfs.AdjoiningMatrixMap;
import dfsandbfs.BFS;
import dfsandbfs.DFS;

public class TestMap {

    public void testAdjoiningMatrixMap() {

        AdjoiningMatrixMap map = new AdjoiningMatrixMap();

        map.insertVertex('A');
        map.insertVertex('B');
        map.insertVertex('C');
        map.insertVertex('E');
        map.insertVertex('F');
        map.insertVertex('G');
        map.insertVertex('Q');
        map.insertVertex('W');
        map.insertVertex('Z');
        map.insertDistance('A', 'B', 10);
        map.insertDistance('A', 'F', 5);
        map.insertDistance('B', 'C', 30);
        map.insertDistance('B', 'G', 60);
        map.insertDistance('C', 'G', 20);
        map.insertDistance('C', 'W', 25);
        map.insertDistance('E', 'F', 14);
        map.insertDistance('E', 'W', 54);
        map.insertDistance('G', 'Q', 34);
        map.insertDistance('G', 'Z', 276);
        map.insertDistance('Q', 'W', 232);

        System.out.println(map.getVertexesCount());
        System.out.println(map.getPathCount());

        map.showMap();

        DFS.MatrixDFS(map);
        BFS.MatrixBFS(map);
    }
}
