package javase01.t04;

/**
 * Created by rybatsky
 */

public class MaxArray {

    static void calcMax (double[] a) {

        int n = a.length - 1;
        double max = a[0] + a [n];

        for (int i = 0; i < a.length/2; i++) {
            if (max < (a[i] + a[n-i])) {
                max = a[i] + a [n-i];
            }
        }

        System.out.println("max = " + max);
    }
}