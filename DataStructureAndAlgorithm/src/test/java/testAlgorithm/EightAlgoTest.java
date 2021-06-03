package testAlgorithm;

import eightalgorithm.HanoiTower;
import org.junit.Test;

public class EightAlgoTest {

    @Test
    public void testHanoiTower() {
        HanoiTower hanoiTower = new HanoiTower(10);
        System.out.println(hanoiTower.gameStart());
    }
}
