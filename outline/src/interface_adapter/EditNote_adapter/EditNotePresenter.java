package interface_adapter.EditNote_adapter;

import interface_adapter.ViewManagerModel;
import use_case.EditNote_case.EditNoteOutputBoundary;
import use_case.EditNote_case.EditNoteOutputData;

public class EditNotePresenter implements EditNoteOutputBoundary {
    private final EditNoteViewModel editNoteViewModel;
    private ViewManagerModel viewManagerModel;

    public EditNotePresenter(ViewManagerModel viewManagerModel,
                             EditNoteViewModel editNoteViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.editNoteViewModel = editNoteViewModel;
    }

    @Override
    public void prepareSuccessView(EditNoteOutputData response) {

        EditNoteState editNoteState = editNoteViewModel.getState();
        editNoteState.setFilename(response.getFilename());
        this.editNoteViewModel.setState(editNoteState);
        this.editNoteViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        EditNoteState editNoteState = editNoteViewModel.getState();
        editNoteState.setFilenameError(error);
        editNoteViewModel.firePropertyChanged();
    }

}

