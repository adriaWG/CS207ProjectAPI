package app;

import entity.CommonNoteFactory;
import entity.NoteFactory;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNotePresenter;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.ViewManagerModel;
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
            EditNoteUserDataAccessInterface noteDataAccessObject) {
        try {
            EditNoteController editNoteController = createEditNoteUseCase(viewManagerModel, editNoteViewModel, noteDataAccessObject);
            return new EditNoteView(editNoteViewModel, editNoteController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not edit file.");
        }

        return null;
    }

    private static EditNoteController createEditNoteUseCase(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            EditNoteUserDataAccessInterface noteDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        EditNoteOutputBoundary editNoteOutputBoundary = new EditNotePresenter(viewManagerModel, editNoteViewModel);

        NoteFactory noteFactory = new CommonNoteFactory();

        EditNoteInputBoundary editNoteInteractor = new EditNoteInteractor(
                noteDataAccessObject, editNoteOutputBoundary);

        return new EditNoteController(editNoteInteractor);
    }

    }



