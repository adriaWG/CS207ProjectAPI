package interface_adapter.OpenNote_adapter;

import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OpenNote_adapter.OpenNoteState;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.OpenNote_case.OpenNoteOutputBoundary;
import use_case.OpenNote_case.OpenNoteOutputData;

public class OpenNotePresenter implements OpenNoteOutputBoundary{
    private final OpenNoteViewModel openNoteViewModel;
    //private final EditNoteViewModel editNoteViewModel;
    private ViewManagerModel viewManagerModel;

    public OpenNotePresenter(ViewManagerModel viewManagerModel,
                            OpenNoteViewModel openNoteViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.openNoteViewModel = openNoteViewModel;
        //this.editNoteViewModel = editNoteViewModel;
    }

    @Override
    public void prepareSuccessView(OpenNoteOutputData response) {
        OpenNoteState openNoteState = openNoteViewModel.getState();
        openNoteState.setNoteId(response.getNoteId());
        openNoteState.setMessage(response.getMessage());
        this.openNoteViewModel.setState(openNoteState);
        this.openNoteViewModel.firePropertyChanged();

    }
    @Override
    public void prepareFailView(String error) {
    }
}
