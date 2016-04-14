package javase02.t03;

import java.awt.*;

/**
 * Created by rybatsky
 */

public class Pen extends WritingMaterial {

    private String type;

    public Pen(String brand, int price, Color color, String type) {
        super(brand, price, color);
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n Pen " + super.toString() +
                "type: " + type;
    }
}
