package use_case.EditNote_case;

public class EditNoteInteractor implements EditNoteInputBoundary {

    final EditNoteUserDataAccessInterface userDataAccessObject;
    final EditNoteInputBoundary editNotePresenter;

    public EditNoteInteractor(EditNoteUserDataAccessInterface userDataAccessInterface,
                              EditNoteOutputBoundary editNoteOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        //and others that might be in edit note
    }

    @Override //some kind of execute that deal with editNote InputData
    public void execute(EditNoteInputData editNoteInputData) {

    }
}