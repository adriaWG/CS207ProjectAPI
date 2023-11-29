package interface_adapter.OpenNote_adapter;

import interface_adapter.EditNote_adapter.EditNoteState;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OpenNote_adapter.OpenNoteState;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.OpenNote_case.OpenNoteOutputBoundary;
import use_case.OpenNote_case.OpenNoteOutputData;

public class OpenNotePresenter implements OpenNoteOutputBoundary{
    private final OpenNoteViewModel openNoteViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private ViewManagerModel viewManagerModel;

    public OpenNotePresenter(ViewManagerModel viewManagerModel,
                            OpenNoteViewModel openNoteViewModel,EditNoteViewModel editNoteViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.openNoteViewModel = openNoteViewModel;
        this.editNoteViewModel = editNoteViewModel;
    }

    @Override
    public void prepareSuccessView(OpenNoteOutputData response) {

        EditNoteState editNoteState = editNoteViewModel.getState();
        editNoteState.setFilename(response.getNoteId());
        editNoteState.setCurrentNote(response.getNote());

        this.editNoteViewModel.setState(editNoteState);
        this.editNoteViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();


    }
    @Override
    public void prepareFailView(String error) {
        OpenNoteState openNoteState = openNoteViewModel.getState();
        openNoteState.setNoteIdError(error);
        openNoteViewModel.firePropertyChanged();

    }



}
