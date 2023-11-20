package use_case.ClearNote_case;

import java.util.Set;

public class ClearNoteInteractor {
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
}
