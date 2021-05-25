package arrayandqueue;

import java.io.FileReader;
import java.io.IOException;

public class OriginalArray {

    public static void main(String[] args) {
        StringBuffer buffer = null;
        try {
            FileReader reader = new FileReader("D:\\java\\myproject\\sparsearray.txt");
            char[] chars = new char[1024];
            reader.read(chars);
            buffer = new StringBuffer(new String(chars));
            System.out.println(buffer.toString());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert buffer != null;
        String[] strs = buffer.toString().split("\n");
        String[] strs_sub;
        strs_sub = strs[0].split("\t");
        int[][] originalChess = new int[Integer.parseInt(strs_sub[0])][Integer.parseInt(strs_sub[1])];
        int count = Integer.parseInt(strs_sub[2]);
        int i = 1;
        for(;i<=count;i++){
            strs_sub = strs[i].split("\t");
            originalChess[Integer.parseInt(strs_sub[0])][Integer.parseInt(strs_sub[1])] = Integer.parseInt(strs_sub[2]);
        }

        i = 0;
        int j = 0;
        for(;i<originalChess.length;i++){
            for(;j<originalChess[i].length;j++){
               System.out.printf("%s\t", originalChess[i][j]);
            }
            System.out.println();
            j = 0;
        }
    }
}
