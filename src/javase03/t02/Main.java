package javase03.t02;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Scanner;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        StringBuilder sbQuestion = new StringBuilder("question");
        StringBuilder sbAnswer = new StringBuilder("answer");
        //int n;
        Question question = null;
        Answer answer = null;

        System.out.println("1 Eng, 2 Рус");

        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            if (n == 1) {
                question = new Question(new Locale("en", "US"));
                answer = new Answer(new Locale("en", "US"));
            } else if (n == 2) {
                question = new Question(new Locale("ru", "RU"));
                answer = new Answer(new Locale("ru", "RU"));
            }
            for (int i = 1; i < 6; i++) {
                sbQuestion.append(i);
                System.out.println(question.getValue(sbQuestion.toString()));
                sbQuestion.deleteCharAt(8);
            }
            n = in.nextInt();
            sbAnswer.append(n);
            System.out.println(answer.getValue(sbAnswer.toString()));
        } catch (InputMismatchException e) {
            System.out.println("Wrong input.");
        } catch (MissingResourceException e) {
            System.out.println("Wrong input.");
        } catch (NullPointerException e) {
            System.out.println("Wrong input.");
        }
    }
}
