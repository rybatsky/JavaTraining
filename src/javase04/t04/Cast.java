package javase04.t04;

import java.io.Serializable;

/**
 * Created by rybatsky
 */
public class Cast implements Serializable{

    private Actor actor;
    private Film film;

    public Cast(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public Film getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return actor + " (" + film + ")";
    }
}
