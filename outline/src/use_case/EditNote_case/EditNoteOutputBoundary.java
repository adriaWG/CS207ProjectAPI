package use_case.EditNote_case;

public interface EditNoteOutputBoundary {
    //TODO: edit 3. define EditNoteOutputData
    void prepareSuccessView(EditNoteOutputData xxx);

    void prepareFailView(String error);
}


