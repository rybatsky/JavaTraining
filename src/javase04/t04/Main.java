package javase04.t04;

import java.io.File;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Actor 1");
        Actor actor2 = new Actor("Actor 2");
        Actor actor3 = new Actor("Actor 3");
        Actor actor4 = new Actor("Actor 4");
        Actor actor5 = new Actor("Actor 5");

        Film film1 = new Film("Film 1", 2011);
        Film film2 = new Film("Film 2", 2012);
        Film film3 = new Film("Film 3", 2013);
        Film film4 = new Film("Film 4", 2014);
        Film film5 = new Film("Film 5", 2015);

        film1.addActor(actor1);
        film1.addActor(actor2);

        film2.addActor(actor4);
        film2.addActor(actor5);

        film3.addActor(actor1);

        film4.addActor(actor1);
        film4.addActor(actor2);
        film4.addActor(actor3);

        film5.addActor(actor3);

        FilmCollection collection = new FilmCollection("Collection");
        collection.addFilm(film1);
        collection.addFilm(film2);
        collection.addFilm(film3);
        collection.addFilm(film4);
        collection.addFilm(film5);

        System.out.println(collection);
        collection.filmDel(film4);
        System.out.println(collection);
        collection.filmography(actor1);

        File file = new File("src/javase04/t04/output.txt");
        FilmCollection.serialization(collection, file);
        FilmCollection fc = null;
        fc = FilmCollection.deserialization(file);
        System.out.println(fc);
    }
}
