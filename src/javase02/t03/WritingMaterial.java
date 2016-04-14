package javase02.t03;

import java.awt.*;

/**
 * Created by rybatsky
 */

public class WritingMaterial extends Stationery {

    private Color color;

    public WritingMaterial(String brand, int price, Color color) {
        super(brand, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "color: " + color +"; ";
    }
}
