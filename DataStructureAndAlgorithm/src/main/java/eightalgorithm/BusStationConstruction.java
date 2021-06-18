package eightalgorithm;

import java.util.*;

/**
 * Using kruskal algorithm to solve this problem
 *
 * @author ACHENGE
 */
public class BusStationConstruction {

    /**
     * all bus stations that need planning a route
     */
    private final char[] busStations = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    /**
     * the distance between bus stations
     */
    private final int[][] map = new int[busStations.length][busStations.length];

    /**
     * record certain station whether have been added to min route
     */
    private final boolean[] visited = new boolean[busStations.length];

    /**
     * record terminal of certain station in constructed route
     */
    private final int[] terminal = new int[busStations.length];

    /**
     * saving all routes
     */
    private final Map<Integer, Map<Character, Set<Character>>> routes = new TreeMap<>();

    /**
     * initialize map
     */
    public BusStationConstruction() {
        for (int[] stations : map) {
            Arrays.fill(stations, Integer.MAX_VALUE);
        }
        /*map[0][1] = 12; map[0][5] = 16; map[0][6] = 14;
        map[1][0] = 12; map[1][2] = 10; map[1][5] = 7;
        map[2][1] = 10; map[2][3] = 3; map[2][4] = 5; map[2][5] = 6;
        map[3][2] = 3; map[3][4] = 4;
        map[4][2] = 5; map[4][3] = 4; map[4][5] = 2; map[4][6] = 8;
        map[5][0] = 16; map[5][1] = 7; map[5][2] = 6; map[5][4] = 2; map[5][6] = 9;
        map[6][0] = 14; map[6][4] = 8; map[6][5] = 9;*/
        map[0][1] = 5; map[0][2] = 7; map[0][6] = 2;
        map[1][0] = 5; map[1][3] = 9; map[1][6] = 3;
        map[2][0] = 7; map[2][4] = 8;
        map[3][1] = 9; map[3][5] = 4;
        map[4][2] = 8; map[4][5] = 5; map[4][6] = 4;
        map[5][3] = 4; map[5][4] = 5; map[5][6] = 6;
        map[6][0] = 2; map[6][1] = 3; map[6][4] = 4; map[6][5] = 6;
    }

    /**
     * present distance between bus stations in map
     */
    public void showMap() {
        for (char station : busStations) {
            int pos = station - 65;
            for(int i = 0; i < busStations.length; i++) {
                System.out.printf("%12d", map[pos][i]);
            }
            System.out.println();
        }
    }

    /**
     * Kruskal Algorithm
     */
    public void kruskal() {
        saveRoutes();
        Map<Integer, Map<Character, List<Character>>> minRoutes = new HashMap<>();
        Set<Integer> distance = routes.keySet();
        for (Integer dis : distance) {
            Map<Character, Set<Character>> stations = routes.get(dis);
            Set<Character> origins = stations.keySet();
            for (Character origin : origins) {
                Set<Character> terminals = stations.get(origin);
                for (Character term : terminals) {
                    if(minRoutes.containsKey(dis) && visited[origin - 65] && visited[term - 65]) {
                        continue;
                    }else {
                        visited[origin - 65] = true;
                        visited[term - 65] = true;
                    }
                    int or = getTerminal(origin - 65);
                    int ter = getTerminal(term - 65);
                    if(or != ter) {
                        terminal[or] = ter;
                        Map<Character, List<Character>> minDis = minRoutes.getOrDefault(dis, new HashMap<>());
                        List<Character> minRoute = minDis.getOrDefault(origin, new ArrayList<>());
                        minRoute.add(term);
                        minDis.put(origin, minRoute);
                        minRoutes.put(dis, minDis);
                    }
                }
            }
        }
        Set<Integer> dis = minRoutes.keySet();
        for (Integer d : dis) {
            Map<Character, List<Character>> route = minRoutes.get(d);
            Set<Character> origin = route.keySet();
            for (Character ori : origin) {
                List<Character> terminal = route.get(ori);
                for (Character term : terminal) {
                    System.out.println(ori + " -- " + term + " : " + d + "\n");
                }
            }
        }
    }

    /**
     * get terminal of current bus station
     * notice:
     *        When adding route 'E -- G', the terminal of station 'F' will change to station 'G'
     * @param pos the position of current bus station
     * @return the terminal
     */
    private int getTerminal(int pos) {
        while (terminal[pos] != 0) {
            pos = terminal[pos];
        }
        return pos;
    }

    /**
     * add actual routes to collection for routes
     */
    private void saveRoutes() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] < Integer.MAX_VALUE) {
                    Map<Character, Set<Character>> station = routes.getOrDefault(map[i][j], new HashMap<>());
                    Set<Character> terminals = station.getOrDefault(busStations[i], new TreeSet<>());
                    terminals.add(busStations[j]);
                    station.put(busStations[i], terminals);
                    routes.put(map[i][j], station);
                }
            }
        }
    }
}
