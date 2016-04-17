package javase13.t02.SAX;

import javase13.t02.Food;
import jdk.internal.org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLReporter;
import java.io.IOException;
import java.util.List;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        org.xml.sax.XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSax menuSax = new MenuSax();
        reader.setContentHandler(menuSax);

        reader.parse(new InputSource("src\\javase13\\t02\\menu.xml"));

        List<Food> menu = menuSax.getFoodList();

        for (Food food: menu) {
            System.out.println(food.getName() + " " + food.getPrice() + " " + food.getDescription() + " " + food.getCalories());
        }
    }
}
