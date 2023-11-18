package use_case.OutNote_case;


public interface OutNoteOutputBoundary {
    //TODO: out 3. define OutNoteOutputData
    void prepareSuccessView(OutNoteOutputData outputData);

    void prepareFailView(String error);
}
