package javase01.t02;

import static java.lang.Math.pow;

/**
 * Created by rybatsky
 */

public class Min {

    static double calcA(int n) {
        return 1/(pow(n+1,2));
    }

    static double calcMin(double eps) {
        for (int i = 1;; i++) {
            double a = calcA(i);
            if (a < eps) {
                System.out.println("a_" + i + " = " + a + "\n" + "n = " + i);
                return a;
            } else {
                System.out.println("a_" + i + " = " + a);
            }
        }
    }
}
