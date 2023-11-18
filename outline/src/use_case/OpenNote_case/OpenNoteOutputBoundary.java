package use_case.OpenNote_case;

public interface OpenNoteOutputBoundary {
    void prepareSuccessView(OpenNoteOutputData outputData);

    void prepareFailView(String error);
}
