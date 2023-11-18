package use_case.EditNote_case;

public interface EditNoteOutputBoundary {
    void prepareSuccessView(EditNoteOutputData xxx);

    void prepareFailView(String error);
}


