package javase13.t02.StAX;

import javase13.t02.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.stream.XMLStreamConstants.*;


/**
 * Created by rybatsky
 */
public class MenuStax {
    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("src\\javase13\\t02\\menu.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            List<Food> menu = process(reader);

            for (Food food: menu) {
                System.out.println(food.getName() + "   " + food.getPrice() + "    " + food.getDescription() + "    " + food.getCalories());
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<Food> process(XMLStreamReader reader) throws XMLStreamException {
        List<Food> menu = new ArrayList<>();
        Food food = null;
        MenuTag elementName = null;

        while (reader.hasNext()) {
            int type=reader.next();
            switch (type) {
                case START_ELEMENT:
                    elementName = MenuTag.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            food = new Food();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            food.setId(id);
                            break;
                    }
                    break;
                case CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            food.setName(text);
                            break;
                        case DESCRIPTION:
                            food.setDescription(text);
                            break;
                        case PRICE:
                            food.setPrice(text);
                            break;
                        case CALORIES:
                            Integer calories = Integer.parseInt(text);
                            food.setCalories(calories);
                            break;
                    }
                    break;
                case END_ELEMENT:
                    elementName = MenuTag.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            menu.add(food);
                            break;
                    }
            }
        }
        return menu;
    }
}
