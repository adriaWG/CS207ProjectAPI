package app;

import entity.CommonNoteFactory;
import interface_adapter.ClearNote_adapter.ClearNoteController;
import interface_adapter.ClearNote_adapter.ClearNotePresenter;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNotePresenter;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OutNote_adapter.OutNoteController;
import interface_adapter.OutNote_adapter.OutNotePresenter;
import interface_adapter.OutNote_adapter.OutNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import use_case.ClearNote_case.ClearNoteInteractor;
import use_case.ClearNote_case.ClearNoteOutputBoundary;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;
import use_case.EditNote_case.EditNoteInputBoundary;
import use_case.EditNote_case.EditNoteInteractor;
import use_case.EditNote_case.EditNoteOutputBoundary;
import use_case.EditNote_case.EditNoteUserDataAccessInterface;
import use_case.OutNote_case.OutNoteInputBoundary;
import use_case.OutNote_case.OutNoteInteractor;
import use_case.OutNote_case.OutNoteOutputBoundary;
import use_case.OutNote_case.OutNoteUserDataAccessInterface;
import view.EditNoteView;

import javax.swing.*;
import java.io.IOException;

public class EditNoteUseCaseFactory {

    /** Prevent instantiation. */
    private EditNoteUseCaseFactory() {}
    public static EditNoteView create(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel, EditNoteUserDataAccessInterface editNoteDataAccessObject,
            //OutNoteController outNoteController,
            OutNoteViewModel outNoteViewModel, OutNoteUserDataAccessInterface outNoteDataAccessObject,
            ClearNoteViewModel clearNoteViewModel,
            ClearNoteUserDataAccessInterface clearNoteDataAccessObject) {
        try {
            EditNoteController editNoteController = createEditNoteUseCase(viewManagerModel, editNoteViewModel, editNoteDataAccessObject);
            ClearNoteController clearNoteController= createClearNoteUseCase(viewManagerModel, clearNoteViewModel,clearNoteDataAccessObject);
            OutNoteController outNoteController=createOutNoteUseCase(viewManagerModel, outNoteViewModel,outNoteDataAccessObject);
            return new EditNoteView(editNoteViewModel, editNoteController,outNoteController,outNoteViewModel,clearNoteController,clearNoteViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not edit file.");
        }

        return null;
    }

    public static EditNoteController createEditNoteUseCase(
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
            ClearNoteUserDataAccessInterface clearNoteDataAccessObject) throws IOException {

        ClearNoteOutputBoundary clearNoteOutputBoundary = new ClearNotePresenter(viewManagerModel, clearNoteViewModel);
        ClearNoteInputBoundary clearNoteInteractor = new ClearNoteInteractor(clearNoteOutputBoundary,clearNoteDataAccessObject );
        return new ClearNoteController(clearNoteInteractor);
    }

    private static OutNoteController createOutNoteUseCase(
            ViewManagerModel viewManagerModel,
            OutNoteViewModel outNoteViewModel,
            OutNoteUserDataAccessInterface outNoteDataAccessObject) throws IOException {

        OutNoteOutputBoundary outNoteOutputBoundary = new OutNotePresenter(viewManagerModel, outNoteViewModel);
        OutNoteInputBoundary outNoteInteractor = new OutNoteInteractor(outNoteDataAccessObject,outNoteOutputBoundary );
        return new OutNoteController(outNoteInteractor);
    }
}




