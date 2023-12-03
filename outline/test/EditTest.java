import static org.junit.Assert.*;

import app.Main;
import data_access.FileUserDataAccessObject;
import entity.CommonNoteFactory;
import entity.Note;
import entity.NoteFactory;
import interface_adapter.ClearNote_adapter.ClearNoteController;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.OutNote_adapter.OutNoteController;
import interface_adapter.OutNote_adapter.OutNoteViewModel;
import org.junit.Test;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import use_case.EditNote_case.EditNoteInputBoundary;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import use_case.OutNote_case.OutNoteInputBoundary;
import view.EditNoteView;


import javax.swing.*;
import java.io.IOException;

public class EditTest {
    @org.junit.Test
    public void testEditNote(){
        // creating the UI:
        EditNoteInputBoundary editNoteInputBoundary = null;
        EditNoteController controller = new EditNoteController(editNoteInputBoundary);
        EditNoteViewModel viewModel = new EditNoteViewModel();
        OutNoteViewModel outViewModel = new OutNoteViewModel();
        OutNoteInputBoundary outNoteInputBoundary = null;
        OutNoteController outNoteController = new OutNoteController(outNoteInputBoundary);
        ClearNoteInputBoundary clearNoteInputBoundary = null;
        ClearNoteController clearNoteController = new ClearNoteController(clearNoteInputBoundary);
        ClearNoteViewModel clearNoteViewModel = new ClearNoteViewModel();


        JPanel editView = new EditNoteView(viewModel, controller, outNoteController,
                outViewModel, clearNoteController, clearNoteViewModel);
        JFrame jf = new JFrame();
        jf.setContentPane(editView);
        jf.pack();
        jf.setVisible(true);

        
    }

    @Test
    public void testMainRuns() {
        Main.main(new String[]{});
    }

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
    public void testEditContent() {
        NoteFactory noteFactory = new CommonNoteFactory();
        addNote();

        // test content prior to any changes
        assertEquals(noteFactory.fetchText("note1", "./users.csv").getContent(), "");

        // add text into note1
        Note note = noteFactory.fetchText("note1", "./users.csv");
        noteFactory.addText(note, "additional text");

        // test content after changes
        assertNotEquals(noteFactory.fetchText("note1", "./users.csv").getContent(), "");
        assertEquals(noteFactory.fetchText("note1", "./users.csv").getContent(), "additional text");


    }

}
