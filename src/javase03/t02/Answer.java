package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rybatsky
 */

public class Answer {

    private ResourceBundle rb;

    public Answer(Locale locale) {
        rb = ResourceBundle.getBundle("javase03.t02.answer", locale);
    }

    public String getValue(String key) {
        return rb.getString(key);
    }
}