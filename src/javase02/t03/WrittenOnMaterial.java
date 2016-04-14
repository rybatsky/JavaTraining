package javase02.t03;

/**
 * Created by rybatsky
 */

public class WrittenOnMaterial extends Stationery{

    private int size;

    public WrittenOnMaterial(String brand, int price, int size) {
        super(brand, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + "size: " + size + "; ";
    }
}
