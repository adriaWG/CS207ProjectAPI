package app;

public class Main {

    // Manages current view
    ViewManagerModel viewManagerModel = new ViewManagerModel();

    OpenNoteView openNoteView = OpenNoteUseFactory.create(viewManagerModel, EditNoteViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);
}
