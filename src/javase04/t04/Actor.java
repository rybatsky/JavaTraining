package javase04.t04;

import java.io.Serializable;

/**
 * Created by rybatsky
 */
public class Actor implements Serializable{

    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
