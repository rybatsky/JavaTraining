package javase02.t03;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        List<Stationery> newbieSet = new ArrayList<>();

        newbieSet.add(new Pen("Brand 1", 20, Color.blue, "ballpoint"));
        newbieSet.add(new Pencil("Brand 2", 15, Color.gray, "HB"));
        newbieSet.add(new Paper("Brand 3", 5, 4, 1));
        newbieSet.add(new PostIt("Brand 4", 10, 2, Color.yellow));

        System.out.println(newbieSet);
    }
}
