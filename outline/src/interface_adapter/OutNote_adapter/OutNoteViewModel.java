package interface_adapter.OutNote_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OutNoteViewModel {
    public final String TITLE_LABEL = "OutNote View";

    private static OutNoteState state = new OutNoteState();

    public void setState(OutNoteState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static OutNoteState getState() {
        return state;
    }
}
