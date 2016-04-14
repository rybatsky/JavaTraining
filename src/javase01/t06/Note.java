package javase01.t06;

/**
 * Note in notepad.
 *
 * <p>Contains note id, title and text.</p>
 *
 * @author Anastasia Rybakova
 */

public class Note {

    private int id;
    private String title;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
