package javase04.t03;

import java.io.*;

/**
 * Created by rybatsky
 */

public class Converter {

    private File input;
    private File output;
    private String text;

    public Converter(File input, File output) {
        this.input = input;
        this.output = output;
    }

    public void reader() {
        try (InputStream inputStream = new FileInputStream(input);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int br = bufferedReader.read();
                if (br == -1) break;
                sb.append((char)br);
            }
            text = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writer() {
        try (OutputStream outputStream = new FileOutputStream(output);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            bufferedWriter.write(text, 0 , text.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printer() {
        System.out.println(text);
    }
}
