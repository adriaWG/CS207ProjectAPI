package use_case.ClearNote_case;

public class ClearNoteInteractor implements ClearNoteInputBoundary {
    private final ClearNoteOutputBoundary clearNotePresenter;
    private static ClearNoteUserDataAccessInterface userDataAccessObject;


    public ClearNoteInteractor(ClearNoteOutputBoundary clearNotePresenter,
                               ClearNoteUserDataAccessInterface userDataAccessObject) {
        this.clearNotePresenter = clearNotePresenter;
        ClearNoteInteractor.userDataAccessObject = userDataAccessObject;
    }


    public static void deleteAllNote() {
        userDataAccessObject.deleteAllNote();
    }

    @Override
    public void deleteSingleNote(String notebookId) {
        userDataAccessObject.deleteSingleNote(notebookId);
    }
}
