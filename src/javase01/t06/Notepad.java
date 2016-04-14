package javase01.t06;

import java.util.ArrayList;
import java.util.List;

/**
 * Actions with notes.
 *
 * <p>Actions with notes: add note, delete note, edit note and print all notes.</p>
 *
 * {@link Note}
 * @author Anastasia Rybakova
 */

public class Notepad {

    private List<Note> notes = new ArrayList<>();
    int id = 0;

    /**
     * Add note.
     *
     * @param title
     * @param text
     */
    public void addNote (String title, String text) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setText(text);
        notes.add(note);
        id++;
    }

    /**
     * Delete note.
     *
     * @param id
     */
    public void deleteNote(int id) {
        notes.remove(id);
    }

    /**
     * Edit note.
     *
     * @param id
     * @param title
     * @param text
     */
    public void editNote (int id, String title, String text) {
        Note note;
        note = notes.get(id);
        note.setTitle(title);
        note.setText(text);
    }

    /**
     * Print all notes.
     */
    public void printNotes() {
        for (Note note: notes) {
            System.out.print(note.getId() + ". ");
            System.out.print(note.getTitle() + ": ");
            System.out.println(note.getText() + ".");
        }
        System.out.println();
    }
}
