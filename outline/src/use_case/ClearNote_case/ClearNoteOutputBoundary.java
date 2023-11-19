package use_case.ClearNote_case;

public interface ClearNoteOutputBoundary {
    void prepareSuccessView(ClearNoteOutputData clearNoteOutputData);
    void prepareFailView(String error);
}
