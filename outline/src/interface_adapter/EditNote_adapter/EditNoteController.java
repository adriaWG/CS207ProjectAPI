package interface_adapter.EditNote_adapter;

import use_case.EditNote_case.EditNoteInputBoundary;
import use_case.EditNote_case.EditNoteInputData;

public class EditNoteController {
    final EditNoteInputBoundary editUseCaseInteractor;
    public EditNoteController(EditNoteInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;
    }

    public void execute(String filename) {
        EditNoteInputData editNoteInputData = new EditNoteInputData(
                filename);

        editUseCaseInteractor.edit(editNoteInputData);
    }

}


