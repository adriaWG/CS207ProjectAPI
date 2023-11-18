package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;
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
        EditNoteViewModel loginViewModel = new EditNoteViewModel();
        OpenNoteViewModel loggedInViewModel = new OpenNoteViewModel();

        FileUserDataAccessObject userDataAccessObject;
        FileUserDataAccessObject userDataAccessObject1;

        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
            userDataAccessObject1=userDataAccessObject;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        EditNoteView editNoteView = EditNoteUseCaseFactory.create(viewManagerModel, clearViewModel, loginViewModel, signupViewModel, userDataAccessObject,userDataAccessObject1);
        views.add(editNoteView, editNoteView.viewName);

        OpenNoteView openNoteView = OpenNoteUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        views.add(openNoteView, openNoteView.viewName);

        viewManagerModel.setActiveView(XXXView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}

