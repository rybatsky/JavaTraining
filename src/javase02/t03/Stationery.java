package javase02.t03;

/**
 * Created by rybatsky
 */

public class Stationery {

    private String brand;
    private  int price;

    public Stationery (String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + ", price: " + price + "; ";
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}
