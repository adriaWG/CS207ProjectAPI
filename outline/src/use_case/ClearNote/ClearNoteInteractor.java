package use_case.ClearNote;

public class ClearNoteInteractor {
    private final ClearNoteInputBoundary inputBoundary;

    public ClearNoteInteractor(ClearNoteInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @Override
    public void deleteNotebook(String notebookId, ClearNoteOutputBoundary outputBoundary) {
        try {
            inputBoundary.deleteNotebook(notebookId);
            outputBoundary.onSuccess();
        } catch (Exception e) {
            outputBoundary.onError(e.getMessage());
        }
    }
}
