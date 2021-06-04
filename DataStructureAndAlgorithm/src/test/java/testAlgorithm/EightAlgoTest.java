package testAlgorithm;

import eightalgorithm.HanoiTower;
import eightalgorithm.TelevisionStation;
import org.junit.Test;

public class EightAlgoTest {

    @Test
    public void testHanoiTower() {
        HanoiTower hanoiTower = new HanoiTower(10);
        System.out.println(hanoiTower.gameStart());
    }

    @Test
    public void testTelevisionStation() {
        TelevisionStation station = new TelevisionStation();
        station.add("中央经济频道", "北京", "天津", "上海");
        station.add("对外经贸电台", "北京", "广州", "深圳");
        station.add("旅游频道", "成都", "杭州", "上海");
        station.add("两地交流频道", "天津", "上海");
        station.add("南北通话电台", "杭州", "大连");

        station.optimumChoice();
    }
}
