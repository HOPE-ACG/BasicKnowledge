package hotsubject;

public class DifferentPaths {

    /**
     * record total schemes
     */
    private int count = 0;

    public static void main(String[] args) {
        int paths = new DifferentPaths().uniquePaths(20, 30);
        System.out.println(paths);
    }

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            paths[0][j] = 1;
        }
        int count = 0;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}
