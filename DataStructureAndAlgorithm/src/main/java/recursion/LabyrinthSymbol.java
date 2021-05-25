package recursion;
/*
* Defined symbols for labyrinth
* @para symbol Different symbol represent specific meaning
* */
public enum LabyrinthSymbol {

    UNKNOWN(" "), WALL("*"), PASS("&"), IMPASSE("#");

    private final String symbol;

    LabyrinthSymbol(String s) {
        this.symbol = s;
    }

    public String getSymbol() {
        return symbol;
    }
}
