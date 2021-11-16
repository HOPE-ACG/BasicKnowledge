package testAlgorithm;

import org.junit.Test;
import recursion.EightQueen;
import recursion.Labyrinth;

public class RecusionTest {

    public void testMaze(){
        Labyrinth l = new Labyrinth(10, 20);
        l.gameStart();
        l.gameStart2();
    }

    @Test
    public void testQueen(){
        EightQueen queen = new EightQueen();
        queen.gameStart();
    }
}
