package app;

import entity.CommonNoteFactory;
import entity.NoteFactory;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OpenNote_adapter.OpenNoteController;
import interface_adapter.OpenNote_adapter.OpenNotePresenter;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.EditNote_case.EditNoteUserDataAccessInterface;
import use_case.OpenNote_case.OpenNoteInputBoundary;
import use_case.OpenNote_case.OpenNoteInteractor;
import use_case.OpenNote_case.OpenNoteOutputBoundary;
import use_case.OpenNote_case.OpenNoteUserDataAccessInterface;
import view.OpenNoteView;

import javax.swing.*;
import java.io.IOException;

import static app.EditNoteUseCaseFactory.createEditNoteUseCase;

public class OpenNoteUseCaseFactory {
    /** Prevent instantiation. */
    private OpenNoteUseCaseFactory() {}

    public static OpenNoteView create(
            ViewManagerModel viewManagerModel,
            OpenNoteViewModel openNoteViewModel,
            EditNoteViewModel editNoteViewModel,
            OpenNoteUserDataAccessInterface openNoteUserDataAccessObject,
            EditNoteUserDataAccessInterface editNoteDataAccessObject){
        try{
            OpenNoteController openNoteController = createOpenNoteUseCase(viewManagerModel, openNoteViewModel, editNoteViewModel,openNoteUserDataAccessObject);
            EditNoteController editNoteController = createEditNoteUseCase(viewManagerModel,editNoteViewModel, editNoteDataAccessObject);
            return new OpenNoteView(openNoteViewModel, openNoteController,editNoteViewModel,editNoteController);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not open file.");
        }
        return null;
    }

    private static OpenNoteController createOpenNoteUseCase(
            ViewManagerModel viewManagerModel,
            OpenNoteViewModel openNoteViewModel,
            EditNoteViewModel editNoteViewModel,
            OpenNoteUserDataAccessInterface openNoteUserDataAccessObject) throws IOException{

        OpenNoteOutputBoundary openNoteOutputBoundary = new OpenNotePresenter(viewManagerModel, openNoteViewModel,editNoteViewModel);
        NoteFactory userFactory = new CommonNoteFactory();
        OpenNoteInputBoundary openNoteInteractor = new OpenNoteInteractor(openNoteUserDataAccessObject, openNoteOutputBoundary, userFactory);

        return new OpenNoteController(openNoteInteractor);

    }

}
