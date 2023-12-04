import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

import app.Main;
import data_access.FileUserDataAccessObject;
import entity.CommonNoteFactory;
import entity.Note;
import entity.NoteFactory;
import interface_adapter.ClearNote_adapter.ClearNotePresenter;
import interface_adapter.ClearNote_adapter.ClearNoteState;
import org.junit.Test;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.ClearNote_adapter.ClearNoteController;
import use_case.ClearNote_case.ClearNoteInteractor;
import use_case.ClearNote_case.ClearNoteOutputBoundary;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;

import javax.swing.*;
import java.io.IOException;

public class ClearTest {

    // ensures there is a note saved
    public void addNote() {
        NoteFactory noteFactory = new CommonNoteFactory();
        FileUserDataAccessObject fileUserDataAccessObject;
        try {
            fileUserDataAccessObject = new FileUserDataAccessObject("./users.csv", noteFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileUserDataAccessObject.saveNote(noteFactory.create("note1", "./users.csv/note1", ""));
    }

    @Test
    public void testClear() {
        addNote();
        NoteFactory noteFactory = new CommonNoteFactory();
        Note note = noteFactory.fetchText("note1", "./users.csv");

        // TODO note.clear();
        assertEquals(note.getContent(), "");
        assert(note.getContent().isEmpty());

        ClearNoteInputBoundary clearNoteInputBoundary = null;
        ClearNoteInteractor clearNoteInteractor = null;
        ClearNoteController clearNoteController = new ClearNoteController(clearNoteInputBoundary);
        clearNoteController.execute("note1");




    }




    @org.junit.Test
    public void testClearNote(){
        addNote();
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Clear"));

        button.doClick();

    }

    public JButton getButton() {
        return null;
    }

}
