package javase01.t06;

/**
 *@author Anastasia Rybakova
 */

public class Main {

    public static void main(String[] args) {

        Notepad notepad = new Notepad();

        notepad.addNote("Title0", "Text0");
        notepad.addNote("Title1", "Text1");
        notepad.addNote("Title2", "Text2");
        notepad.printNotes();

        notepad.deleteNote(1);
        notepad.printNotes();

        notepad.editNote(1, "Title 2.1", "Text 2.1");
        notepad.printNotes();
    }
}