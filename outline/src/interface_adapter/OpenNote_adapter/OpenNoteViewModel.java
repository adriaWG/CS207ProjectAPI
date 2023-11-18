package interface_adapter.OpenNote_adapter;

import app.OpenNoteUseCaseFactory;
import use_case.OpenNote_case.OpenNoteInputData;

public class OpenNoteViewModel {
    private final OpenNoteUseCaseFactory useCase;
    private final view.OpenNoteView view;

    public OpenNoteViewModel(OpenNoteUseCaseFactory useCase, view.OpenNoteView view){
        this.useCase =useCase;
        this.view = view;
    }

    public void createNote(){
        OpenNoteInputData inputData = view.collectNoteInput();

        useCase.createNote(inputData);
    }
}
