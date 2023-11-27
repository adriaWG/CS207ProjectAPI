import static org.junit.Assert.*;

import app.Main;
import data_access.FileUserDataAccessObject;
import entity.CommonNoteFactory;
import entity.NoteFactory;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.ClearNote_adapter.ClearNoteController;

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
