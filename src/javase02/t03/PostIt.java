package javase02.t03;

import java.awt.*;

/**
 * Created by rybatsky
 */

public class PostIt extends WrittenOnMaterial {

    private Color color;

    public PostIt(String brand, int price, int size, Color color) {
        super(brand, price, size);
        this.color = color;
    }

    @Override
    public String toString() {
        return "\n Post-It " + super.toString() +
                ", color: " + color;
    }
}
