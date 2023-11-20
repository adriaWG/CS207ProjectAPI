package interface_adapter.ClearNote_adapter;

import interface_adapter.ViewManagerModel;
import use_case.EditNote_case.EditNoteOutputData;

public class ClearNotePresenter {
    private final ClearNoteViewModel clearNoteViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearNotePresenter(ViewManagerModel viewManagerModel,
                             ClearNoteViewModel clearNoteViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearNoteViewModel = clearNoteViewModel;
    }

    public void prepareSuccessView(EditNoteOutputData response) {

        ClearNoteState clearNoteState = clearNoteViewModel.getState();
        clearNoteState.setFilename(response.getFilename());
        this.clearNoteViewModel.setState(clearNoteState);
        this.clearNoteViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(clearNoteViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        ClearNoteState clearNoteState = clearNoteViewModel.getState();
        clearNoteState.setFilenameError(error);
        clearNoteViewModel.firePropertyChanged();
    }
}
