package testAlgorithm;

import eightalgorithm.*;
import org.junit.Test;

import java.awt.*;

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

    @Test
    public void testRoadConstruction() {
        RoadConstruction roadConstruction = new RoadConstruction();
        roadConstruction.showMap();
        roadConstruction.mst();
    }

    @Test
    public void testBusStationConstruction() {
        BusStationConstruction busStationConstruction = new BusStationConstruction();
        busStationConstruction.showMap();
        busStationConstruction.kruskal();
    }

    @Test
    public void testKnightTravel() {
        KnightTravel knightTravel = new KnightTravel(new Point(3, 2));
        knightTravel.gameStart();
    }
}
