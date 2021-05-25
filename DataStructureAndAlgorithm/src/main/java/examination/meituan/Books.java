package examination.meituan;

import java.util.Scanner;

public class Books {

    static int n;
    static int[] books;
    static int[] books_putted;
    static int[][] bookshelf;
    static int m;
    static Scanner s;
    public static void main(String[] args){

        s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        books = new int[m];
        books_putted = new int[m];
        bookshelf = new int[n][m + 1];
        int q = s.nextInt();
        for(int i = 0; i < q; i++){
            int option = s.nextInt();
            operation(option);
        }
    }

    public static void operation(int option) {

        switch(option){
            case 1 :
                int x_1 = s.nextInt();
                int y_1 = s.nextInt();
                if(books[x_1 - 1] == -1){
                    break;
                }
                if(bookshelf[y_1 - 1][m] == -1){
                    break;
                }
                if(bookshelf[y_1 - 1][x_1 -1] == 1){
                    break;
                }
                if(books_putted[x_1 - 1] == 0){
                    bookshelf[y_1 - 1][x_1 - 1] = 1;
                    books_putted[x_1 - 1] = -1;
                    break;
                }
                for(int i = 0; i < n; i++){
                    if(i != y_1 - 1 && bookshelf[i][x_1 - 1] == 1){
                        bookshelf[i][x_1 - 1] = 0;
                        bookshelf[y_1 - 1][x_1 - 1] = 1;
                        books_putted[x_1 - 1] = -1;
                        break;
                    }
                }
                break;
            case 2 :
                int y_2 = s.nextInt();
                if(bookshelf[y_2 - 1][m] != -1){
                    bookshelf[y_2 - 1][m] = -1;
                }
                break;
            case 3 :
                int y_3 = s.nextInt();
                if(bookshelf[y_3 - 1][m] == -1){
                    bookshelf[y_3 - 1][m] = 0;
                }
                break;
            case 4 :
                int x_4 = s.nextInt();
                if(books[x_4 - 1] == -1){
                    System.out.println(-1);
                    break;
                }
                boolean find = false;
                for(int i = 0; i < n; i++){
                    if(bookshelf[i][m] != -1 && bookshelf[i][x_4 - 1] == 1){
                        System.out.println(i + 1);
                        bookshelf[i][x_4 - 1] = 0;
                        books[x_4 - 1] = -1;
                        find = true;
                        break;
                    }
                }
                if(!find){
                    System.out.println(-1);
                }
                break;
            case 5 :
                int x_5 = s.nextInt();
                if(books[x_5 - 1] == -1){
                    books[x_5 - 1] = 0;
                    books_putted[x_5 - 1] = 0;
                }
        }
    }

}
