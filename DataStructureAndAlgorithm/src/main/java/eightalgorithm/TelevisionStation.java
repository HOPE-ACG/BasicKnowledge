package eightalgorithm;

import java.util.*;

/**
 * The case of greedy algorithm
 * Situation:
 *      TV station          Cover Area
 *      中央经济频道          北京  天津  上海
 *      对外经贸电台          北京  广州  深圳
 *      旅游频道             成都  上海  杭州
 *      两地交流频道         上海  天津
 *      南北通话电台         杭州  大连
 *
 * @author ACHENGE
 */
public class TelevisionStation {

    /**
     * saving all TV stations and its cover areas
     */
    private final Map<String, List<String>> broadcast = new HashMap<>();

    /**
     * adding TV station and its cover area to collection
     * @param tvStation TV station
     * @param areas this TV station cover areas
     */
    public void add(String tvStation, String... areas) {

        List<String> coverAreas = broadcast.getOrDefault(tvStation, new ArrayList<>());
        Collections.addAll(coverAreas, areas);
        broadcast.put(tvStation, coverAreas);
    }

    /**
     * choosing least TV stations cover all areas' signal
     */
    public void optimumChoice() {

        List<String> optimalTVStations = new ArrayList<>();

        Set<String> tvStations = broadcast.keySet();
        HashSet<String> allUncoveredAreas = getAllAreas();

        List<String> currentMaxCoverUncoveredAreas = null;
        String currentOptimalTVStation = "";
        List<String> currentAreas;

        while(!allUncoveredAreas.isEmpty()) {
            for(String tvStation : tvStations) {
                currentAreas = broadcast.get(tvStation);
                currentAreas.retainAll(allUncoveredAreas);
                if(currentMaxCoverUncoveredAreas == null ||
                    currentAreas.size() > currentMaxCoverUncoveredAreas.size()) {
                    currentMaxCoverUncoveredAreas = currentAreas;
                    currentOptimalTVStation = tvStation;
                }
            }
            optimalTVStations.add(currentOptimalTVStation);
            tvStations.remove(currentOptimalTVStation);
            allUncoveredAreas.removeAll(currentMaxCoverUncoveredAreas);

            currentOptimalTVStation = "";
            currentMaxCoverUncoveredAreas = null;
        }

        System.out.println("Optimal Choice : " + optimalTVStations.toString());
    }

    /**
     * getting all areas that all TV stations cover
     * @return all covered areas
     */
    private HashSet<String> getAllAreas() {

        HashSet<String> allAreas = new HashSet<>();
        Set<String> tvStations = broadcast.keySet();
        for(String tvStation : tvStations) {
            List<String> areas = broadcast.get(tvStation);
            allAreas.addAll(areas);
        }
        return allAreas;
    }
}
