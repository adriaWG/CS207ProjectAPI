package use_case.OpenNote_case;

public interface OpenNoteOutputBoundary {
    void presentSuccessView(OpenNoteOutputData outputData);

    void prepareFailView(String error);
}
