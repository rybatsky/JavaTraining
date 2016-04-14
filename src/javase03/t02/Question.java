package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rybatsky
 */

public class Question {

    private ResourceBundle rb;

    public Question(Locale locale) {
        rb = ResourceBundle.getBundle("javase03.t02.question", locale);
    }

    public String getValue(String key) {
        return rb.getString(key);
    }
}