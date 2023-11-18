package use_case.EditNote_case;

public class EditNoteInteractor implements EditNoteInputBoundary {

    final EditNoteUserDataAccessInterface userDataAccessObject;
    final EditNoteOutputBoundary editNotePresenter;

    public EditNoteInteractor(EditNoteUserDataAccessInterface userDataAccessInterface,
                              EditNoteOutputBoundary editNoteOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.editNotePresenter = editNoteOutputBoundary;
    }

    @Override //some kind of execute that deal with editNote InputData
    public void edit(EditNoteInputData editNoteInputData) {
        String filename = editNoteInputData.getFilename();
        //TODO: edit 2. add API for editNote
    }
}