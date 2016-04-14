package javase04.t04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rybatsky
 */
public class FilmCollection implements Serializable {

    private String title;
    private List<Film> films = new ArrayList<>();
    private List<Cast> casts = new ArrayList<>();

    public FilmCollection(String title) {
        this.title = title;
    }

    public void addFilm(Film film) {
        films.add(film);
        for (Actor a : film.actors) {
            Cast cast = new Cast(a, film);
            casts.add(cast);
        }
    }

    public void filmography(Actor actor) {
        StringBuilder sb = new StringBuilder();
        for (Cast cast : casts) {
            if (cast.getActor() == actor) sb.append(cast.getFilm() + ", ");
        }
        System.out.println("Actor: " + actor.getName() + "\nFilms:" + sb);
    }

    public void filmDel(Film film) {
        films.remove(films.indexOf(film));
        ListIterator<Cast> li = casts.listIterator();
        while (li.hasNext()) {
            if (li.next().getFilm() == film) li.remove();
        }
    }

    public static void serialization(FilmCollection collection, File output) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(output);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FilmCollection deserialization(File input) {
        try(FileInputStream fileInputStream = new FileInputStream(input);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (FilmCollection) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return title + "\nfilms: " + films + "\nactors: " + casts;
    }
}
