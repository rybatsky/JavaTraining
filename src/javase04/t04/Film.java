package javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rybatsky
 */

public class Film implements Serializable {

    private String title;
    private int year;
    public List<Actor> actors = new ArrayList<>();

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    @Override
    public String toString() {
        return "\'" + title + "\' " + year;
    }
}
