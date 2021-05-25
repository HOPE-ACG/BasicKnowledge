package recursion;

/*
* Maze recall problem
* @para maze represent a map
* */
public class Labyrinth {

    private String[][] maze = new String[8][7];
    private final int initRow = 0;
    private final int initCol = 1;
    private int finalRow = maze.length-1;
    private int finalCol = maze[0].length-2;

    public Labyrinth(){}

    public Labyrinth(int row, int col){
        this.maze = new String[row][col];
        this.finalRow = maze.length-1;
        this.finalCol = maze[0].length-2;
    }

    public void gameStart(){
        map();
        if(strategy(initRow, initCol)){
            for (String[] strings : maze) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(strings[j] + " ");
                }
                System.out.println();
            }
            //System.out.println(Arrays.toString(maze));
        }else{
            System.out.println("LOSS ROAD!!");
        }
    }

    public void gameStart2(){
        map();
        if(strategy2(initRow, initCol)){
            for (String[] strings : maze) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(strings[j] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("LOSS ROAD!!");
        }
    }

    public boolean strategy(int row, int col) {
        //down-right-up-left
        if (row == finalRow && col == finalCol) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return true;
        }
        if (maze[row + 1][col].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy(row + 1, col);
        } else if (maze[row][col + 1].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy(row, col + 1);
        } else if (maze[row - 1][col].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy(row - 1, col);
        } else if (maze[row][col - 1].contentEquals("")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy(row, col - 1);
        } else {
            return false;
        }
    }

    public boolean strategy2(int row, int col) {
        //right-down-left-up
        if (row == finalRow && col == finalCol) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return true;
        }
        if (maze[row][col + 1].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy2(row, col + 1);
        } else if (maze[row + 1][col].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy2(row + 1, col);
        } else if (maze[row][col - 1].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy2(row, col - 1);
        } else if (maze[row - 1][col].contentEquals(" ")) {
            maze[row][col] = LabyrinthSymbol.PASS.getSymbol();
            return strategy2(row - 1, col);
        } else {
            return false;
        }
    }

    public void map(){
        //Create a map according to rule
        int rows = maze.length;
        int cols = maze[0].length;
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                maze[i][j] = LabyrinthSymbol.UNKNOWN.getSymbol();
            }
        }
        for(int i=0;i<rows;i++){
           maze[i][0] = LabyrinthSymbol.WALL.getSymbol();
           maze[i][cols-1] = LabyrinthSymbol.WALL.getSymbol();
           if(i==rows/2-1 || i==rows/2|| i==rows/2+1){
               maze[i][cols/2-1] = LabyrinthSymbol.WALL.getSymbol();
               maze[i][cols/2] = LabyrinthSymbol.WALL.getSymbol();
               maze[i][cols/2+1] = LabyrinthSymbol.WALL.getSymbol();
           }
        }
        for(int j=1;j<cols-1;j++){
            maze[0][j] = LabyrinthSymbol.WALL.getSymbol();
            maze[rows-1][j] = LabyrinthSymbol.WALL.getSymbol();
            if(j==1 || j==2 || j==3 || j==4){
                maze[rows/2-1][j] = LabyrinthSymbol.WALL.getSymbol();
                maze[rows/2][j] = LabyrinthSymbol.WALL.getSymbol();
                maze[rows/2+1][j] = LabyrinthSymbol.WALL.getSymbol();
            }
            if(j==5){
                maze[rows/2][j] = LabyrinthSymbol.WALL.getSymbol();
                maze[rows/2+1][j] = LabyrinthSymbol.WALL.getSymbol();
            }
            if(j==6){
                maze[rows/2+1][j] = LabyrinthSymbol.WALL.getSymbol();
            }
            if(j>cols/2+2){
                maze[rows/2-1][j] = LabyrinthSymbol.WALL.getSymbol();
                maze[rows/2][j] = LabyrinthSymbol.WALL.getSymbol();
                maze[rows/2+1][j] = LabyrinthSymbol.WALL.getSymbol();
            }
        }
        maze[initRow][initCol] = LabyrinthSymbol.UNKNOWN.getSymbol();
        maze[finalRow][finalCol] = LabyrinthSymbol.UNKNOWN.getSymbol();
    }
}
