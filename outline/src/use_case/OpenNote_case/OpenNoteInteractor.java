package use_case.OpenNote_case;

import use_case.OpenNote_case.OpenNoteOutputBoundary;
import use_case.OpenNote_case.OpenNoteUserDataAccessInterface;
import use_case.OutNote_case.OutNoteInputData;
import use_case.OutNote_case.OutNoteOutputBoundary;
import use_case.OutNote_case.OutNoteUserDataAccessInterface;

public class OpenNoteInteractor implements OpenNoteInputBoundary {
    final OpenNoteUserDataAccessInterface userDataAccessObject;
    final OpenNoteOutputBoundary openNotePresenter;

    public OpenNoteInteractor(OpenNoteUserDataAccessInterface userDataAccessInterface,
                              OpenNoteOutputBoundary openNoteOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.openNotePresenter = openNoteOutputBoundary;
    }

    @Override //some kind of execute that deal with outNote InputData
    public void createNote(OpenNoteInputData openNoteInputData) {
        String title = openNoteInputData.getTitle();
        String content = openNoteInputData.getContent();
        //TODO: others
    }



}
