package javase13.t02.SAX;

import javase13.t02.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rybatsky
 */

public class MenuSax extends DefaultHandler {

    private List<Food> foodList = new ArrayList<>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement -> " + "uri:" + uri + ", localName: " + localName + ", qName: " + qName );

        text = new StringBuilder();
        if (qName.equals("food")) {
            food = new Food();
            food.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTag tagName = MenuTag.valueOf(qName.toUpperCase().replace("-", "_"));

        switch (tagName) {
            case NAME:
                food.setName(text.toString());
                break;
            case PRICE:
                food.setPrice(text.toString());
                break;
            case DESCRIPTION:
                food.setDescription(text.toString());
                break;
            case CALORIES:
                food.setCalories(Integer.parseInt(text.toString()));
                break;
            case FOOD:
                foodList.add(food);
                food = new Food();
                break;
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) throws SAXException {
        text.append(buffer, start, length);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("WARNING: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("ERROR: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("FATAL: line " + e.getLineNumber() + ": " + e.getMessage());
        throw e;
    }
}
