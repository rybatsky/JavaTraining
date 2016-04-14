package javase02.t05;

import java.util.ArrayList;

import static javase02.t05.Group.printMarks;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("First Name 1", "Last Name 1");
        Student student2 = new Student("First Name 2", "Last Name 2");
        Student student3 = new Student("First Name 3", "Last Name 3");
        Student student4 = new Student("First Name 4", "Last Name 4");

        ArrayList<Group> listGroup = new ArrayList<>();

        Group group1 = new Group(Group.Discipline.BIOLOGY, true);
        listGroup.add(group1);
        Group group2 = new Group(Group.Discipline.CHEMISTRY, false);
        listGroup.add(group2);
        Group group3 = new Group(Group.Discipline.GEOGRAPHY, true);
        listGroup.add(group3);
        Group group4 = new Group(Group.Discipline.HISTORY, true);
        listGroup.add(group4);
        Group group5 = new Group(Group.Discipline.MATHEMATICS, false);
        listGroup.add(group5);
        Group group6 = new Group(Group.Discipline.PHISICS, false);
        listGroup.add(group6);

        group1.addStudent(student1, 3);
        group1.addStudent(student2, 4);
        group1.addStudent(student3, 5);

        group2.addStudent(student2, 4.9);
        group2.addStudent(student3, 3.8);
        group2.addStudent(student4, 2.7);

        group3.addStudent(student3, 5);
        group3.addStudent(student4, 5);
        group3.addStudent(student1, 5);

        group4.addStudent(student4, 5);
        group4.addStudent(student1, 4);
        group4.addStudent(student2, 3);

        group5.addStudent(student1, 3.3);
        group5.addStudent(student2, 3.2);
        group5.addStudent(student3, 3.1);
        group5.addStudent(student4, 3.0);

        group6.addStudent(student1, 3.0);
        group6.addStudent(student2, 2.9);
        group6.addStudent(student3, 2.8);
        group6.addStudent(student4, 2.7);

        printMarks(listGroup, student1);
        printMarks(listGroup, student4);
    }
}
