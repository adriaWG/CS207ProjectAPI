package interface_adapter.OutNote_adapter;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OutNoteViewModel extends ViewModel {
    public final String EXPORT_BUTTON_LABEL = "Export Note View";

    private static OutNoteState state = new OutNoteState();

    public OutNoteViewModel() {
        super("out note");
    }

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
