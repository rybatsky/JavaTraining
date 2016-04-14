package javase03.t01;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rybatsky
 */

public class CrazyLogger {

    private StringBuilder stringBuilder;

    public CrazyLogger() {
        stringBuilder = new StringBuilder();
    }

    public void addMessage(String message) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy : HH-mm");
        stringBuilder.append("\"" + simpleDateFormat.format(date) + " - " + message + "\"");
    }

    public List<String> search(String phrase) {

        if(phrase.length() == 0) return null;

        int searchPosition = 0;
        int logBeginning;
        int logEnding;

        List<String> listResult = new ArrayList<>();

        try {
            while ((searchPosition = stringBuilder.indexOf(phrase, searchPosition)) != -1) {
                logBeginning = stringBuilder.lastIndexOf("\"", searchPosition);
                logEnding = stringBuilder.indexOf("\"", searchPosition);
                listResult.add(stringBuilder.substring(logBeginning, logEnding + 1));
                searchPosition = logEnding + 1;
            }
        } catch(StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return listResult;
    }
}