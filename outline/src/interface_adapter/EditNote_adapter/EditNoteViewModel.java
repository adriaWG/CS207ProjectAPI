package interface_adapter.EditNote_adapter;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditNoteViewModel extends ViewModel {
    public final String TITLE_LABEL = "Edit Note View";


    //buttons that we need on edit note
    public static final String SAVE_BUTTON_LABEL = "Save";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private EditNoteState state = new EditNoteState();

    public  EditNoteViewModel() {
        super("edit note");
    }

    public void setState(EditNoteState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditNoteState getState() {
        return state;
    }
}
