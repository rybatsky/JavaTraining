package javase01.t03;

import static java.lang.Math.tan;

/**
 * Created by rybatsky
 */

public class FuncTable {

    public static void calcFunc(double a, double b, double h) {

        for (double x = a; x <= b; x += h) {
            double f = tan(2 * x) - 3;
            System.out.println("x = " + x + "; f = " + f);
        }
    }
}