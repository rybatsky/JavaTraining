package javase04.t04;

/**
 * Created by rybatsky
 */
public class Filmography {

    private Actor actor;
    private Film film;

    public Filmography(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public Film getFilm() {
        return film;
    }
}
