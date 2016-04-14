package javase01.t05;

/**
 * Created by rybatsky
 */
public class DiagonalMatrix {

    static void getMatrix(int n) {
        for (int i = 0; i < n; i++) {
            int[][] a = new int[n][n];
            a[i][i] = 1;
            a[i][n-i-1] = 1;
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}