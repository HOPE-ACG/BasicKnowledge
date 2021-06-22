package eightalgorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightTravel {

    /**
     * chess board
     */
    private final int[][] board = new int[6][6];

    /**
     * mark the place whether is visited
     */
    private final boolean[][] symbol = new boolean[board.length][board.length];

    /**
     * initial coordinate
     */
    private final Point initial = new Point();

    /**
     * final result
     */
    private final Point[] points = new Point[board.length * board.length];

    /**
     * initiate original coordinate
     * @param point initial coordinate
     */
    public KnightTravel(Point point) {
        this.initial.x = point.x;
        this.initial.y = point.y;
    }

    /**
     * Game Start
     */
    public void gameStart() {
        points[0] = initial;
        symbol[initial.x][initial.y] = true;
        ArrayList<Point> points = nextSteps(initial);
        if (findDestination(1, points)) {
            for (Point point : this.points) {
                System.out.println(point.toString());
            }
        }else {
            System.out.println("Game Over");
        }
    }

    /**
     * search final route
     * @param step walking step
     * @return whether finish game
     */
    private boolean findDestination(int step, List<Point> coordinates) {
        coordinates.sort(Comparator.comparingInt(p -> nextSteps(p).size()));
        for (Point coordinate : coordinates) {
            points[step] = coordinate;
            int coordinateX = coordinate.x;
            int coordinateY = coordinate.y;
            symbol[coordinateX][coordinateY] = true;
            ArrayList<Point> points = nextSteps(coordinate);
            if(points.isEmpty()) {
                if(step == (board.length * board.length) - 1) {
                    return true;
                }
                symbol[coordinateX][coordinateY] = false;
                return false;
            }
            if(findDestination(step + 1, points)) {
                return true;
            }
            symbol[coordinateX][coordinateY] = false;
        }
        return false;
    }

    /**
     * find the next steps of current ponit
     * @param current current point
     * @return next steps
     */
    private ArrayList<Point> nextSteps(Point current) {
        int coordinateX = current.x;
        int coordinateY = current.y;
        ArrayList<Point> coordinates = new ArrayList<>();
        if((coordinateX - 2) >= 0 && (coordinateY + 1) < board.length && !symbol[coordinateX - 2][coordinateY + 1]) {
            Point point = new Point(coordinateX - 2, coordinateY + 1);
            coordinates.add(point);
        }
        if((coordinateX - 2) >= 0 && (coordinateY - 1) >= 0 && !symbol[coordinateX - 2][coordinateY - 1]) {
            Point point = new Point(coordinateX - 2, coordinateY - 1);
            coordinates.add(point);
        }
        if((coordinateX + 2) < board.length && (coordinateY + 1) < board.length && !symbol[coordinateX + 2][coordinateY + 1]) {
            Point point = new Point(coordinateX + 2, coordinateY + 1);
            coordinates.add(point);
        }
        if((coordinateX + 2) < board.length && (coordinateY - 1) >= 0 && !symbol[coordinateX + 2][coordinateY - 1]) {
            Point point = new Point(coordinateX + 2, coordinateY - 1);
            coordinates.add(point);
        }
        if((coordinateX - 1) >= 0 && (coordinateY + 2) < board.length && !symbol[coordinateX - 1][coordinateY + 2]) {
            Point point = new Point(coordinateX - 1, coordinateY + 2);
            coordinates.add(point);
        }
        if((coordinateX - 1) >= 0 && (coordinateY - 2) >= 0 && !symbol[coordinateX - 1][coordinateY - 2]) {
            Point point = new Point(coordinateX - 1, coordinateY - 2);
            coordinates.add(point);
        }
        if((coordinateX + 1) < board.length && (coordinateY + 2) < board.length && !symbol[coordinateX + 1][coordinateY + 2]) {
            Point point = new Point(coordinateX + 1, coordinateY + 2);
            coordinates.add(point);
        }
        if((coordinateX + 1) < board.length && (coordinateY - 2) >= 0 && !symbol[coordinateX + 1][coordinateY - 2]) {
            Point point = new Point(coordinateX + 1, coordinateY - 2);
            coordinates.add(point);
        }
        return coordinates;
    }
}
