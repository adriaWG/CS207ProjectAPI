package interface_adapter.ClearNote_adapter;

import interface_adapter.ViewManagerModel;
import use_case.ClearNote_case.ClearNoteOutputBoundary;
import use_case.ClearNote_case.ClearNoteOutputData;
import use_case.EditNote_case.EditNoteOutputData;
//implement prepare success/fail view for ClearNoteOutputBoundary
public class ClearNotePresenter implements ClearNoteOutputBoundary {
    private final ClearNoteViewModel clearNoteViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearNotePresenter (ViewManagerModel viewManagerModel,
                             ClearNoteViewModel clearNoteViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearNoteViewModel = clearNoteViewModel;
    }

    @Override
    public void prepareSuccessView(ClearNoteOutputData clearNoteOutputData) {
        ClearNoteState clearNoteState = clearNoteViewModel.getState();
        clearNoteState.setFilename(clearNoteOutputData.getFilename());
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
