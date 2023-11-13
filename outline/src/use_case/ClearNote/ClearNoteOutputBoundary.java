package use_case.ClearNote;

public interface ClearNoteOutputBoundary {
    void onSuccess();
    void onError(String message);
}
