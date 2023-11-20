package use_case.EditNote_case;

import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.ViewManagerModel;

public class EditNoteInteractor implements EditNoteInputBoundary {

    final EditNoteUserDataAccessInterface noteDataAccessObject;
    final EditNoteOutputBoundary editNotePresenter;

    public EditNoteInteractor(EditNoteUserDataAccessInterface noteDataAccessInterface,
                              EditNoteOutputBoundary editNoteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessInterface;
        this.editNotePresenter = editNoteOutputBoundary;
    }

    @Override //some kind of execute that deal with editNote InputData
    public void edit(EditNoteInputData editNoteInputData) {
        String filename = editNoteInputData.getFilename();
        //TODO: edit 2. add API for editNote
    }
}