package javase02.t03;

import java.awt.*;

/**
 * Created by rybatsky
 */

public class Pencil extends WritingMaterial {

    private String hardness;

    public Pencil(String brand, int price, Color color, String hardness) {
        super(brand, price, color);
        this.hardness = hardness;
    }

    @Override
    public String toString() {
        return "\n Pencil " + super.toString() +
                "hardness:'" + hardness + '\'';
    }
}
