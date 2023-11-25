package interface_adapter.ClearNote_adapter;

import use_case.ClearNote_case.ClearNoteInputBoundary;
import use_case.ClearNote_case.ClearNoteInputData;
import use_case.ClearNote_case.ClearNoteInteractor;

import java.util.Set;

public class ClearNoteController {
    final ClearNoteInputBoundary clearUseCaseInteractor;
    public ClearNoteController(ClearNoteInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute() {
        ClearNoteInteractor.deleteAllNote();
    }
}
