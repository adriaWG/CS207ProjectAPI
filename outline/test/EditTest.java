import static org.junit.Assert.*;

import app.Main;
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
    public void testMainRuns() {Main.main(new String[]{});}
}
