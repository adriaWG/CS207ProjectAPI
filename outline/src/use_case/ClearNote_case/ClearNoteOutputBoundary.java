package use_case.ClearNote_case;

public interface ClearNoteOutputBoundary {
    void onSuccess();
    void onError(String message);
}
