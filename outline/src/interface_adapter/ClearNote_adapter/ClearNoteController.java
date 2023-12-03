package interface_adapter.ClearNote_adapter;

import use_case.ClearNote_case.ClearNoteInputBoundary;
import use_case.ClearNote_case.ClearNoteInputData;
import use_case.ClearNote_case.ClearNoteInteractor;
import use_case.EditNote_case.EditNoteInputData;

import java.util.Set;

public class ClearNoteController {
    final ClearNoteInputBoundary clearUseCaseInteractor;
    public ClearNoteController(ClearNoteInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute(String filename) {
        ClearNoteInputData clearNoteInputData = new ClearNoteInputData(filename);
        String noteName = clearNoteInputData.getFilename();
        clearUseCaseInteractor.deleteSingleNote(noteName);
    }
}
