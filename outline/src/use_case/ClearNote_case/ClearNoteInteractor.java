package use_case.ClearNote_case;

public class ClearNoteInteractor {
    private final ClearNoteOutputBoundary clearNotePresenter;
    private final ClearNoteUserDataAccessInterface userDataAccessObject;


    public ClearNoteInteractor(ClearNoteOutputBoundary clearNotePresenter,
                               ClearNoteUserDataAccessInterface userDataAccessObject) {
        this.clearNotePresenter = clearNotePresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    public void clear(ClearNoteInputData clearNoteInputData){
        String filename = clearNoteInputData.getFilename();
        // TODO: to implement
    }
}
