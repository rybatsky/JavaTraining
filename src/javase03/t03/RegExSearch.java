package javase03.t03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rybatsky
 */

public class RegExSearch {

    static StringBuilder text = new StringBuilder();

    static String regExRis = "(\\([р|Р]ис.[\\s|\\S]\\d.?\\))|(\\([р|Р]ис.[\\s|\\S]\\d.+?\\))";
    static String regExSentence = "(^|(?<=[.!?]\\s))(\\d+\\.\\s?)*[А-ЯA-Z][^!?]*?[.!?](?=\\s*(\\d+\\.\\s)*[А-ЯA-Z]|$)";
    static String regExNumber = "\\d";
    static String regExTag = "(<[\\/\\!]*?[^<>]*?>)|\\&.+?\\;";

    static Pattern patternRis = Pattern.compile(regExRis);
    static Pattern patternSentence = Pattern.compile(regExSentence);
    static Pattern patternNumber = Pattern.compile(regExNumber);
    static Pattern patternTag = Pattern.compile(regExTag);

    public static void loading() {
        String s;
        try {
            FileReader in = new FileReader("src\\javase03\\t03\\Java.SE.03.Information handling_task_attachment.html");
            BufferedReader br = new BufferedReader(in);
            while ((s = br.readLine()) != null) {
                text.append(s);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void find() {
        int risN = 0;
        Matcher matcherRis = patternRis.matcher(text);
        Matcher matcherNumber;
        boolean order = true;
        String result;

        while (matcherRis.find()) {
            result = matcherRis.group();
            matcherNumber = patternNumber.matcher(result);
            matcherNumber.find();
            if (order) {
                if (risN > Integer.parseInt(matcherNumber.group())) {
                    order = false;
                } else {
                    risN = Integer.parseInt(matcherNumber.group());
                }
            }
        }
        if (!order) System.out.println("References are not in order.");
        else System.out.println("References are in order");
    }

    public static void group() {
        Matcher matcherRis;
        Matcher matcherTag = patternTag.matcher(text);
        String noTagText = matcherTag.replaceAll("");
        Matcher matcherSentence = patternSentence.matcher(noTagText);

        while (matcherSentence.find()) {
            matcherRis = patternRis.matcher(matcherSentence.group());
            if (matcherRis.find()) {
                System.out.println(matcherSentence.group());
            }
        }
    }
}