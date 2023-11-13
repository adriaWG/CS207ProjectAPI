package use_case.EditNote;

public interface EditNoteOutputBoundary {
    void prepareSuccessView(EditNoteOutputData xxx);

    void prepareFailView(String error);
}


