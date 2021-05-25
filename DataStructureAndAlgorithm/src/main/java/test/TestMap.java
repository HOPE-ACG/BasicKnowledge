package test;

import dfsandbfs.AdjoiningMatrixMap;
import org.junit.jupiter.api.Test;

public class TestMap {

    @Test
    public void testAdjoiningMatrixMap() {

        AdjoiningMatrixMap map = new AdjoiningMatrixMap();

        map.insertVertex('A');
        map.insertVertex('B');
        map.insertVertex('C');
        map.insertVertex('D');
        map.insertVertex('E');
        map.insertDistance('A', 'B', 10);
        map.insertDistance('A', 'D', 5);
        map.insertDistance('B', 'D', 30);
        map.insertDistance('B', 'C', 60);
        map.insertDistance('C', 'E', 20);

        System.out.println(map.getPathCount());
        System.out.println(map.getVertexesCount());

        map.showMap();
    }
}
