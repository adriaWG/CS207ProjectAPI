package app;

import entity.CommonNoteFactory;
import entity.NoteFactory;
import interface_adapter.OpenNote_adapter.OpenNoteController;
import interface_adapter.OpenNote_adapter.OpenNotePresenter;
import interface_adapter.OpenNote_adapter.OpenNoteState;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;
import interface_adapter.ViewManagerModel;
import use_case.OpenNote_case.OpenNoteInputBoundary;
import use_case.OpenNote_case.OpenNoteInteractor;
import use_case.OpenNote_case.OpenNoteOutputBoundary;
import use_case.OpenNote_case.OpenNoteUserDataAccessInterface;
import view.OpenNoteView;

import javax.swing.*;
import java.io.IOException;

import static java.lang.System.*;

public class OpenNoteUseCaseFactory {
    /** Prevent instantiation. */
    private OpenNoteUseCaseFactory() {}

    public static OpenNoteView create(
            ViewManagerModel viewManagerModel,
            OpenNoteViewModel openNoteViewModel,
            OpenNoteUserDataAccessInterface openNoteUserDataAccessObject){
        try{
            OpenNoteController openNoteController = createOpenNoteUseCase(viewManagerModel, openNoteViewModel, openNoteUserDataAccessObject);
            return new OpenNoteView(openNoteViewModel, openNoteController);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not open file.");
        }
        return null;
    }

    private static OpenNoteController createOpenNoteUseCase(
            ViewManagerModel viewManagerModel,
            OpenNoteViewModel openNoteViewModel,
            OpenNoteUserDataAccessInterface openNoteUserDataAccessObject) throws IOException{

        OpenNoteOutputBoundary openNoteOutputBoundary = new OpenNotePresenter(viewManagerModel, openNoteViewModel);
        NoteFactory userFactory = new CommonNoteFactory();
        OpenNoteInputBoundary openNoteInteractor = new OpenNoteInteractor(openNoteUserDataAccessObject, openNoteOutputBoundary);

        return new OpenNoteController(openNoteInteractor);

    }

}
