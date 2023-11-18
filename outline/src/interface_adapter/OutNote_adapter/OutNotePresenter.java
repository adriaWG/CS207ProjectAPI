package interface_adapter.OutNote_adapter;

import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.OutNote_case.OutNoteOutputBoundary;
import use_case.OutNote_case.OutNoteOutputData;

public class OutNotePresenter implements OutNoteOutputBoundary {
    private final OutNoteViewModel outNoteViewModel;
    //private final EditNoteViewModel editNoteViewModel;
    private ViewManagerModel viewManagerModel;

    public OutNotePresenter(ViewManagerModel viewManagerModel,
                          OutNoteViewModel outNoteViewModel,
                          EditNoteViewModel editNoteViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.outNoteViewModel = outNoteViewModel;
        //this.edtiNoteViewModel = editNoteViewModel;
    }

    @Override
    public void prepareSuccessView(OutNoteOutputData response) {
        OutNoteState outNoteState = outNoteViewModel.getState();
        outNoteState.setFilename(response.getFilename());
        outNoteState.setFilepath(response.getFilepath());
        this.outNoteViewModel.setState(outNoteState);
        this.outNoteViewModel.firePropertyChanged();

    }
    @Override
    public void prepareFailView(String error) {
    }
}
