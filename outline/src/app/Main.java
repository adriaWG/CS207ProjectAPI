package app;

import data_access.FileUserDataAccessObject;
import entity.CommonNoteFactory;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;
import interface_adapter.OutNote_adapter.OutNoteController;
import interface_adapter.OutNote_adapter.OutNoteViewModel;
import interface_adapter.ViewManagerModel;
import view.EditNoteView;
import view.OpenNoteView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Notes");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        OpenNoteViewModel openNoteViewModel = new OpenNoteViewModel();
        EditNoteViewModel editNoteViewModel = new EditNoteViewModel();
        OutNoteViewModel outNoteViewModel = new OutNoteViewModel();
        ClearNoteViewModel clearNoteViewModel = new ClearNoteViewModel();

        //not sure about the type and value of DAO,just to fix bugs
        FileUserDataAccessObject openNoteUserDataAccessObject;
        FileUserDataAccessObject editNoteUserDataAccessObject;
        FileUserDataAccessObject outNoteUserDataAccessObject;
        FileUserDataAccessObject clearNoteUserDataAccessObject;

        try {
            openNoteUserDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonNoteFactory());
            editNoteUserDataAccessObject=openNoteUserDataAccessObject;
            outNoteUserDataAccessObject=openNoteUserDataAccessObject;
            clearNoteUserDataAccessObject=openNoteUserDataAccessObject;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //changed the parameters according to create method in EditNoteUseCaseFactory, not sure whether it works yet
        OpenNoteView openNoteView = OpenNoteUseCaseFactory.create(viewManagerModel, openNoteViewModel, editNoteViewModel,openNoteUserDataAccessObject);
        views.add(openNoteView, openNoteView.viewName);

        EditNoteView editNoteView = EditNoteUseCaseFactory.create(viewManagerModel, editNoteViewModel, editNoteUserDataAccessObject,outNoteViewModel, outNoteUserDataAccessObject,clearNoteViewModel, clearNoteUserDataAccessObject);
        views.add(editNoteView, editNoteView.viewName);

        viewManagerModel.setActiveView(openNoteView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}

