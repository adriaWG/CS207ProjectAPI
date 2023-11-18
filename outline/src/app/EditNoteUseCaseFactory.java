package app;

import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.ViewManagerModel;
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

    private static EditController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            EditNoteUserDataAccessInterface noteDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        EditNoteOutputBoundary editNoteOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }

    }



