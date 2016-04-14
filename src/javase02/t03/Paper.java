package javase02.t03;

/**
 * Created by rybatsky
 */

public class Paper extends WrittenOnMaterial {

    private int thickness;

    public Paper(String brand, int price, int size, int thickness) {
        super(brand, price, size);
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "\n Paper " + super.toString() +
                "thickness: " + thickness ;
    }
}
