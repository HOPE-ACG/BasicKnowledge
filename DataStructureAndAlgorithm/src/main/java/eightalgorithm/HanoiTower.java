package eightalgorithm;

/**
 * The case of divide-and-conquer algorithm
 * Rules:
 *      1. Bigger size plates is always up to smaller size plates.
 *      2. Every time only moving one plate.
 *      3. All plates are moved to most right pillar, winning the game.
 * @author ACHENGE
 */
public class HanoiTower {

    /**
     * The plates' count
     */
    private final int plate;

    public HanoiTower(int plate) {
        this.plate = plate;
    }

    /**
     * Game Start
     * @return game's result this time
     */
    public String gameStart() {

        algorithm(plate, 'A', 'B', 'C');

        return "SUCCESS";
    }

    /**
     * How to play this Hanoi Tower game?
     * @param num initial plate's number
     * @param a A pillar
     * @param b B pillar
     * @param c C pillar
     */
    public void algorithm(int num, char a, char b, char c) {

        if (num == 1) {
            System.out.println("Moved Plate " + num + " from Pillar " + a + " to Pillar " + c);
        } else {
            algorithm(num - 1, a, c, b);
            System.out.println("Moved Plate " + num + " from Pillar " + a + " to Pillar " + c);
            algorithm(num - 1, b, a, c);
        }
    }
}
