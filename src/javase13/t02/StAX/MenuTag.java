package javase13.t02.StAX;

/**
 * Created by rybatsky
 */

public enum MenuTag {
    NAME,
    PRICE,
    DESCRIPTION,
    CALORIES,
    FOOD,
    BREAKFAST_MENU;

    public static MenuTag getElementTagName (String element) {
        switch (element) {
            case "food":
                return FOOD;
            case "price":
                return PRICE;
            case "description":
                return DESCRIPTION;
            case "name":
                return NAME;
            case "calories":
                return CALORIES;
            case "breakfast-menu":
                return BREAKFAST_MENU;
            default:
                throw new EnumConstantNotPresentException(MenuTag.class, element);
        }
    }
}
