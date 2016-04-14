package javase02.t06;

/**
 * Created by rybatsky
 */

public class NuclearSubmarine {

    private String name;
    private String hullType;
    private int diveDepth;
    private Engine engine;

    public NuclearSubmarine(String name, String hullType, int diveDepth, int speed) {
        this.name = name;
        this.hullType = hullType;
        this.diveDepth = diveDepth;
        engine = new Engine(speed);
    }

    class Engine {
        private int speed;

        public Engine(int speed) {
            this.speed = speed;
        }
    }

    public void launch() {
        System.out.println(name + "  with " + engine.speed + "km/h speed, " + diveDepth + "m dive depth and " + hullType + " was successfully launched.");
    }
}
