package javase02.t04;

import javase02.t03.Stationery;
import java.util.Comparator;

/**
 * Created by rybatsky
 */

public class StationerySortingByBrand implements Comparator<Stationery> {

    public int compare (Stationery stationery1, Stationery stationery2) {
        return stationery1.getBrand().compareTo(stationery2.getBrand());
    }
}
