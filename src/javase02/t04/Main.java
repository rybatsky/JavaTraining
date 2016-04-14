package javase02.t04;

import javase02.t03.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        List<Stationery> newbieSet = new ArrayList<>();

        newbieSet.add(new Pen("Brand Pen 1", 20, Color.blue, "ballpoint"));
        newbieSet.add(new Pencil("Brand Pencil 1", 15, Color.gray, "HB"));
        newbieSet.add(new Paper("Brand Paper 1", 5, 4, 1));
        newbieSet.add(new PostIt("Brand Post-It 1", 10, 2, Color.yellow));
        newbieSet.add(new PostIt("Brand Post-It 0", 10, 1, Color.pink));
        System.out.println(newbieSet);

        Collections.sort(newbieSet, new StationerySortingByPrice());
        System.out.println(newbieSet);

        Collections.sort(newbieSet, new StationerySortingByBrand());
        System.out.println(newbieSet);

        Collections.sort(newbieSet, new StationerySortingByPriceAndBrand());
        System.out.println(newbieSet);
    }
}
