package app;

import entity.CommonNoteFactory;
import interface_adapter.ClearNote_adapter.ClearNoteController;
import interface_adapter.ClearNote_adapter.ClearNotePresenter;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNotePresenter;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import use_case.ClearNote_case.ClearNoteInteractor;
import use_case.ClearNote_case.ClearNoteOutputBoundary;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;
import use_case.EditNote_case.EditNoteInputBoundary;
import use_case.EditNote_case.EditNoteInteractor;
import use_case.EditNote_case.EditNoteOutputBoundary;
import use_case.EditNote_case.EditNoteUserDataAccessInterface;
import view.EditNoteView;

import javax.swing.*;
import java.io.IOException;

public class EditNoteUseCaseFactory {

    /** Prevent instantiation. */
    private EditNoteUseCaseFactory() {}
    public static EditNoteView create(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            EditNoteUserDataAccessInterface editNoteDataAccessObject) {
        try {
            EditNoteController editNoteController = createEditNoteUseCase(viewManagerModel, editNoteViewModel, editNoteDataAccessObject);
            return new EditNoteView(editNoteViewModel, editNoteController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not edit file.");
        }

        return null;
    }

    private static EditNoteController createEditNoteUseCase(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            EditNoteUserDataAccessInterface editNoteDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        EditNoteOutputBoundary editNoteOutputBoundary = new EditNotePresenter(viewManagerModel, editNoteViewModel);

        CommonNoteFactory userFactory = new CommonNoteFactory();

        EditNoteInputBoundary editNoteInteractor = new EditNoteInteractor(editNoteDataAccessObject, editNoteOutputBoundary);

        return new EditNoteController(editNoteInteractor);
    }

    private static ClearNoteController createClearNoteUseCase(
            ViewManagerModel viewManagerModel,
            ClearNoteViewModel clearNoteViewModel,
            ClearNoteUserDataAccessInterface clearNoteUserDataAccessInterface) throws IOException {

        ClearNoteOutputBoundary clearNoteOutputBoundary = new ClearNotePresenter(viewManagerModel, clearNoteViewModel);
        ClearNoteInputBoundary clearNoteInteractor = new ClearNoteInteractor(clearNoteOutputBoundary, clearNoteUserDataAccessInterface);
        return new ClearNoteController(clearNoteInteractor);
    }
}



