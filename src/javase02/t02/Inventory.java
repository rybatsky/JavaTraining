package javase02.t02;

/**
 * Created by rybatsky
 */

public class Inventory {

    private String employeeName;
    private int pensQuantity;
    private int pencilsQuantity;
    private int postItQuantity;

    public Inventory (String employeeName, int pensQuantity, int pencilsQuantity, int postItQuantity) {
        this.employeeName = employeeName;
        this.pensQuantity = pensQuantity;
        this.pencilsQuantity = pencilsQuantity;
        this.postItQuantity = postItQuantity;
    }

    public String getEmployeeName() {
        return employeeName;
    }


    public int total () {
        int penPrice = 20;
        int pencilPrice = 10;
        int postItPrice = 30;
        return pensQuantity * penPrice + pencilsQuantity * pencilPrice + postItQuantity * postItPrice;
    }
}
