package javase02.t02;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        Inventory inventory1 = new Inventory("Employee 1", 1, 2, 3);
        Inventory inventory2 = new Inventory("Employee 2", 2, 1, 3);
        Inventory inventory3 = new Inventory("Employee 3", 1, 1, 1);

        System.out.println(inventory1.getEmployeeName() + "'s total: " + inventory1.total());
        System.out.println(inventory2.getEmployeeName() + "'s total: " + inventory2.total());
        System.out.println(inventory3.getEmployeeName() + "'s total: " + inventory3.total());
    }
}
