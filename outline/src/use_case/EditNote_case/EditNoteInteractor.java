package use_case.EditNote_case;

import entity.Note;
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

    @Override
    public void edit(EditNoteInputData editNoteInputData) {
        Note note = editNoteInputData.getNote();
        note.addContent(editNoteInputData.getScreenText());
        System.out.println(note.getContent());
        noteDataAccessObject.saveNote(note);

        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(note.getNoteName(), false);
        editNotePresenter.prepareSuccessView(editNoteOutputData);
    }
}