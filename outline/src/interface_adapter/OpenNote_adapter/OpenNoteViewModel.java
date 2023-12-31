package interface_adapter.OpenNote_adapter;

import app.OpenNoteUseCaseFactory;
import interface_adapter.OpenNote_adapter.OpenNoteState;
import interface_adapter.ViewModel;
import use_case.OpenNote_case.OpenNoteInputData;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenNoteViewModel extends ViewModel {
    public final String TITLE_LABEL = "OpenNote View";
    public static final String OPEN_BUTTON_LABEL = "Open";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String NEW_BUTTON_LABEL = "New";
    private static OpenNoteState state = new OpenNoteState();

    public OpenNoteViewModel() {
        super("open note");
    }

    public void setState(OpenNoteState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static OpenNoteState getState() {
        return state;
    }
}
