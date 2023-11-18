package use_case.OutNote_case;


public interface OutNoteOutputBoundary {
    //TODO: out 3. define OutNoteOutputData
    void prepareSuccessView(OutNoteOutputData xxx);

    void prepareFailView(String error);
}
