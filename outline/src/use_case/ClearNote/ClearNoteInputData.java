package use_case.ClearNote;

public class ClearNoteInputData {
    private final ClearNoteUserDataAccessInterface dataAccess;

    public ClearNoteInputData(ClearNoteUserDataAccessInterface dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void deleteNotebook(String notebookId) {
        dataAccess.deleteNotebook(notebookId);
    }
}
