package javase03.t01;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        CrazyLogger log = new CrazyLogger();

        log.addMessage("message1");
        log.addMessage("message2");
        log.addMessage("message1, message2");
        log.addMessage("message22");

        System.out.println(log.search("message"));
        System.out.println(log.search("message1"));
        System.out.println(log.search("message22"));
    }
}