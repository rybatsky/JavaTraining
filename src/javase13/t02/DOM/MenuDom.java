package javase13.t02.DOM;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import javase13.t02.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rybatsky
 */

public class MenuDom {

    public static void main(String[] args) {

        DOMParser parser = new DOMParser();
        try {
            parser.parse("src\\javase13\\t02\\menu.xml");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        Document document = parser.getDocument();

        Element root = document.getDocumentElement();
        List<Food> menu = new ArrayList<>();

        NodeList foodNodes = root.getElementsByTagName("food");
        Food food = null;

        for (int i = 0; i < foodNodes.getLength(); i++) {
            food = new Food();
            Element foodElement = (Element) foodNodes.item(i);
            food.setId(Integer.parseInt(foodElement.getAttribute("id")));

            food.setName(getSingleChild(foodElement, "name").getTextContent().trim());
            food.setDescription(getSingleChild(foodElement, "description").getTextContent().trim());
            food.setPrice(getSingleChild(foodElement, "price").getTextContent().trim());
            food.setCalories(Integer.parseInt(getSingleChild(foodElement, "calories").getTextContent().trim()));
            menu.add(food);
        }

        for (Food f: menu) {
            System.out.println(f.getName() + " " + f.getPrice() + " " + f.getDescription() + " " + f.getCalories());
        }
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nodeList = element.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }
}
