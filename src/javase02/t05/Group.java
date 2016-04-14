package javase02.t05;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by rybatsky
 */

public class Group {

    public enum Discipline {
        BIOLOGY, CHEMISTRY, HISTORY, GEOGRAPHY, MATHEMATICS, PHISICS
    }

    private Discipline discipline;
    private boolean isInteger;
    private HashMap<Student, Number> students;

    public Group(Discipline discipline, boolean isInteger) {
        this.discipline = discipline;
        this.isInteger = isInteger;
        students = new HashMap<>();
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Number getMark(Student student) {
        return students.get(student);
    }

    public void addStudent(Student student, Number mark) {
        students.put(student, mark);
    }

    public boolean enroll(Student student) {
        return students.containsKey(student);
    }

    public static void printMarks(ArrayList<Group> listGroup, Student student) {
        System.out.println(student);
        for (Group element:listGroup) {
            if (element.enroll(student)) {
                System.out.println(element.getDiscipline() + " -- " + element.getMark(student));
            }
        }
    }
}
