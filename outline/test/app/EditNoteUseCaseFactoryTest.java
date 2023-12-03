package app;

import data_access.FileUserDataAccessObject;
import entity.CommonNoteFactory;
import entity.NoteFactory;
import org.junit.Test;

import javax.swing.*;

import java.io.IOException;

import static org.junit.Assert.*;


public class EditNoteUseCaseFactoryTest {

    @Test
    public void create() {
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
    public void createEditNoteUseCase() {
    }

    @Test
    public void testClearNote() {
        create();
        Main.main(null);
        JButton button = getButton();
        assert (button.getText().equals("Clear"));

        button.doClick();
    }
    public JButton getButton() {
        return null;
    }
}