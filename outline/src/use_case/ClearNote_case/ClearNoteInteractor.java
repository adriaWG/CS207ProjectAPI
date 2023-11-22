package use_case.ClearNote_case;

import java.util.Set;

public class ClearNoteInteractor implements ClearNoteInputBoundary {
    private final ClearNoteOutputBoundary clearNotePresenter;
    private static ClearNoteUserDataAccessInterface userDataAccessObject;


    public ClearNoteInteractor(ClearNoteOutputBoundary clearNotePresenter,
                               ClearNoteUserDataAccessInterface userDataAccessObject) {
        this.clearNotePresenter = clearNotePresenter;
        ClearNoteInteractor.userDataAccessObject = userDataAccessObject;
    }

    public static void execute() {
        userDataAccessObject.deleteNotebook();
    }

    @Override
    public void deleteNotebook(String notebookId) {

    }
}
