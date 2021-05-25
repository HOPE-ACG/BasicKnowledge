package arrayandqueue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArray {

    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int[][] sparseBoard = chessboard_sparse();
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("D:\\java\\myproject\\sparsearray.txt"));
            for(;i<sparseBoard.length;i++){
                for(;j<sparseBoard[i].length;j++){
                    writer.write(sparseBoard[i][j]+"\t");
                }
                writer.write("\n");
                j = 0;
            }
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int[][] chessboard(){
        int[][] board = new int[11][11];
        board[1][1] = 2;
        board[2][2] = 1;    //1 represent white chess, 2 represents black chess
        return board;
    }

    public static int[][] chessboard_sparse(){
        int[][] board = chessboard();
        int rows = board.length;
        int cols = board[0].length;
        int[][] sparseBoard = new int[3][3];
        sparseBoard[0][0] = rows;
        sparseBoard[0][1] = cols;
        sparseBoard[0][2] = 2;
        int i = 0;
        int j = 0;
        int count = 1;
        for(;i<board.length;i++){
            for(;j<board[i].length;j++){
                if(board[i][j]!=0){
                    sparseBoard[count][0] = i;
                    sparseBoard[count][1] = j;
                    sparseBoard[count][2] = board[i][j];
                    count++;
                }
            }
            j = 0;
        }
        return sparseBoard;
    }
}
