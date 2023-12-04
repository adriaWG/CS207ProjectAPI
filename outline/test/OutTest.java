import static org.junit.Assert.*;

import app.Main;
import interface_adapter.ClearNote_adapter.ClearNoteController;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import org.junit.Test;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import use_case.EditNote_case.EditNoteInputBoundary;
import use_case.OutNote_case.OutNoteInputBoundary;
import interface_adapter.OutNote_adapter.OutNoteController;
import interface_adapter.OutNote_adapter.OutNoteViewModel;
import use_case.OutNote_case.OutNoteOutputData;
import view.EditNoteView;

import javax.swing.*;

public class OutTest {
    @org.junit.Test
    public void testOutNote(){
        //creating the UI
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

    @Test
    public void testClearContent(){
        OutNoteInputBoundary outNoteInputBoundary = null;
        OutNoteController outNoteController = new OutNoteController(outNoteInputBoundary);
        outNoteController.execute("note1");
        OutNoteOutputData outNoteOutputData = new OutNoteOutputData("note1", "./users.csv", false);
        assertEquals(outNoteOutputData.getFilename(), "note1");
        assertEquals(outNoteOutputData.getFilepath(), "./users.csv");



    }
}
