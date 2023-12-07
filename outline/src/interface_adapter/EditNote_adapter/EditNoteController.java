package interface_adapter.EditNote_adapter;

import entity.Note;
import use_case.EditNote_case.EditNoteInputBoundary;
import use_case.EditNote_case.EditNoteInputData;

public class EditNoteController {
    final EditNoteInputBoundary editUseCaseInteractor;
    public EditNoteController(EditNoteInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;
    }
    // editNote calls method edit in editUseCaseInteractor by this method
    public void editNote(String filename, Note note, String screenText) {
        EditNoteInputData editNoteInputData = new EditNoteInputData(filename,note,screenText);

        editUseCaseInteractor.edit(editNoteInputData);
    }

}


