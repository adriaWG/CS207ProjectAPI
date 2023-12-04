package data_access;

import entity.CommonNoteFactory;
import entity.Note;
import entity.NoteFactory;
import interface_adapter.ClearNote_adapter.ClearNoteState;
import org.junit.Test;

import static org.junit.Assert.*;
import use_case.OpenNote_case.OpenNoteUserDataAccessInterface;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;

import java.io.IOException;

public class FileUserDataAccessObjectTest {

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
    public void saveToTxt() {
        addNote();
        NoteFactory noteFactory = new CommonNoteFactory();
        Note note = noteFactory.fetchText("note1", "./users.csv/note1");
        ClearNoteState currentState = new ClearNoteState();
    }

    @Test
    public void saveNote() {

    }

    @Test
    public void saveFileAccounts() {
    }

    @Test
    public void existsByName() {
    }

    @Test
    public void getPath() {
    }

    @Test
    public void getAllFileNames() {
    }

    @Test
    public void deleteNoteFile() {
    }

    @Test
    public void deleteAllNote() {
    }

    @Test
    public void deleteSingleNote() {
    }
}