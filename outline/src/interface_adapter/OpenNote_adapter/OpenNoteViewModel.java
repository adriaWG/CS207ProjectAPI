package interface_adapter.OpenNote_adapter;

import app.OpenNoteUseCaseFactory;
import use_case.OpenNote_case.OpenNoteInputData;

public class OpenNoteViewModel {
    private final OpenNoteUseCaseFactory useCase;
    private final OpenNotePresenter presenter;

    public OpenNoteViewModel(OpenNoteUseCaseFactory useCase, OpenNotePresenter presenter){
        this.useCase =useCase;
        this.presenter = presenter;
    }

    public void createNote(){
        OpenNoteInputData inputData = presenter.collectNoteInput();

        useCase.createNote(inputData);
    }
}
